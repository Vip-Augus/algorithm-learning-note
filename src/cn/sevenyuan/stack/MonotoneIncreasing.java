package cn.sevenyuan.stack;

import java.util.Stack;

/**
 * 单调递增栈
 *
 * 题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 *
 * 输入：[5, 2]
 *
 * 输出：[1, -1]
 *
 * 解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
 *
 * 复制代码
 *
 * @author JingQ at 2021/5/25
 */
public class MonotoneIncreasing {

    public static int[] findRightSmall(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int x = A[i];
            // 每个元素都向左遍历栈中的元素，完成消除动作
            while (!stack.isEmpty() && A[stack.peek()] > x) {
                // 消除的时候，记录一下谁被消除了
                result[stack.peek()] = i;
                // 消除的时候，值更大的需要从栈中消失
                stack.pop();
            }
            // 剩下的入栈
            stack.push(i);
        }
        // 剩下的说明属于单调递增顺序，没有值能匹配消除，将结果设为 1
        while (!stack.isEmpty()) {
            result[stack.peek()] = -1;
            stack.pop();
        }
        return result;
    }
}
