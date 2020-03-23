package cn.sevenyuan.array;

/**
 * @author JingQ at 2020/3/23
 */
public class KDiff {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int length = nums.length;
        quickSort(nums, 0, length);
        int ans = 0, i = 0, j = 1;
        if (k == 0) {
            while (j < length) {
                if (nums[j] == nums[i]) {
                    ans++;
                }
                int a = i++;
                while (nums[i] == nums[a]) {
                    i++;
                    if (i == length) {
                        return ans;
                    }
                }
                j = i + 1;
            }
        } else {
            while (j < length) {
                while (nums[j] - nums[i] < k) {
                    j++;
                    if (j == length) {
                        return ans;
                    }
                }
                if (nums[j] - nums[i] == k) {
                    ans++;
                }
                int a = i++;
                while (nums[i] == nums[a]) {
                    i++;
                }
            }
        }
        return ans;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int key = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= key){
                j--;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            //交换 i 和 j
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[low] = nums[i];
        nums[i] = key;
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }
}
