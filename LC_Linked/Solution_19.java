package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_19 {

    /**
     * 题意保证 1 <= n <= len(链表) <P>
     * 增加一个头节点，<strong>方便删除</strong>倒数第 n 个节点，即第一个节点
     */
    public ListNode removeNthFromEnd(ListNode head , int n) {

        ListNode dummy = new ListNode(-1 , head);

        // pre 与 cur 之间相差 n 个节点（不包括 pre 和 cur 自身）
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (n-- != 0) {
            cur = cur.next;
        }

        // 当 cur 指空时 pre 即为倒数第 n 个节点的前驱节点
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }
}
