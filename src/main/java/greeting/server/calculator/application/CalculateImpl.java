package greeting.server.calculator.application;

import greeting.server.calculator.domain.Calculate;
import greeting.server.calculator.domain.commands.Sum;

import javax.inject.Inject;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 13:03
 */
public class CalculateImpl implements Calculate {

    final Sum sumCommand;

    @Inject
    public CalculateImpl (Sum sum) {
        this.sumCommand = sum;
    }

    @Override
    public int sum(int a, int b) {
        return this.sumCommand.execute(a, b);
    }
}
