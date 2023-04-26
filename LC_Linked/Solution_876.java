package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_876 {

    /**
     * @see Solution_234
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }
}
