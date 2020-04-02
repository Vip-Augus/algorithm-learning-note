package cn.sevenyuan.pointer;

/**
 * 接雨水，使用双指针（左右数组保存最大高度）
 * @author JingQ at 2020/4/3
 */
public class TrapRain {

    public int trap(int[] height) {
        // 使用双指针，左右两边寻找最大值
        int sum = 0;
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRigth = new int[length];
        // 第一位下标和最后一位下标作为边界
        for (int i = 1; i < length - 1; i++) {
            // 取第 i 位左边最大值，每次保存左边的最大高度（比较 maxLeft[i - 1] 和 heigth[i - 1])
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            // 取第 i 位右边最大值，每次保存右边的最大高度
            maxRigth[length - i - 1] = Math.max(maxRigth[length - i], height[length - i]);
        }
        for (int i = 1; i < length - 1; i++) {
            // 每次比较该位置左右高度，取短板
            int min = Math.min(maxLeft[i], maxRigth[i]);
            // 只有短板比自己还要高的情况，才有可能接水
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

}
