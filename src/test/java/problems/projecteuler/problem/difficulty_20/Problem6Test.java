package problems.projecteuler.problem.difficulty_20;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yarbong on 30/06/2018.
 */
public class Problem6Test {
    Problem6 problem6;
    int x;
    @Before
    public void setUp() throws Exception{
        problem6 = new Problem6();
        x = 10;
    }

    @Test
    public void testTheSumOfTheSquareOfTheFirstXNaturalNumbers() throws Exception{

        int result = problem6.theSumOfTheSquaresOfTheFirstXNaturalNumbers(this.x);

        Assert.assertEquals(385, result);
    }

    @Test
    public void testTheSquareOfTheSumOftheFirstXNaturalNumbers(){

        int result  = problem6.theSquareOfTheSumOftheFirstXNaturalNumbers(x);
        Assert.assertEquals(3025, result);
    }


}
