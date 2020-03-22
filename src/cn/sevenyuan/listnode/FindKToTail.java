package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 输入一个链表，找出链表中倒数第 K 个节点
 *
 * 思路：使用双指针，快指针和慢指针
 * @author JingQ at 2020/3/22
 */
public class FindKToTail {

    private static ListNode findKToTail(ListNode head, int k) {
        ListNode fast = head, slow = head;
        int index = 0;
        while (fast != null) {
            if (index >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        return index < k ? null : slow;
    }
}
