package cn.sevenyuan.bit;

/**
 * 二进制中，有多少位 1
 *
 * @author JingQ at 2020/3/22
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        int  count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

}
