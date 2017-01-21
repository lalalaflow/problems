package problems.projecteuler.difficulty_20;

import problems.projecteuler.problem.Problem;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4  implements Problem {

    public void solve() {
        int largestPalindrome = this.getLargestPalindrome();
        if(largestPalindrome > 0) {
            System.out.println("The Largest Palindrome is " + largestPalindrome);
        }

        System.out.println("The system cannot find the Largest Palindrome.");
    }

    public int getLargestPalindrome() {
        long currentTime = System.currentTimeMillis();
        int largestPalindrome = 0;

        for(int t = 999; t >= 100; --t) {
            for(int h = t; h >= 100; --h) {
                int palindrome = t * h;
                if(this.isSame(palindrome)) {
                    System.out.println(t + " x " + h);
                    System.out.println("Time " + (System.currentTimeMillis() - currentTime));
                    if(largestPalindrome < palindrome) {
                        largestPalindrome = palindrome;
                    }
                }
            }
        }

        return largestPalindrome;
    }

    public boolean isSame(int number) {
        String sNumber = Integer.toString(number);
        int midIdx = sNumber.length() / 2;
        int a = 0;
        boolean isSame = true;

        for(int t = sNumber.length() - 1; t >= midIdx && isSame; --t) {
            if(sNumber.charAt(a) != sNumber.charAt(t)) {
                isSame = false;
            }

            ++a;
        }

        return isSame;
    }

    public int backwardReading(int number) {
        String sNumber = Integer.toString(number);
        String backwardNumber = "";

        for(int t = sNumber.length() - 1; t >= 0; --t) {
            backwardNumber = backwardNumber + sNumber.charAt(t);
        }

        return Integer.valueOf(backwardNumber).intValue();
    }
}
