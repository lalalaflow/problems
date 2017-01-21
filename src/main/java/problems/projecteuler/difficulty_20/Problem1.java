package problems.projecteuler.difficulty_20;

import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ProjectEulerMath;

/**
 * @author lalalaflow
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * Answer : 233,168
 */
public class Problem1 implements Problem {
    int bNum;
    int sNum = 0;
    int limitNum = 0;

    public Problem1(){
        this(3, 5, 1000);
    }
    public Problem1(int a, int b, int limitNum) {
        if(a < b){
            int t = a;
            a = b;
            a = t;
        }
        this.bNum = a;
        this.sNum = b;
        this.limitNum = limitNum;
    }

    public void solve() {
        long start = System.currentTimeMillis();
        this.sumAllTheMultiples_v1();
        System.out.println("Time to run the first : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        this.sumAllTheMultiples_v2();
        System.out.println("Time to run the second : " + (System.currentTimeMillis() - start));
    }


    /**
     * The sum values of a number's multiples
     *      = the number * sum values of natural numbers that are divided by the number
     * e.g.) 3 + 6 + 9 = 3 * (1 + 2 + 3 )
     * @param number
     * @return
     */
    private int sumTheMultiples(int number) {
        int sum = number *
                ProjectEulerMath.sumNaturalNumbers(this.getMaxFactor(number));
        return sum;
    }

    /**
     * Get max number to multiple with the number that won't over ilimitNumber
     * @param number
     * @return
     */
    private int getMaxFactor(int number) {
        int maxTimes = this.limitNum / number;
        if(ProjectEulerMath.mod(this.limitNum, number) == 0) {
            --maxTimes;
        }

        return maxTimes;
    }


    /**
     * 1. Get the sum value of number1's multiples
     * 2. Get the sum value of number2's multiples
     * 3. Get the sum value of LCMs of number1 and number2
     * 4. ( result 1 + result 2 - result 3)
     */
    public void sumAllTheMultiples_v1() {
        System.out.println("Sum by the first way = " +
                (this.sumTheMultiples(this.bNum) + this.sumTheMultiples(this.sNum)
                        - this.sumTheMultiples(ProjectEulerMath.getLCM(this.bNum, this.sNum))));
    }

    /**
     * Another way
     * This is faster than the v1()
     */
    private void sumAllTheMultiples_v2() {
        int a = this.bNum , b = this.sNum;
        if(a < b){
            int t = a;
            a = b;
            a = t;
        }

        int sum1 = 0;
        for(int i = 1; i <= getMaxFactor(a); i++ ){
            int mul = (a * i);

            //Skip the multiples of b as it is duplicated in blow operation
            if(ProjectEulerMath.mod(mul,b) == 0) continue;

            sum1 += mul ;
        }

        int sum2 = 0;
        for(int i = 1; i <= getMaxFactor(b); i++ ){
            sum2 += (b * i);
        }

        System.out.println("Sum by the second way : " + (sum1 + sum2));
    }


}
