package problems.codility.demo;

public class Equilibrium {
    public Equilibrium() {
    }

    public int solution(int[] A) {
        boolean p = true;
        int n = A.length;
        int midP = n / 2 - 1;
        long sumHalfLeft = this.sumValues(A, 0, midP, 0L);
        long sumHalfRight = this.sumValues(A, midP + 1, n, 0L);
        int var20;
        if(sumHalfLeft == sumHalfRight) {
            var20 = midP;
        } else {
            var20 = -1;
        }

        int sIdx = 0;
        int eIdx = midP - 1;
        long halfLeft = 0L;
        long halfRight = sumHalfRight;

        while(var20 == -1 && sIdx < n) {
            for(int t = sIdx; t < eIdx; ++t) {
                long sumLeft;
                if(t == 0) {
                    sumLeft = 0L;
                } else {
                    sumLeft = this.sumValues(A, sIdx + 1, t, halfLeft);
                }

                long sumRight;
                if(t == n - 1) {
                    sumRight = 0L;
                } else {
                    sumRight = this.sumValues(A, t + 1, eIdx, halfRight);
                }

                if(sumLeft == sumRight) {
                    var20 = t;
                }

                if(t + 1 == eIdx) {
                    sIdx = eIdx;
                    eIdx = n;
                    halfLeft = sumHalfLeft;
                    halfRight = 0L;
                }
            }
        }

        return var20;
    }

    public long sumValues(int[] V, int sIdx, int eIdx, long sumHalf) {
        long sum = 0L;

        for(int t = sIdx; t < eIdx; ++t) {
            sum += (long)V[t] + sumHalf;
        }

        return sum;
    }


    public static void main(String[] args) {
        Equilibrium equilibrium = new Equilibrium();
        int[] A = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};
        int p = equilibrium.solution(A);
        System.out.println("The position : " + p);
    }

}
