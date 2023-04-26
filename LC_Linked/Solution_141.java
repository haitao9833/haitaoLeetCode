package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;
import leetcode.LC_Array.Solution_202;

public class Solution_141 {

    /**
     * 有环一定相遇 <P>
     * <strong>循环条件</strong>改为 slow != fast 且内置 if (fast == null || fast.next == null)
     * @see Solution_142
     * @see Solution_202
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // 内置无环条件
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
