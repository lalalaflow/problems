package problems.projecteuler.problem.difficulty_20;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import problems.projecteuler.problem.Problem;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 22/01/2017.
 */
public class Problem3Test {
    Problem problem3;
    @Before
    public void setUp() throws Exception {
        problem3 = new Problem3();
    }

    @Test
    public void testSolve() throws Exception{

        problem3.solve();
    }

}