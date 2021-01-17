package initial.client.calculator;

import dev.dimuziop.calculator.*;
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

        CalculatorServiceGrpc.CalculatorServiceBlockingStub service = CalculatorServiceGrpc.newBlockingStub(channel);

        /*Sum sym = Sum.newBuilder().setA(5).setB(10).build();

        SumRequest sumRequest = SumRequest.newBuilder().setCommand(sym).build();

        SumResponse sumResponse = sumServiceStub.sum(sumRequest);

        System.out.println(sumResponse.getResponse());*/

        PrimeNumberDecompositionRequest request = PrimeNumberDecompositionRequest.newBuilder()
                .setA(IntegerMonomial.newBuilder().setA(120).build())
                .build();

        service.primeNumberDecomposition(request).forEachRemaining(response -> {
            System.out.println(response.getResponse());
        });

        channel.shutdown();
    }
}
