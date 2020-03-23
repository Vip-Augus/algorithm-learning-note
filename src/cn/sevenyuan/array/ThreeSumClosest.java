package cn.sevenyuan.array;

import java.util.Arrays;

/**
 * @author JingQ at 2020/3/23
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        quickSort(nums, 0, length);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > target) {
                    right--;
                } else if (threeSum < target) {
                    left++;
                } else {
                    return target;
                }
                res = Math.abs(threeSum - target) > Math.abs(res - target) ? res : threeSum;
            }
        }
        return res;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int key = nums[low];
        int i = low;
        int j = high;
        while (i < j) {

            while (i < j && nums[j] >= key) {
                j--;
            }

            while (i < j && nums[i] <= key) {
                i--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[low] = nums[i];
        nums[i] = key;
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
