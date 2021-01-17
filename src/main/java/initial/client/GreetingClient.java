package initial.client;

import dev.dimuziop.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * User: patricio
 * Date: 15/1/21
 * Time: 20:40
 */
public class GreetingClient {
    public static void main(String[] args) {
        System.out.println(" hello to my grcp cleint");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        // DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);
        // DummyServiceGrpc.DummyServiceFutureStub syncClient = DummyServiceGrpc.newFutureStub(channel);

        GreetServiceGrpc.GreetServiceBlockingStub greetServiceBlockingStub = GreetServiceGrpc.newBlockingStub(channel);

        /*Greeting greeting = Greeting.newBuilder().setFirstName("Patricio").setLastName("Di Muzio").build();

        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();

        GreetResponse greetResponse = greetServiceBlockingStub.greet(greetRequest);

        System.out.println(greetResponse.getResult());*/

        GreetManyTimesRequest greetManyTimesRequest = GreetManyTimesRequest
                .newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Patricio")
                        .setLastName("Di Muzio")
                        .build())
                .build();

        greetServiceBlockingStub.greetManyTimes(greetManyTimesRequest)
                .forEachRemaining(greetManyTimesResponse -> System.out.println(greetManyTimesResponse.getResult()));

        channel.shutdown();

    }
}
