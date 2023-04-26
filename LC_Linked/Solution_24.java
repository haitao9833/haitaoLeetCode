package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_24 {

    /**
     * 不能仅交换节点内部 val
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1 , head);
        ListNode tail = dummy;

        // 交换 tail.next 和 tail.next.next
        while (tail.next != null && tail.next.next != null) {

            // 即 first 和 second
            ListNode first = tail.next;
            ListNode second = tail.next.next;

            // 交换
            first.next = second.next;
            second.next = first;
            tail.next = second;

            tail = first;
        }
        return dummy.next;
    }
}
