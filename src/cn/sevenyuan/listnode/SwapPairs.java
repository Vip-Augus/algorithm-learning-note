package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 链表中两两交换
 *
 * @author JingQ at 2020/3/23
 */
public class SwapPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;

        // 使用两个指针，保存移动进度
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;

            // 交换
            cur.next = next.next;
            next.next = cur;
            pre.next = next;

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
