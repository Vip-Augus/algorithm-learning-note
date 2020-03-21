package cn.sevenyuan.array;

/**
 * 寻找最大的连续子序列和
 *
 * 最大子数组的和一定是由当前元素和之前最大连续子数组的和叠加在一起形成的，
 * 因此需要遍历n个元素，看看当前元素和其之前的最大连续子数组的和能够创造新的最大值。
 *
 * @author JingQ at 3/21/20
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {

    }

    private static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int pre = array[i - 1];
            array[i] += Math.max(pre, 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
