package problems.projecteuler.problem.difficulty_20;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import problems.projecteuler.problem.Problem;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 22/01/2017.
 */
public class Problem4Test {
    Problem4 problem4;
    @Before
    public void setUp() throws Exception {
        problem4 = new Problem4();
    }

    @Ignore
    public void testSolve() throws Exception {
        problem4.solve();
    }

    @Test
    public void testGetLargestPalindrome_v1() throws Exception{
        assertEquals(906609, problem4.getLargestPalindrome_v1());
    }

    @Test
    public void testGetLargestPalindrome_v2() throws Exception{
        assertEquals(906609, problem4.getLargestPalindrome_v2());
    }



}