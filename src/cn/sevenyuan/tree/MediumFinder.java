package cn.sevenyuan.tree;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 使用大顶堆和小顶堆 寻找中位数
 *
 * @author JingQ at 8/25/20
 */
public class MediumFinder {

    private static PriorityQueue<Integer> minHeap, maxHeap;

    static {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }

    public static void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static double findMedium() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        for (int num : nums) {
            addNum(num);
        }

        System.out.println(findMedium());
        for (int i = 0; i < 5; ++i) {
            System.out.println(maxHeap.poll());
        }
    }
}
