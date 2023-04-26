package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_142 {

    /**
     * <strong>步长为两倍</strong>而非节点为两倍 <P>
     * 循环条件完全同 141
     * @see leetcode.LC_Array.Solution_287
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        // 初始化不同于 141
        // 因为要保证 fast 的步长始终为 slow 步长的两倍
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        // 循环条件同
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow 从 head 重新走 ==> 找环入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
