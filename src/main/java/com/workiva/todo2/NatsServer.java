package com.workiva.todo2;

import java.io.IOException;

import com.workiva.frugal.protocol.FProtocolFactory;
import com.workiva.frugal.provider.FScopeProvider;
import com.workiva.frugal.server.FNatsServer;
import com.workiva.frugal.server.FServer;

import com.workiva.frugal.transport.FNatsPublisherTransport;
import com.workiva.frugal.transport.FNatsSubscriberTransport;
import com.workiva.frugal.transport.FPublisherTransportFactory;
import com.workiva.frugal.transport.FSubscriberTransportFactory;
import com.workiva.messaging_sdk.MessagingClient;
import com.workiva.messaging_sdk.NatsMessagingClient;
import com.workiva.messaging_sdk.ServiceDescriptor;
import com.workiva.messaging_sdk.exception.ClientOpenException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import todo_transport.v1.FTodoService;
import todo_transport.v1.TodosPublisher;

public class NatsServer {
    public static final String SERVICE_SUBJECT = "todo2-service";

    public static void main(String[] args) throws IOException, InterruptedException, TException, ClientOpenException {
        runApplication();
    }

    public static void runApplication() throws IOException, InterruptedException, TException, ClientOpenException {
        // Specify the protocal used for serializing requests.
        // Clients must use the same protocal stack
        FProtocolFactory protocolFactory = new FProtocolFactory(new TBinaryProtocol.Factory());

        // Create a NATS messaging client
        NatsMessagingClient.Builder clientBuilder = new NatsMessagingClient.Builder();
        clientBuilder.withServerEventHandler(new NatsServerEventHandler(5000));
        MessagingClient client = clientBuilder.build();
        client.open();

        FScopeProvider provider = client.newPubSubProvider();
        TodosPublisher.Iface publisher = new TodosPublisher.Client(provider);
        publisher.open();

        // Create a new server processor.
        // Incoming requests to the server are passed to the processor.
        // Results from the processor are returned back to the client.
        FTodoService.Processor processor = new FTodoService.Processor(new FTodoServiceHandler(publisher), new LoggingMiddleware());

        // Create a new todo2 server using the processor.
        // The server can be configured using the Builder interface.
        ServiceDescriptor service = new ServiceDescriptor.Builder().withNatsSubject(SERVICE_SUBJECT).build();
        FServer server = client.newServer(service, processor);

        System.out.println("Starting nats server on " + SERVICE_SUBJECT);
        server.serve();
    }

    public static void mainBackup() throws IOException, InterruptedException, TException {
        // Specify the protocal used for serializing requests.
        // Clients must use the same protocal stack
        FProtocolFactory protocolFactory = new FProtocolFactory(new TBinaryProtocol.Factory());

        // Create a NATS client (using default options for local dev)
        Options.Builder optionsBuilder = new Options.Builder().server(Options.DEFAULT_URL);
        Connection conn = Nats.connect(optionsBuilder.build());

        // Create the pubsub scope provider, given the NATs connection and protocol
        FPublisherTransportFactory publisherFactory = new FNatsPublisherTransport.Factory(conn);
        FSubscriberTransportFactory subscriberFactory = new FNatsSubscriberTransport.Factory(conn);
        FScopeProvider provider = new FScopeProvider(publisherFactory, subscriberFactory, protocolFactory);

        TodosPublisher.Iface client = new TodosPublisher.Client(provider, new LoggingMiddleware());
        client.open();

        // Create a new server processor.
        // Incoming requests to the server are passed to the processor.
        // Results from the processor are returned back to the client.
        FTodoService.Processor processor = new FTodoService.Processor(new FTodoServiceHandler(client), new LoggingMiddleware());

        // Create a new todo2 service server using the processor
        // The server can be configured using the Builder interface.
        FServer server =
                new FNatsServer.Builder(conn, processor, protocolFactory, new String[]{SERVICE_SUBJECT})
                        .withQueueGroup(SERVICE_SUBJECT) // if set, all servers listen to the same queue group
                        .build();

        System.out.println("Starting nats server on " + SERVICE_SUBJECT);
        server.serve();
    }
}