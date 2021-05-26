package cn.sevenyuan.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口的最大值
 * 【题目】给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *
 * 输入：nums = [1,3,-1,-3,5,3], k = 3
 *
 * 输出：[3,3,5,5]
 *
 * @author JingQ at 2021/5/26
 */
public class SlidingWindowWithArrayDequeue {

    /**
     * 单调队列
     */
    private static ArrayDeque<Integer> deque = new ArrayDeque<>();

    private static void push(int val) {
        while (!deque.isEmpty() && deque.getLast() < val) {
            deque.removeLast();
        }
        // 将元素入队
        deque.addLast(val);
    }

    private static void pop(int val) {
        // 出队时，保证相等时才出栈，避免移除到不相关的元素
        if (!deque.isEmpty() && deque.getFirst() == val) {
            deque.removeFirst();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
            // 保证最开始时，队列中的元素达到了 k 个
            if (i < k - 1) {
                continue;
            }
            // 队首元素是最大的
            ans.add(deque.getFirst());
            // 尝试将窗口外的元素出队
            pop(nums[i - k + 1]);
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3 };
        System.out.println(maxSlidingWindow(nums, 3));
    }

}
