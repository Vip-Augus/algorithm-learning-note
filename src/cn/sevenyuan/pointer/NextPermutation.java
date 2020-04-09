package cn.sevenyuan.pointer;

/**
 * 下一个排列
 *
 * @author JingQ at 2020/4/9
 */
public class NextPermutation {

    // 提取题意：找到下一个更大的数，123 下一个更大的是 132，如果没有下一个更大，则返回最小的数，例如 321 返回 123
    // 核心思想：从后往前走，寻找到前后处于升序的位置，接着从后找到 i，遇到比 i 下标大的数字提前结束，i 和 j 交换
    //          最后将 i+1 到结尾的数值进行逆序
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        // 从倒数第二个下标开始寻找
        int i = length - 2;
        // 从右往左走，找到突变点（i 大于 i+1 那个位置）
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, length);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
