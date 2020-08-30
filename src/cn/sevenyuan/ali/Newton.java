package cn.sevenyuan.ali;

/**
 * 1、牛顿迭代法
 * 2、查找，如： a) high=>1.5
 *              b) low=>1.4
 *              c) mid => (high+low)/2=1.45
 *              d) 1.45*1.45>2 ? high=>1.45 : low => 1.45
 *              e) 循环到 c)
 * @author JingQ at 8/30/20
 */
public class Newton {

    private static double epsilon = 0.00000000001;

    public static void main(String[] args) {
        System.out.println(newton(2));
        System.out.println(sqrt2());
    }

    private static double newton(double value) {
        if (Math.abs(value * value - 2) > epsilon) {
            return newton(value - (value * value - 2) / (2 * value));
        }
        return value;
    }

    private static double sqrt2() {
        double low = 1.4;
        double high = 1.5;
        double mid = low + (high - low) / 2;
        // 高低位精度相差设定值内
        while (high - low > epsilon) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            // 重新定位中间值 mid
            mid = low + (high - low) / 2;
        }
        return mid;
    }

}
