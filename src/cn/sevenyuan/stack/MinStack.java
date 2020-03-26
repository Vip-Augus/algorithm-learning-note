package cn.sevenyuan.stack;

import java.util.Stack;

/**
 * @author JingQ at 2020/3/24
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    int minimun = Integer.MAX_VALUE;

    public void push(int node) {
        if (stack.empty()) {
            stack.push(node);
            minimun = node;
        } else {
            if (node <= minimun) {
                // 保存前面插入过，最小的元素
                stack.push(minimun);
                minimun = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        if (minimun == stack.peek()) {
            if (stack.size() > 1) {
                stack.pop();
                minimun = stack.peek();
            } else {
                minimun = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minimun;
    }
}
