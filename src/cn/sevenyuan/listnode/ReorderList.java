package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 重排序链表
 *
 * https://www.nowcoder.com/questionTerminal/3d281dc0b3704347846a110bf561ef6b?answerType=1&f=discussion
 *
 * @author JingQ at 2020/3/22
 */
public class ReorderList {

    private static volatile int number;

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        //链表长度小于2时直接返回
        if (head == null || head.next == null) {
            return;
        }
        //设置两个快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //fast走两步同时slow只走一步，从而找到中间节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //将链表从slow处拆开
        ListNode after = slow.next;
        slow.next = null;
        //将后半部分链表逆序
        ListNode pre = null;
        while (after != null) {
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }

        //将pre链表间隔插入head链表
        ListNode first = head;
        ListNode second = pre;
        while (first != null && second != null) {
            ListNode firstTemp = first.next;
            ListNode secondTemp = second.next;
            first.next = second;
            first = firstTemp;
            second.next = first;
            second = secondTemp;
        }
    }
}
