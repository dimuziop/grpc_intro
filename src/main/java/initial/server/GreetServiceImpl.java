package initial.server;

import dev.dimuziop.greet.GreetRequest;
import dev.dimuziop.greet.GreetResponse;
import dev.dimuziop.greet.GreetServiceGrpc;
import dev.dimuziop.greet.Greeting;
import io.grpc.stub.StreamObserver;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 12:33
 */
public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();

        String result = String.format("Hello %s %s", firstName, lastName);
        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
