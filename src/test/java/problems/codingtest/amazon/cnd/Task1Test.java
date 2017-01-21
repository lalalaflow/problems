package problems.codingtest.amazon.cnd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 21/01/2017.
 */
public class Task1Test {
    private Task1 task1test;

    @Before
    public void setUp() throws Exception {
        task1test = new Task1();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void solve() throws Exception {
        assertNull(task1test.solve());
    }

}