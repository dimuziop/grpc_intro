package initial.server.calculator.infrastructure;

import dev.dimuziop.calculator.Sum;
import dev.dimuziop.calculator.SumRequest;
import dev.dimuziop.calculator.SumResponse;
import dev.dimuziop.calculator.SumServiceGrpc;
import initial.server.calculator.domain.Calculate;
import io.grpc.stub.StreamObserver;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 13:16
 */
public class CalculateServiceImpl extends SumServiceGrpc.SumServiceImplBase {

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
}
