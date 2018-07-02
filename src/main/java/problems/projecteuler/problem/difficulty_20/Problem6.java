package problems.projecteuler.problem.difficulty_20;

import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ProjectEulerMath;

import java.util.logging.Logger;

/**
 * Created by yarbong on 27/06/2018.
 * The sum of the squares of the first ten natural numbers is,
 *
 * (1x1) + (2x2) + ... + (10x10) = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)x(1 + 2 + ... + 10) = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * sum = limit(limit + 1)/2
 * sum sq = (2limit + 1)(limit + 1)limit/6
 */
public class Problem6 implements Problem {

    private static Logger LOGGER = Logger.getLogger(Problem6.class.getName());
    public void solve(){

        LOGGER.info("{} Start!! "+this.getClass().getName());
        int x = 100;
        int theSum = theSumOfTheSquaresOfTheFirstXNaturalNumbers(x);
        int theSquare = theSquareOfTheSumOftheFirstXNaturalNumbers(x);

        if(theSum > theSquare)
            System.out.println(theSum - theSquare);
        else
            System.out.println(theSquare - theSum);

    }

    public int theSumOfTheSquaresOfTheFirstXNaturalNumbers(int x){
        //재귀
        if(x==1) {
            return (x*x);
        }
        return (x*x) + theSumOfTheSquaresOfTheFirstXNaturalNumbers(x-1);
    }

    public int theSquareOfTheSumOftheFirstXNaturalNumbers(int x){

        return (ProjectEulerMath.sumNaturalNumbers(x)
                * ProjectEulerMath.sumNaturalNumbers(x));
    }
}
