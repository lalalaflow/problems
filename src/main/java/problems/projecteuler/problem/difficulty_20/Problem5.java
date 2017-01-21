package problems.projecteuler.problem.difficulty_20;

import problems.projecteuler.problem.Problem;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 implements Problem{

    int maxNum;

    Problem5(){
        this(10);
    }

    Problem5(int maxNum){
        this.maxNum = maxNum;
    }

    public void solve(){
        smallestMultiple(maxNum);
    }

    public void smallestMultiple(int maxNum) {
        HashSet multipleNumbers = new HashSet();
        HashSet commonDividers = new HashSet();

        int smallestMultiple;
        for(smallestMultiple = maxNum; smallestMultiple > 0; --smallestMultiple) {
            for(int h = smallestMultiple; h > 0; --h) {
                if(smallestMultiple % h != 0) {
                    multipleNumbers.add(Integer.valueOf(h));
                } else if(h < smallestMultiple) {
                    commonDividers.add(Integer.valueOf(h));
                }
            }
        }

        multipleNumbers.add(Integer.valueOf(maxNum));
        smallestMultiple = 1;
        Iterator var7 = multipleNumbers.iterator();

        while(var7.hasNext()) {
            Integer number = (Integer)var7.next();
            if(!commonDividers.contains(number)) {
                System.out.print(number + " , ");
                smallestMultiple *= number.intValue();
            }
        }

        System.out.println(multipleNumbers.toString());
        System.out.println(commonDividers.toString());
        System.out.println(smallestMultiple);
    }
}
