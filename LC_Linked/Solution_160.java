package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_160 {

    /**
     * <strong>走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路</strong>
     * <P> 若 A 、B 无公共结点 ==> 则指针 a 、b 同时走到 null 结束
     * <P> <strong>null == null 结果为 true</strong>
     */
    public ListNode getIntersectionNode(ListNode headA , ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
