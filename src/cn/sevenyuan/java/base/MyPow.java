package cn.sevenyuan.java.base;

/**
 * @author JingQ at 2020/4/20
 */
public class MyPow {

    private static double myPow(double base, int exponent) {
        int absExponent = Math.abs(exponent);
        double result = 1.0d;
        while (absExponent != 0) {
            if (absExponent % 2 != 0) {
                result *= base;
            }
            base *= base;
            absExponent /= 2;
        }
        return exponent >= 0 ?  result : 1 / result;
    }
}
