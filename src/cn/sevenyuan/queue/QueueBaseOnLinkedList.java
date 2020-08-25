package cn.sevenyuan.queue;

import cn.sevenyuan.base.ListNode;

/**
 * @author JingQ at 2020/8/22
 */
public class QueueBaseOnLinkedList {

    private Node head = null;

    private Node tail = null;

    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    private static class Node {

        public String val;

        public Node next;

        public Node(String val) {
            this.val = val;
        }

    }
}
