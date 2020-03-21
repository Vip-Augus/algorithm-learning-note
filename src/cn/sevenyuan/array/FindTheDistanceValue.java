package cn.sevenyuan.array;

/**
 * 两个数组间的距离值
 *
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 *「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 * @author JingQ at 2020/3/21
 */
public class FindTheDistanceValue {

    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[] {1, 4, 2, 3} , new int[] {-4,-3,6,10,20,30}, 3));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int count = 0;
        int positiveCount = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int abs = Math.abs(arr1[i] - arr2[j]);
                if (abs > d) {
                    positiveCount++;
                }

                if (positiveCount == len2) {
                    count += 1;
                }

                if (j == len2 - 1) {
                    positiveCount = 0;
                }
            }
        }

        return count;
    }
}
