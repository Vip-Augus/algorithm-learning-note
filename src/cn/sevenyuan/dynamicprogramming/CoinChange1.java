package cn.sevenyuan.dynamicprogramming;

import java.util.Arrays;

/**
 * 零钱兑换 1
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 采用自下而上的方式进行思考。
 * 仍定义 F(i) 为组成金额 ii 所需最少的硬币数量，
 * 假设在计算 F(i) 之前，我们已经计算出 F(0) ~ F(i-1) 的答案。 则 F(i) 对应的转移方程应为
 *
 * dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
 *
 * @author JingQ at 9/20/20
 */
public class CoinChange1 {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
