package cn.sevenyuan.fibonacci;

/**
 *
 * 斐波那契数列
 *
 * 思路：当成 dp 问题来想，它的最终解是由前面的解累加起来的解
 *
 * dp(i) = dp(i - 2) + dp(i - 1)
 *
 * @author JingQ at 2020/3/22
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(3);
    }

    public static int JumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        int pre1 = 2, pre2 = 1;
        for (int i = 3; i < target; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    private int hentiJumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        return 1 << (target - 1);
    }
}
