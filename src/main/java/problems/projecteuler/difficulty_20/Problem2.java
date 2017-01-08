package problems.projecteuler.difficulty_20;

import java.util.ArrayList;
import java.util.List;
import problems.projecteuler.problem.AbstractProblem;
/**
 * @author lalalaflow
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 extends AbstractProblem {
    public Problem2() {
        super(4000000);
    }

    public void solve() {
        List fibonacciSequences = this.findEvenFibonacciSequence(super.iLimitNumber);
        System.out.println("The sum of the even-valued terms : " + this.sumFibonacciSequence(fibonacciSequences));
    }

    private List<Integer> findEvenFibonacciSequence(int limitNumber) {
        ArrayList fibonacciSequences = new ArrayList();
        int value1 = 0;

        int nextTerm;
        for(int value2 = 1; value2 <= limitNumber; value2 = nextTerm) {
            if(this.ifEvenValue(value2)) {
                fibonacciSequences.add(Integer.valueOf(value2));
            }

            nextTerm = this.getNextTerm(value1, value2);
            value1 = value2;
        }

        return fibonacciSequences;
    }

    private int getNextTerm(int value1, int value2) {
        return value1 + value2;
    }

    private boolean ifEvenValue(int number) {
        return this.getProjectEulerMath().mod(number, 2) == 0;
    }

    private int sumFibonacciSequence(List<Integer> fibonacciSequences) {
        int sum = 0;

        for(int i = 0; i < fibonacciSequences.size(); ++i) {
            sum += ((Integer)fibonacciSequences.get(i)).intValue();
        }

        return sum;
    }
}
