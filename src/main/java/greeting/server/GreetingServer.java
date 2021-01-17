package greeting.server;

import eu.lestard.easydi.EasyDI;
import greeting.server.calculator.application.CalculateImpl;
import greeting.server.calculator.application.commands.SumImpl;
import greeting.server.calculator.domain.Calculate;
import greeting.server.calculator.domain.commands.Sum;
import greeting.server.calculator.infrastructure.CalculateServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * User: patricio
 * Date: 15/1/21
 * Time: 20:27
 */
public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");

        EasyDI easyDI = new EasyDI();
        easyDI.bindInterface(Sum.class, SumImpl.class);
        easyDI.bindInterface(Calculate.class, CalculateImpl.class);

        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .addService(new CalculateServiceImpl(easyDI.getInstance(Calculate.class)))
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Receive Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped");
        }));

        server.awaitTermination();
    }

}
