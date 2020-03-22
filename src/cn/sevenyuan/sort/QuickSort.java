package cn.sevenyuan.sort;

/**
 * 快速排序
 *
 * @author JingQ at 2020/3/21
 */
public class QuickSort {

    public static void main(String[] args) {
        int[]  nums = new int[] {9, 6, 2, 5, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int key = numbers[low];
        while (i < j) {
            // 这里比较规则比较特殊，比较的是字符大小，即 33 比 321 大
            while(numbers[j] >= key && i < j) {
                j--;
            }
            while (numbers[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                swap(numbers, i, j);
            }
        }
        // 将他们交换回来
        numbers[low] = numbers[i];
        numbers[i] = key;
        quickSort(numbers, low, j - 1);
        quickSort(numbers, j + 1, high);
    }

    private  static void swap(int[] numbers, int i, int j) {
        numbers[i] = numbers[i] + numbers[j];
        numbers[j] = numbers[i] - numbers[j];
        numbers[i] = numbers[i] - numbers[j];
    }
}
