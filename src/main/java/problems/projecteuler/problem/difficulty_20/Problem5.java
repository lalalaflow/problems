package problems.projecteuler.problem.difficulty_20;

import problems.projecteuler.problem.Problem;
import problems.projecteuler.util.ProjectEulerMath;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 2520 is the smallest number that can be divided
 * by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible
 * by all of the numbers from 1 to 20?
 *
 * 232792560
 */
public class Problem5 implements Problem{

    long maxNum;

    Problem5(){
        this(10);
    }

    Problem5(long maxNum){
        this.maxNum = maxNum;
    }

    public void solve(){
        /**
         * 1~20의 최소 공배수를 구하는 문제
         * 1~20의 공약수를 구해서 배열에 저장 (소인수로, 1개 이상일 경우 각각 저장 예 ) 2,2,3,2...
         *  - 각 배열을 통해 1~20까지 숫자를 나누어 가며
         * 공약수 배열에 있는 수를 모두 곱한 수가 정답
         */
        System.out.println("20 =>"+(5L*16L*9L*7L*11L*13L*17L*19L));
        System.out.println("10 => " + (5L*7L*8L*9L));
        smallestMultiple_v1(maxNum);
        smallestMultiple_v2(maxNum);
    }

    public void smallestMultiple_v1(long maxNum) {
        HashSet multipleNumbers = new HashSet();
        HashSet commonDividers = new HashSet();

        long smallestMultiple;
        for(smallestMultiple = maxNum; smallestMultiple > 0; --smallestMultiple) {
            for(long h = smallestMultiple; h > 0; --h) {
                if(smallestMultiple % h != 0) {
                    multipleNumbers.add(h);
                } else if(h < smallestMultiple) {
                    commonDividers.add(h);
                }
            }
        }

        multipleNumbers.add(maxNum);
        smallestMultiple = 1;
        Iterator var7 = multipleNumbers.iterator();

        while(var7.hasNext()) {
            Long number = (Long)var7.next();
            if(!commonDividers.contains(number)) {
                System.out.print(number + " , ");
                smallestMultiple *= number.longValue();
            }
        }

        System.out.println(multipleNumbers.toString());
        System.out.println(commonDividers.toString());
        System.out.println(smallestMultiple);
    }

    /**
     *
     * @param maxNum
     */
    public void smallestMultiple_v2(long maxNum){
        long result = maxNum;
        for(long t = maxNum-1; t > 0; t--){
            if(ProjectEulerMath.mod(maxNum,t) == 0){
                continue;
            }else{
                result *= t;
            }
        }
        System.out.println(result);
    }

    private int factorial(int num){
        if(num == 0) {
            return 1;
        } else {
            return num * factorial(num-1);
        }
    }
}
