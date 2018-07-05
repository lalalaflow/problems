package problems.projecteuler.problem.difficulty_20;

import problems.projecteuler.problem.Problem;

import java.util.logging.Logger;

/**
 * Created by yarbong on 04/07/2018.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 * 자신과 1외에 나눠지는 수가 없는 수
 */
public class Problem7 implements Problem{

    private static Logger LOGGER = Logger.getLogger(Problem7.class.getName());

    public void solve() {

        int xThPrime = 10001;
        int ntrlNumber = 2;
        int i=1;
        while( true ){
            if(i == xThPrime) break;
            ++ntrlNumber;
            if(verifyPrimeNumber(ntrlNumber) == 1 ) {
                i++;
            }
        }
        System.out.printf("The %d th prime number is " + ntrlNumber, xThPrime);

    }

    private int verifyPrimeNumber(int x){
        int y = x;
        //를 자연수로 나누어서 나머지가 mod 0이 되면 반복문 벗어난다 소수가 아니다
        while(x > 1 && y > 0){
            --y;
            if( (x % y) == 0 ) break;
        }
        return y;
    }
}
