package cn.sevenyuan.listnode;

import cn.sevenyuan.base.ListNode;

/**
 * 判断两个单链表是否相交
 *
 * 单链表可能有环,也可能无环。给定两个单链表的头节点 head1 和 head2, 这两个链表可能相交,也可能不相交。
 * 请实现一个函数,如果两个链表相交,请返回相交的第一个节点;如果不相交,返回 null 即可。
 *
 * @author JingQ at 2020/8/30
 */
public class FindIntersect {

    public static void main(String[] args) {
        ListNode headNode1 = new ListNode(1);
        ListNode headNode2 = new ListNode(9);

        ListNode commonNode = new ListNode(2);

        headNode1.next(commonNode).next(new ListNode(3)).next(new ListNode(4)).next(new ListNode((5)));
        headNode2.next(commonNode).next(new ListNode(8));

        ListNode result = findIntersect(headNode1, headNode2);
    }

    private static ListNode findIntersect(ListNode headNode1, ListNode headNode2) {
        if (headNode1 == null || headNode2 == null) {
            return null;
        }
        ListNode loopHeadNode1 = getLoopNode(headNode1);
        ListNode loopHeadNode2 = getLoopNode(headNode2);
        if (loopHeadNode1 == null && loopHeadNode2 == null) {
            return noLoop(headNode1, headNode2);
        }
        if (loopHeadNode1 != null && loopHeadNode2 != null) {
            return bothLoop(headNode1, loopHeadNode1, headNode2, loopHeadNode2);
        }
        return null;
    }

    /*
     * 判断是否存在环，如果存在，则找出环的入口点。
     * 入口点找法：快慢指针，块指针走两步，满指针走一步，如果存在循环，则在慢指针走完环前，总会和快指针相遇。
     * 从头指针和相遇点同时向后走，相遇的点必定是入口点。
     * （下面数学推导）
     * 当fast与slow相遇时，slow肯定没有走遍历完链表，而fast已经在环内循环了n圈(1<=n)。
     * 假设slow走了s步，则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：
     * 2s = s + nr
     * s= nr
     * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
     * a + x = nr
     * a + x = (n – 1)r +r = (n-1)r + L - a
     * a = (n-1)r + (L – a – x)
     * (L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点（从相遇点向后遍历循环回到入口点的距离），于是我们从链表头、与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇点为环入口点，也即为两个链表的第一个相同节点。
     * */
    private static ListNode getLoopNode(ListNode node) {
        ListNode slowNode = node.next;
        ListNode fastNode = node.next.next;
        while (slowNode != fastNode) {
            if (slowNode.next == null || fastNode.next == null) {
                // 到了尽头，表示不存在环
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        fastNode = node;
        if (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

    private static ListNode noLoop(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        // 判断两者的长度
        int n = 0;
        while (cur1.next != null) {
            ++n;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            --n;
            cur2 = cur2.next;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        // 提前让长链表走 n 步，这样后续才能用同样步数达到相交点
        n = Math.abs(n);
        while (n != 0) {
            --n;
            cur1 = cur1.next;
        }
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static ListNode bothLoop(ListNode headNode1, ListNode loopHeadNode1, ListNode headNode2, ListNode loopHeadNode2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loopHeadNode1 == loopHeadNode2) {
            // 环的切入点一致的话，与前面操作一样，寻找第一个相交点
            cur1 = headNode1;
            cur2 = headNode2;
            int n = 0;
            while (cur1 != loopHeadNode1) {
                ++n;
                cur1 = cur1.next;
            }
            while (cur2 != loopHeadNode1) {
                --n;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? headNode1 : headNode2;
            cur2 = cur1 == headNode1 ? headNode2 : headNode1;

            n = Math.abs(n);
            while (n != 0) {
                --n;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            // 环的入口点不一样，寻找第一个与 loop2 相交的点
            cur1 = headNode1.next;
            while (cur1 != headNode1) {
                if (cur1 == loopHeadNode2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

}
