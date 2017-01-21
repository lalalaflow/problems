package problems.projecteuler.difficulty_20;

import java.util.ArrayList;
import java.util.List;
import problems.projecteuler.problem.AbstractProblem;
import problems.projecteuler.util.ProjectEulerMath;

/**
 * @author lalalaflow
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 */
public class Problem3 extends AbstractProblem {
    public Problem3() {
        super(600851475143L);
    }

    public void solve() {
        List primeFactors = this.findPrimeFactors(this.lLimitNumber);
        System.out.print("The largest number of Prime Factors out of " + primeFactors.toString() + " is ");
        System.out.println(primeFactors.get(primeFactors.size() - 1));
    }

    private List<Long> findPrimeFactors(long number) {
        ArrayList primeFactors = new ArrayList();
        System.out.println("The number to factronise : " + number);

        for(long t = 2L; t <= number; ++t) {
            if(ProjectEulerMath.mod(number, t) == 0L) {
                number /= t;
                primeFactors.add(Long.valueOf(t));
                --t;
            }
        }

        return primeFactors;
    }
}
