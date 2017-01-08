package problems.projecteuler.difficulty_20;

import java.math.BigInteger;
import problems.projecteuler.problem.AbstractProblem;
/**
 * @author lalalaflow
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * Answer : 233,168
 */
public class Problem1 extends AbstractProblem {
    int number1 = 0;
    int number2 = 0;

    public Problem1() {
        super(1000);
        this.number1 = 3;
        this.number2 = 5;
    }

    public void solve() {
        this.sumAllTheMultiples();
    }

    public void sumAllTheMultiples() {
        System.out.println("Sum = " + (this.sumTheMultiples(this.number1) + this.sumTheMultiples(this.number2) - this.sumTheMultiples(this.getLCM(this.number1, this.number2))));
    }

    private int sumTheMultiples(int number) {
        int sum = number * this.sumNaturalNumbers(this.getMaxNumber(number));
        return sum;
    }

    private int sumNaturalNumbers(int maxNaturalNumber) {
        return maxNaturalNumber * (maxNaturalNumber + 1) / 2;
    }

    private int getMaxNumber(int number) {
        int maxTimes = this.iLimitNumber / number;
        if(this.getProjectEulerMath().mod(this.iLimitNumber, number) == 0) {
            --maxTimes;
        }

        return maxTimes;
    }

    private int getLCM(int number1, int number2) {
        return number1 * number2 / this.getGDC(number1, number2);
    }

    private int getGDC(int number1, int number2) {
        BigInteger bi1 = new BigInteger(Integer.toString(number1));
        BigInteger bi2 = new BigInteger(Integer.toString(number2));
        return bi1.gcd(bi2).intValue();
    }
}
