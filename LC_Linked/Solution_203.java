package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;


public class Solution_203 {

    /**
     * 递归 <P>
     * 若当前层不是 val： <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 当前层.next = 递归结果 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 并且返回当前层 <P>
     * 若当前层是 val：即需删除当前层，且返回后续层递归的结果
     */
    public ListNode removeElements(ListNode head , int val) {
        if (head == null) {
            return null;
        } else if (head.val == val) {
            // 返回后续层递归的结果
            return removeElements(head.next , val);
        } else {
            // 当前层.next = 递归结果，并且返回当前层
            head.next = removeElements(head.next , val);
            return head;
        }
    }

    /**
     * 迭代
     */
    public ListNode removeElements2(ListNode head , int val) {
        // 特判
        if (head == null) {
            return null;
        }

        // 创建头结点 dummy ，因为首元素 head 有可能为 val
        ListNode dummy = new ListNode(-1 , head);

        // pre-cur 找要删除的 val 节点
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = pre.next;
        }

        return dummy.next;
    }
}