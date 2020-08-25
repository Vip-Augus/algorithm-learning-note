package cn.sevenyuan.dynamicprogramming;

import java.util.Arrays;

/**
 * @author JingQ at 2020/4/19
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {1, 5},
                {1, 4},
                {1, 2},
                {2, 3}
        };

    }

    private static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return 0;
    }
}
