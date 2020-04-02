package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * @author JingQ at 2020/3/29
 */
public class MergeKListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = start + ((end - start) >> 1);
        ListNode upper = divide(lists, start, mid - 1);
        ListNode lower = divide(lists, mid, end);

        return merge(upper, lower);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            int v1 = node1.val, v2 = node2.val;
            if (v1 < v2) {
                cur.next = new ListNode(v1);
                node1 = node1.next;
            } else {
                cur.next = new ListNode(v2);
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 == null) {
            cur.next = node2;
        }
        if (node2 == null) {
            cur.next = node1;
        }
        return dummy.next;
    }
}
