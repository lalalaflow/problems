package problems.projecteuler.problem.difficulty_20;

import org.junit.Before;
import org.junit.Test;
import problems.projecteuler.problem.Problem;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 22/01/2017.
 */
public class Problem5Test {
    Problem problem5;

    @Before
    public void setUp() throws Exception {
        problem5 = new Problem5();
    }

    @Test
    public void testSolve() throws Exception {
        problem5.solve();
    }

}