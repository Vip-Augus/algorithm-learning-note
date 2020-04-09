package cn.sevenyuan.array;

/**
 * @author JingQ at 2020/4/4
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][] {

                {1,3,1},{1,5,1},{4,2,1}
        };
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        // 用 dp
        int colSize = grid[0].length;
        int[] dp = new int[colSize];
        // 初始化第一行
        dp[0] = grid[0][0];
        for (int i = 1; i < colSize; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        int pre = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < colSize; j++) {
                if (j == 0) {
                    dp[0] = dp[0] + grid[i][0];
                    pre = dp[0];
                    continue;
                }
                int min = Math.min(pre, dp[j]);
                dp[j] = grid[i][j] + min;
                pre = dp[j];
            }
        }
        return dp[colSize - 1];
    }
}
