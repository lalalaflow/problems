package problems.projecteuler.util;

import java.math.BigInteger;

/**
 * For useful function
 *
 * TODO : into static class
 */
public class ProjectEulerMath {
    public ProjectEulerMath() {
    }


    /**
     * mod for int
     * @param a
     * @param b
     * @return
     */
    public static int mod(int a, int b) {

        if(a < b){
            int t = a;
            a = b;
            a = t;
        }

        return (a % b);
    }

    /**
     * mod for long
     * @param a
     * @param b
     * @return
     */
    public static long mod(long a, long b) {

        if(a < b){
            long t = a;
            a = b;
            a = t;
        }
        return (a % b);
    }

    /**
     * sum values of natural numbers from 1 to a
     * @param a
     * @return
     */
    public static int sumNaturalNumbers(int a){

        return (a * (a + 1))/2;
    }

    /**
     * get LCM of the numbers
     * @param a
     * @param b
     * @return
     */
    public static int getLCM(int a, int b) {

        return (a * b / getGDC(a, b));
    }

    /**
     * get GDC of the numbers
     * @param a
     * @param b
     * @return
     */
    public static int getGDC(int a, int b) {
        BigInteger bi1 = new BigInteger(Integer.toString(a));
        BigInteger bi2 = new BigInteger(Integer.toString(b));
        return bi1.gcd(bi2).intValue();
    }
}
