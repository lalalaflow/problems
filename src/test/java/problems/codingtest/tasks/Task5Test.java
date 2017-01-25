package problems.codingtest.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 24/01/2017.
 */
public class Task5Test {
    private Task5 task5;
    @Before
    public void setUp() throws Exception {
        task5 = new Task5();
    }

    @Test
    public void solve() throws Exception {
        assertNull(task5.solve(null, 0));
    }

}