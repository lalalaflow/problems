package problems.projecteuler.problem.difficulty_20;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ReflectionUtils;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 22/01/2017.
 */
public class Problem2Test{
    Problem problem2;
    @Before
    public void setUp() throws Exception {
        problem2 = new Problem2();
    }

    @Test
    public void testSolve() throws Exception {
        problem2.solve();
    }

    /**
     * Needs to access to private method
     * @throws Exception
     */
    @Test
    public void testGetNextTerm() throws Exception{

        //assertThat( 5, Is.is(problem2.getNextTerm(2, 3)));

    }

}