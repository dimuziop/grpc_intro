package initial.server.calculator.domain.commands;

import java.util.List;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 15:22
 */
public interface PrimeNumberDecomposition {
    List<Integer> execute(int a);
}
