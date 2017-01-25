package problems.codingtest.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 21/01/2017.
 */
public class Task4Test {
    private Task4 task4test;
    String[] blocks = {"5", "-2", "4", "Z", "X", "12", "+", "6","10"};
    @Before
    public void setUp() throws Exception {
        task4test = new Task4();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTotalScore() throws Exception {
        assertEquals(27, Task4.totalScore(blocks, blocks.length));


    } @Test
    public void testTotalScore_v2() throws Exception {
        assertEquals(27, Task4.totalScore_v2(blocks, blocks.length));


    }

}