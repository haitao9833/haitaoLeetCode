package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_234 {

    /**
     * 在 slow 遍历的过程中，反转前半部分链表
     * @see Solution_141
     */
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode dummy = new ListNode();
        ListNode tail = slow;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // slow 前脚刚走
            // tail 就反转这个节点，头插法
            tail.next = dummy.next;
            dummy.next = tail;
            tail = slow;
        }

        // 细节处理
        // 奇数个节点，slow 跳过正中间节点
        // 偶数个节点，slow 跳过前半部分链表的尾节点，且还需将该尾节点反转连接到 dummy 链表上
        slow = slow.next;
        if (fast != null) {
            tail.next = dummy.next;
            dummy.next = tail;
        }

        // tail 和 slow 所指链表一定是等长度的
        tail = dummy.next;
        while (tail != null && slow != null) {
            if (tail.val != slow.val) {
                return false;
            }
            tail = tail.next;
            slow = slow.next;
        }
        return true;
    }
}