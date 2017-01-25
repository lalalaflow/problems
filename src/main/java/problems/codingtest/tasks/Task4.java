package problems.codingtest.tasks;

import java.util.Arrays;

/**
 * Created by yarbong on 21/01/2017.
 */
public class Task4 {
    String[] blocks = {"5", "-2", "4", "Z", "X", "12", "+", "6","10"}; //27
    public int solve() {

        return Task4.totalScore(blocks, blocks.length);
    }

    /**
     *
     * @param blocks
     * @param n (Block length)
     * @return
     */
    public static int totalScore(String[] blocks, int n){
        int totalScore = 0;
        int[] scores = new int[n];
        //blocks[i] -> Integer : * 1
        // -> X : * 2
        // -> + : two values from the last
        // -> Z : - the last previous score
        for(int i = 0; i < n; i++) {
            // 점수 배열의 크기를 2개 크게 하고 처음 두 열을 0으로 채우면 비교문 없이 진행 가능
            switch(blocks[i]){
                case "X" :
                    if(i > 0)
                        scores[i] = scores[i-1] * 2;
                    break;
                case "+" :
                    if(i < 1){
                        if(i > 0)
                            scores[i] = scores[i-1];
                    }else {
                        scores[i] = scores[i-1] + scores[i-2];
                    }
                    break;
                case "Z" :
                    if(i > 0)
                        scores[i] = scores[i-1] * -1;
                    break;
                default:
                    scores[i] = Integer.valueOf(blocks[i]);
                    break;

            }
            totalScore += scores[i];
        }
        System.out.println(Arrays.toString(scores));
        return totalScore;
    }

    /**
     *
     * @param blocks
     * @param n (Block length)
     * @return
     */
    public static int totalScore_v2(String[] blocks, int n){
        int totalScore = 0;
        int[] scores = new int[n+2];
        scores[0]=scores[1] = 0;
        /*
         blocks[i] -> Integer : * 1
         -> X : * 2
         -> + : two values from the last
         -> Z : - the last previous score */
        for(int i = 0; i < n; i++) {
            int idx = i+2;
            // 점수 배열의 크기를 2개 크게 하고 처음 두 열을 0으로 채우면 비교문 없이 진행 가능
            switch(blocks[i]){
                case "X" :
                    scores[idx] = scores[idx-1] * 2;
                    break;
                case "+" :
                    scores[idx] = scores[idx-1] + scores[idx-2];
                    break;
                case "Z" :
                    scores[idx] = scores[idx-1] * (-1);
                    break;
                default:
                    scores[idx] = Integer.valueOf(blocks[i]);
                    break;

            }
            totalScore += scores[idx];
        }
        System.out.println(Arrays.toString(scores));
        return totalScore;
    }

}
