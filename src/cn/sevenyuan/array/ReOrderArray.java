package cn.sevenyuan.array;

/**
 * 将所有奇数放在偶数前面
 *
 * @author JingQ at 2020/3/24
 */
public class ReOrderArray {

    public void reOrderArray(int [] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        int i = 0;
        while (i < len) {
            int j = i + 1;
            // i 下标是否为偶数，如果是，判断 i 下一位是否也是偶数
            if (array[i] % 2 == 0) {
                while (array[j] % 2 == 0) {
                    if (j == len - 1) {
                        // 找完了，可以退出
                        return;
                    } else {
                        // 继续往下走
                        j++;
                    }
                }
                // 前面偶数判断完，发现 j 下标的是奇数，将它换到 i 下标，同时后移元素
                int count = j - i;
                int temp = array[i];
                array[i] = array[j];
                while (count > 1) {
                    // 数组后移
                    array[i + count] = array[i + count - 1];
                    count--;
                }
                array[i + 1] = temp;
            }
            i++;
        }
    }
}
