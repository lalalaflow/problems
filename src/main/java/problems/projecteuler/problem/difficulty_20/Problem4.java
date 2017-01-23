package problems.projecteuler.problem.difficulty_20;

import problems.projecteuler.problem.Problem;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer : 906609
 */
public class Problem4  implements Problem {

    public void solve() {

        System.out.println("The Largest Palindrome v1: " + getLargestPalindrome_v1());
        System.out.println("The Largest Palindrome v2: " + getLargestPalindrome_v2());
    }

    /**
     * To get the biggest value for the first,
     * control ordering of numbers by making the set in every 100th
     * 가장 큰 숫자부터 100개씩 세트를 만들어 가장 큰 숫자(999)부터 해당 세트 숫자까지 먼저 곱하므로써
     * 곱셈 결과(펠린드롬)가 가장 큰 값부터 나오도록 제어
     * @return
     * Average between 0ms and 3ms
     */
    public int getLargestPalindrome_v2() {
        int largestPalindrome = 0;
        int num3digit = 999;
        int set = 0;

        // 100단위로 줄어들 도록 조건을 제한, e.g.)999, 899, 799 ...
        O : for(int theNum = this.getTheNum(num3digit, set); theNum >= 100;
                theNum = this.getTheNum(num3digit, set)) {
            // 큰 숫자로 부터 100개씩을 먼저 실행하도록 조건 제한 e.g.) 999~899, 899~799, 799~699 ...
            M : for(int t = theNum; t >= theNum - 100 && t >= 100; --t) {
                // e.g.)999~899, 999~799, 999~699 ...
                I : for(int h = num3digit; h >= theNum - 100 && h >= 100; --h) {
                    int palindrome = t * h;
                    if(this.isSameToReadInBothSide(palindrome)) {
                        largestPalindrome = palindrome;
                        break O;
                    }
                }
            }
            ++set;
        }
        return largestPalindrome;
    }

    /**
     * Just multiply each of number(t) from 999 to 100
     * to number(h) from the number(t) to 100 at once.
     * 가장 큰 세자리 숫자(999)부터 해당숫자부터 100까지 모두 곱해보고 다음 숫자로 넘어가는 방법
     * @return
     * Average between 55ms and 95ms
     */
    public int getLargestPalindrome_v1() {
        int largestPalindrome = 0;

        for(int t = 999; t >= 100; --t) {
            for(int h = t; h >= 100; --h) {
                int palindrome = t * h;
                if(this.isSameToReadInBothSide(palindrome)) {
                    if(largestPalindrome < palindrome) {
                        largestPalindrome = palindrome;
                        break;  // 현재 곱한 수 보다 작은 수를 곱한 결과는 현재 결과보다 당연히 작다
                    }
                }
            }
        }

        return largestPalindrome;
    }

    private int getTheNum(int number3digit, int set) {

        return number3digit - (set * 100);
    }

    private boolean isSameToReadInBothSide(int num) {
        boolean isSame = true;
        String sNum = Integer.toString(num);
        int midIdx = sNum.length() / 2;
        int f = 0;

        for(int b = sNum.length() - 1; b >= midIdx; --b) {
            if(sNum.charAt(f) != sNum.charAt(b)) {
                isSame = false;
            }

            ++f;
        }

        return isSame;
    }

}
