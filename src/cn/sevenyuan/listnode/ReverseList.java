package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 反转链表
 *
 * @author JingQ at 2020/3/22
 */
public class ReverseList {

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
