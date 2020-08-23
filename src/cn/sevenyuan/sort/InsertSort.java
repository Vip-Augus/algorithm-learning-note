package cn.sevenyuan.sort;

import java.util.Arrays;

/**
 * @author JingQ at 8/23/20
 */
public class InsertSort {

    public static void sort(int[] arrays) {
        int length = arrays.length;
        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; ++i) {
            int temp = arrays[i];
            int j = i - 1;
            // 寻找插入的位置
            for (; j >= 0; --j) {
                // 如果后面的比 temp 数值大，需要进行移动
                if (arrays[j] > temp) {
                    arrays[j+1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j+1] = temp;
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        String ip = "127.0.0.1";
        long result = ip2Long(ip);
        System.out.println(long2Ip(result));
    }

    public static long ip2Long(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        long rs = 0;
        for (int i = 0; i < ipSlices.length; i++) {
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = Integer.parseInt(ipSlices[i]) << (8 * (3 - i));
            // 或运算
            rs = rs | intSlice;
        }
        return rs;
    }

    /**
     * 将 long 转换为 ip 字符串
     *
     * @param ipInt 用 long 表示的 ip 值
     * @return ip字符串，如 127.0.0.1
     */
    public static String long2Ip(long ipInt) {
        String[] ipString = new String[4];
        for (int i = 0; i < 4; i++) {
            // 每 8 位为一段，这里取当前要处理的最高位的位置
            int pos = (3 - i)  * 8;
            // 取当前处理的 ip 段的值
            long and = ipInt & (255 << pos);
            // 将当前 ip 段转换为 0 ~ 255 的数字，注意这里必须使用无符号右移
            ipString[i] = String.valueOf(and >>> pos);
        }
        return String.join(".", ipString);
    }
}
