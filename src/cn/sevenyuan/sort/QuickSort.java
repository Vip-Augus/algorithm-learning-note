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

    /**
     * 遍历 low 到 high 之间的数据，
     * 将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
     * 经过这一步骤之后，数组 low 到 high 之间的数据就被分成了三个部分，
     *
     * 前面 low 到 q-1 之间都是小于 pivot 的，
     * 中间是 pivot，
     * 后面的 q+1 到 high 之间是大于 pivot 的。
     * @param numbers
     * @param low
     * @param high
     */
    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        // 也可以写作 pivot 分区点
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
