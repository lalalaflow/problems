package problems.projecteuler.difficulty_20;

public class Problem4_1 {
    public Problem4_1() {
    }

    public static void main(String[] args) {
        Problem4_1 problem4_1 = new Problem4_1();
        System.out.println("The Largest Palindrome : " + problem4_1.solution());
    }

    public int solution() {
        byte largestPalindrome = 0;
        short number3digit = 999;
        int totalSet = number3digit / 9;
        int set = 0;

        for(int theNumber = this.getTheNumber(number3digit, set); theNumber >= 100; theNumber = this.getTheNumber(number3digit, set)) {
            for(int t = theNumber; t >= theNumber - 100 && t >= 100; --t) {
                for(int h = number3digit; h >= theNumber - 100 && h >= 100; --h) {
                    int palindrome = t * h;
                    if(this.isSameRadingBackword(palindrome)) {
                        return palindrome;
                    }
                }
            }

            ++set;
        }

        System.out.println("The Largest Palindrome : " + largestPalindrome);
        return largestPalindrome;
    }

    private int getTheNumber(int number3digit, int set) {
        return number3digit - set * 100;
    }

    public boolean isSameRadingBackword(int number) {
        boolean isSame = true;
        String sNumber = Integer.toString(number);
        int midIdx = sNumber.length() / 2;
        int f = 0;

        for(int b = sNumber.length() - 1; b >= midIdx; --b) {
            if(sNumber.charAt(f) != sNumber.charAt(b)) {
                isSame = false;
            }

            ++f;
        }

        return isSame;
    }
}
