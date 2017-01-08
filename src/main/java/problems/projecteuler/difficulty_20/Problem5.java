package problems.projecteuler.difficulty_20;

import java.util.HashSet;
import java.util.Iterator;

public class Problem5 {
    public Problem5() {
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        problem5.solve(10);
    }

    public void solve(int maxNumber) {
        HashSet multipleNumbers = new HashSet();
        HashSet commonDividers = new HashSet();

        int smallestMultiple;
        for(smallestMultiple = maxNumber; smallestMultiple > 0; --smallestMultiple) {
            for(int h = smallestMultiple; h > 0; --h) {
                if(smallestMultiple % h != 0) {
                    multipleNumbers.add(Integer.valueOf(h));
                } else if(h < smallestMultiple) {
                    commonDividers.add(Integer.valueOf(h));
                }
            }
        }

        multipleNumbers.add(Integer.valueOf(maxNumber));
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
