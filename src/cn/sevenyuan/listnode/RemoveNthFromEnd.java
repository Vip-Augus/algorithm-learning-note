package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * @author JingQ at 2020/4/2
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2).next(3).next(4).next(5);
        ListNode temp = removeNthFromEnd2(head, 1);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        ListNode second = dummy;
        dummy.next = head;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = head;
        ListNode first = head;
        ListNode second = head;
        int index = 0;
        int length = 0;
        while (first != null) {
            first = first.next;
            length++;
            if (first == null) {
                //已经到了终点，可以结束了
                if (length == n) {
                    return head.next;
                }
                if (length - 1 == n) {
                    head.next = head.next == null ? null : head.next.next;
                    break;
                }
                second.next = second.next == null ? null : second.next.next;
                break;
            }
            index++;
            if (index > n) {
                second = second.next;
            }

        }
        return dummy;
    }
}
