package problems.projecteuler.problem.difficulty_20;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Problem7Test {
    static Problem7 problem7;

    @BeforeAll
    public static void setUp(){
        Problem7Test.problem7 = new Problem7();
    }

    @Test
    void testSolveProblem7() {
        problem7.solve();
    }


}
