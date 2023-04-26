package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_21 {

    /**
     * 递归 <P>
     * 当前层.next = 递归结果 <P>
     * 并且返回当前层
     * @see Solution_23
     */
    public ListNode mergeTwoLists(ListNode l1 , ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            // 当前层.next = 递归结果，并且返回当前层
            l1.next = mergeTwoLists(l1.next , l2);
            return l1;
        } else {
            // 当前层.next = 递归结果，并且返回当前层
            l2.next = mergeTwoLists(l1 , l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     */
    public ListNode mergeTwoLists2(ListNode l1 , ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 还有条链表没合并完
        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
