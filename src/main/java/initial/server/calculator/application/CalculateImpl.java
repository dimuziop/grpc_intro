package initial.server.calculator.application;

import initial.server.calculator.domain.Calculate;
import initial.server.calculator.domain.commands.PrimeNumberDecomposition;
import initial.server.calculator.domain.commands.Sum;

import javax.inject.Inject;
import java.util.List;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 13:03
 */
public class CalculateImpl implements Calculate {

    private final Sum sumCommand;
    private final PrimeNumberDecomposition primeNumberDecomposition;

    @Inject
    public CalculateImpl (Sum sum, PrimeNumberDecomposition primeNumberDecomposition) {
        this.sumCommand = sum;
        this.primeNumberDecomposition = primeNumberDecomposition;
    }

    @Override
    public int sum(int a, int b) {
        return this.sumCommand.execute(a, b);
    }

    @Override
    public List<Integer> getPrimeNumbers(int a) {
        return this.primeNumberDecomposition.execute(a);
    }
}
