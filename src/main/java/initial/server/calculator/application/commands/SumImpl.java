package initial.server.calculator.application.commands;

import initial.server.calculator.domain.commands.Sum;

public class SumImpl implements Sum {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
