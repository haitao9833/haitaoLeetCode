package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_25 {

    /**
     * 题意保证 1 <= k <= len(链表)
     */
    public ListNode reverseKGroup(ListNode head , int k) {

        ListNode dummy = new ListNode(-1 , head);
        ListNode tail = dummy;

        // [l , r] 即为需要翻转的区间
        ListNode l = dummy;
        ListNode r = dummy;

        while (tail.next != null) {
            // 确定 [l , r] 区间
            l = tail.next;
            for (int i = 0 ; i < k ; i++) {
                r = r.next;
                if (r == null) {
                    // 不足 k 个不翻转
                    return dummy.next;
                }
            }

            // rest 保留 [l , r] 之后的
            ListNode rest = r.next;
            r.next = null;

            // 翻转 [l , r] 区间后，节点 l 即为有效尾节点了
            tail.next = reverseList(l);
            l.next = rest;
            tail = l;
            r = l;
        }
        return dummy.next;
    }

    /**
     * 直接复制 206 的代码
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode rest = cur;
        while (cur != null) {
            rest = cur.next;
            cur.next = pre;
            pre = cur;
            cur = rest;
        }
        return pre;
    }
}
