package cn.sevenyuan.dynamicprogramming;

import java.util.Arrays;

/**
 * 最长增长序列的长度
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/
 *
 * @author JingQ at 9/20/20
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISByBS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        // 考虑边界值
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int[] dp = new int[size];
        // base case
        Arrays.fill(dp, 1);
        // 状态转移工程
        // dp[i] 的定义：以 nums[i] 结尾，最长的递增子序列
        // 理解：dp[5] 依赖于 dp[0..4] 中，确认比 nums[5] 小，所以 dp[5] 的最长子序列长度基于前面的结果 + 1
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                // 状态判断，固定最后一位，从前到后判断，如果 nums[i] 比前面的要大，取已比较过的「最长子序列」，还有 dp[j] + 1，取最大值
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int temp : dp) {
            max = Math.max(max, temp);
        }
        return max;
    }

    public static int lengthOfLISByBS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 使用了二分查找来找，poker 扑克牌原理，牌堆初始化为 0
        int piles = 0;
        int[] tops = new int[nums.length];
        for (int poker : nums) {
            int left = 0 , right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tops[mid] >= poker) {
                    right = mid;
                } else if (tops[mid] < poker) {
                    left = mid + 1;
                }
            }
            // 没有找到合适的牌堆，新建一个
            if (left == piles) ++piles;
            // 将这张牌放到牌堆顶
            tops[left] = poker;
        }
        return piles;
    }
}
