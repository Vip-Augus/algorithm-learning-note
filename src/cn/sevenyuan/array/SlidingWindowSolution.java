package cn.sevenyuan.array;

import java.util.ArrayList;

/**
 * 在一个滑动窗口中，寻找每次窗口中的最大值
 *
 * @author JingQ at 2020/3/21
 */
public class SlidingWindowSolution {

    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 6, 9, 12, 6, 5};
        System.out.println(maxInWindows(nums, 3));
    }

    private static ArrayList<Integer> maxInWindows(int[] nums, int size) {
        // 正常判空
        if (nums == null || nums.length == 0 || size > nums.length) {
            return result;
        }
        int len = nums.length;
        int i = 0, j = size - 1;
        int endIndex = len - size + 1;
        for (int n = 0; n < endIndex; n++) {
            result.add(getMaxNumber(nums, i, j));
            i++;
            j++;
        }
        return result;
    }

    /**
     * 在下标 i 和 j 之间，获取最大值
     * @param nums  数组
     * @param i 下标 i
     * @param j 下标 j
     * @return 最大值
     */
    private static Integer getMaxNumber(int[] nums, int i, int j) {
        int max = nums[i];
        for (int index = i + 1; index <= j; index++) {
            if (nums[index] > max) {
                max = nums[index];
            }
        }
        return max;
    }
}
