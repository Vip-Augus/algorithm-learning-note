package cn.sevenyuan.queue;

/**
 * @author JingQ at 2020/8/22
 */
public class CircularQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        // 判断队列是否满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        // 如果 head == tail 表示队列为 null
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
