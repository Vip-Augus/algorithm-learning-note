package cn.sevenyuan.java.base;

/**
 * 自定义求幂次方，求 base ^ exponent 幂次方结果
 * @author JingQ at 2020/4/20
 */
public class MyPow {

    private static double myPow(double base, int exponent) {
        int absExponent = Math.abs(exponent);
        double result = 1.0d;
        // 解释 a ^ n = (a ^ n/2) * (a ^ n/2)
        while (absExponent != 0) {
            if (absExponent % 2 != 0) {
                // 奇数情况下，需要乘以一次底数
                result *= base;
            }
            base *= base;
            absExponent /= 2;
        }
        return exponent >= 0 ?  result : 1 / result;
    }
}
