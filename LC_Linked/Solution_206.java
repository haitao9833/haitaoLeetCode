package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;


public class Solution_206 {

    /**
     * 三指针：边遍历边反转，<strong>直接反转 next 的指向</strong>
     * @see Solution_25
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode rest = cur;
        while (cur != null) {
            rest = cur.next;

            // 反转 next 指向
            cur.next = pre;
            pre = cur;

            cur = rest;
        }
        return pre;
    }
}