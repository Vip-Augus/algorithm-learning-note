package cn.sevenyuan.queue;

/**
 * 使用数组来实现队列
 *
 * @author JingQ at 2020/8/22
 */
public class DynamicArrayQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        // 考虑边界条件，同时要实现可扩展，重复利用前面已分配的空间
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            // 重新更新 head 和 tail 指针
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }


    public String dequeue() {
        // 从队头出队, 如果头尾重叠，表示空队列
        if (head == tail) {
            return null;
        }
        String result = items[head];
        ++head;
        return result;
    }
}
