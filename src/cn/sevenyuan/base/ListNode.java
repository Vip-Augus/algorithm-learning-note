package cn.sevenyuan.base;

/**
 * 单链表节点
 *
 * @author JingQ at 2020/3/22
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode next(ListNode node) {
        this.next = node;
        return next;
    }
}
