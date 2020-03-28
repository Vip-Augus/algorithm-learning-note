package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 反转链表
 *
 * @author JingQ at 2020/3/22
 */
public class ReverseList {

    public static ListNode head = new ListNode(1);

    static {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head.next(node2).next(node3).next(node4).next(node5).next(node6).next(node7);
    }

    public static void main(String[] args) {
        ListNode node = reverseList2(head);
        System.out.println(node.val);
    }

    private static ListNode reverseList(ListNode head) {
        // 指向当前节点的后驱
        ListNode next = null;
        // 指向当前节点的前驱
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            // 当前节点的后驱指向前驱
            head.next = pre;
            pre = head;
            // 处理下一个节点
            head = next;
        }
        return pre;
    }

    private static ListNode reverseList2(ListNode head) {
        // 递归实现
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转子链表
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * k 组进行逆序，使用递归
     *
     * @param node
     * @param k
     * @return
     */
    private static ListNode reverseKGroup(ListNode node, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        // 判断节点的数量是否能够凑成一组
        if (temp == null) {
            return head;
        }

        ListNode t2 = temp.next;
        temp.next = null;
        // 把当前的数组进行逆序
        ListNode newHead = reverseList(head);
        // 把之后的节点也进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;
        return newHead;
    }
}
