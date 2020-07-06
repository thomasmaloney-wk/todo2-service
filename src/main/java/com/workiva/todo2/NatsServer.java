package com.workiva.todo2;

import java.io.IOException;

import com.workiva.frugal.protocol.FProtocolFactory;
import com.workiva.frugal.server.FNatsServer;
import com.workiva.frugal.server.FServer;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import todo_transport.v1.FTodoService;

public class NatsServer {
    public static final String SERVICE_SUBJECT = "todo2-service";

    public static void main(String[] args) throws IOException, InterruptedException, TException {
        // Specify the protocal used for serializing requests.
        // Clients must use the same protocal stack
        FProtocolFactory protocolFactory = new FProtocolFactory(new TBinaryProtocol.Factory());

        // Create a NATS client (using default options for local dev)
        Options.Builder optionsBuilder = new Options.Builder().server(Options.DEFAULT_URL);
        Connection conn = Nats.connect(optionsBuilder.build());

        // Create a new server processor.
        // Incoming requests to the server are passed to the processor.
        // Results from the processor are returned back to the client.
        FTodoService.Processor processor = new FTodoService.Processor(new FTodoServiceHandler(), new LoggingMiddleware());

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