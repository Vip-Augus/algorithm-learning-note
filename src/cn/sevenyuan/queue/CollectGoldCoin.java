package cn.sevenyuan.queue;

import java.util.ArrayDeque;

/**
 * 给定一个数组 A[]，每个位置 i 放置了金币 A[i]，小明从 A[0] 出发。当小明走到 A[i] 的时候，下一步他可以选择 A[i+1, i+k]（当然，不能超出数组边界）。每个位置一旦被选择，将会把那个位置的金币收走（如果为负数，就要交出金币）。请问，最多能收集多少金币？
 *
 * 输入：[1,-1,-100,-1000,100,3], k = 2
 *
 * 输出：4
 *
 * 解释：从 A[0] = 1 出发，收获金币 1。下一步走往 A[2] = -100, 收获金币 -100。再下一步走到 A[4] = 100，收获金币 100，最后走到 A[5] = 3，收获金币 3。最多收获 1 - 100 + 100 + 3 = 4。没有比这个更好的走法了。
 *
 * @author JingQ at 2021/5/26
 */
public class CollectGoldCoin {

    public static int maxResult(int[] nums, int k) {
        // 处理边界值
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        int length = nums.length;
        // 每个位置可以收集到金币数目
        int[] get = new int[length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            // 在取最大值之前，需要保证单调队列中的都是有效值
            // 也就是都在区间里面的值
            // 当要求 get[i] 的时候
            // 单调队列中应该只能保存 [i-k, i-1] 这个范围
            if (i - k > 0) {
                if (!deque.isEmpty() && deque.getFirst() == get[i - k - 1]) {
                    deque.removeFirst();
                }
            }
            // 从单调队列中取得较大值
            int old = deque.isEmpty() ? 0 : deque.getFirst();
            get[i] = old + nums[i];
            // 入队的时候，采用单调队列入队
            while (!deque.isEmpty() && deque.getLast() < get[i]) {
                deque.removeLast();
            }
            deque.addLast(get[i]);
        }
        return get[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[] {1,-1,-100,-1000,100,3}, 2));
    }
}
