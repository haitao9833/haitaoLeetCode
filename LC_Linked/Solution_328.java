package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_328 {

    /**
     * 循环条件原则<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以更靠近 null 的为条件<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;快慢指针以 fast 为条件<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;奇偶指针以 eveTail 为条件
     */
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddTail = head;
        ListNode eveTail = head.next;

        // 保存 eve 链表的 head
        ListNode eveHead = head.next;

        while (eveTail != null && eveTail.next != null) {
            oddTail.next = eveTail.next;
            oddTail = oddTail.next;

            eveTail.next = oddTail.next;
            eveTail = eveTail.next;
        }

        oddTail.next = eveHead;
        return head;
    }
}
