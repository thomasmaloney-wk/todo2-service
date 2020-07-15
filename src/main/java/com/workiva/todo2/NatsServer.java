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

    public static void main(String[] args) throws TException, ClientOpenException {
        runApplication();
    }

    public static void runApplication() throws TException, ClientOpenException {
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
}