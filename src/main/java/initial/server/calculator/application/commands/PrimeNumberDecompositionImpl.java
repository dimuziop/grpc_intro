package initial.server.calculator.application.commands;

import initial.server.calculator.domain.commands.PrimeNumberDecomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * User: patricio
 * Date: 17/1/21
 * Time: 15:23
 */
public class PrimeNumberDecompositionImpl implements PrimeNumberDecomposition {
    @Override
    public List<Integer> execute(int a) {
        return this.decomposition(a);
    }

    private List<Integer> decomposition(int a) {
        List<Integer> results = new ArrayList<>();

        for(int i = 2; i< a; i++) {
            while(a % i == 0) {
                results.add(i);
                a = a/i;
            }
        }
        if(a >2) {
            results.add(a);
        }

        return results;
    }
}
