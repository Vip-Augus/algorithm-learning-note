package cn.sevenyuan.pointer;

/**
 * 两数相除
 * 学习理解泰勒展开：任意一个数可以用这个公式表达
 * K = b0 * 2 ^ 0 + b1 * 2 ^ 1 + b2 * 2 ^ 2 + bn * 2 ^ n;
 * @author JingQ at 2020/4/4
 */
public class TwoNumberDivide {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }

    private static int divide(int dividend, int divisor) {
        int result = 0;
        // 判断是否符号位是否一致
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        // 转成了负数，注意符号位判断
        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            while (dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= Integer.MIN_VALUE >> 1) {
                    break;
                }
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            result += tempResult;
            dividend -= tempDivisor;
        }
        // 如果符号位相反，需要返回负数
        if (!sign) {
            if (result <= (Integer.MIN_VALUE >> 1)) {
                return Integer.MAX_VALUE;
            }
            return -result;
        }
        return result;
    }
}
