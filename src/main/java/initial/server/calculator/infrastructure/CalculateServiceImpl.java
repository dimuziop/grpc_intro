package initial.server.calculator.infrastructure;

import dev.dimuziop.calculator.*;
import initial.server.calculator.domain.Calculate;
import io.grpc.stub.StreamObserver;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 13:16
 */
public class CalculateServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    final Calculate calculate;

    public CalculateServiceImpl(Calculate calculate) {
        this.calculate = calculate;
    }

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        Sum sum = request.getCommand();
        int a = sum.getA();
        int b = sum.getB();

        int result = this.calculate.sum(a, b);

        SumResponse sumResponse = SumResponse.newBuilder().setResponse(result).build();

        responseObserver.onNext(sumResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void primeNumberDecomposition(PrimeNumberDecompositionRequest request, StreamObserver<PrimeNumberDecompositionResponse> responseObserver) {
        IntegerMonomial a = request.getA();

        try {
            this.calculate.getPrimeNumbers(a.getA()).forEach((primary -> {
                PrimeNumberDecompositionResponse response = PrimeNumberDecompositionResponse.newBuilder().setResponse(primary).build();
                responseObserver.onNext(response);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }


    }
}
