package problems.codingtest.amazon.uk;

public class Task1 {
    public Task1() {
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        int[][] A = new int[][]{{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2},
                                {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        int howManyCountries = task1.solution(A);
        System.out.println("Task 1 : " + howManyCountries);
    }

    public int solution(int[][] A) {
        int howManyCountries = 0;

        for(int t = 0; t < A.length; ++t) {
            for(int a = 0; a < A[0].length; ++a) {
                int currentColour = A[t][a];
                boolean isSameWest = false;
                if(a > 0 && currentColour == A[t][a - 1]) {
                    isSameWest = true;
                }

                boolean isSameNorth = false;
                if(t > 0 && currentColour == A[t - 1][a]) {
                    isSameNorth = true;
                }

                if(!isSameWest && !isSameNorth) {
                    ++howManyCountries;
                }

                if(isSameWest && isSameNorth) {
                    --howManyCountries;
                }
            }
        }

        return howManyCountries;
    }
}
