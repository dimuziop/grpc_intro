package greeting.client.calculator;

import dev.dimuziop.calculator.SumRequest;
import dev.dimuziop.calculator.SumResponse;
import dev.dimuziop.calculator.SumServiceGrpc;
import dev.dimuziop.calculator.Sum;
import dev.dimuziop.greet.GreetResponse;
import dev.dimuziop.greet.GreetServiceGrpc;
import dev.dimuziop.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 13:29
 */
public class CalculatorClient {
    public static void main(String[] args) {
        System.out.println(" hello to my gRPC client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        SumServiceGrpc.SumServiceBlockingStub sumServiceStub = SumServiceGrpc.newBlockingStub(channel);

        Sum sym = Sum.newBuilder().setA(5).setB(10).build();

        SumRequest sumRequest = SumRequest.newBuilder().setCommand(sym).build();

        SumResponse sumResponse = sumServiceStub.sum(sumRequest);

        System.out.println(sumResponse.getResponse());

        channel.shutdown();
    }
}
