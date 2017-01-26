package problems.projecteuler.problem.difficulty_20;

import java.util.List;

import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ProjectEulerMath;

/**
 * @author lalalaflow
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Anser : 6857
 * **tip for another way : every number n can at most have one prime factor greater than sqrt(n)(Math.round(Math.sqrt(num))) .
 */
public class Problem3 implements Problem {

    long limitNum;
    public Problem3() {

        this(600851475143L);
    }
    public Problem3(long limitNum){
        this.limitNum = limitNum;
    }

    public void solve() {
        List<Long> primeFactors = ProjectEulerMath.findPrimeFactors(this.limitNum);
        System.out.print("The largest number of Prime Factors out of " + primeFactors.toString() + " is ");
        System.out.println(primeFactors.get(primeFactors.size()-1));
    }


}
