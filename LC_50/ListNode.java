package leetcode.LC_50;

/**
 * LC_Linked 的链表节点
 * @author man11
 */

public class ListNode {

    /**
     * 节点值
     */
    public int val;

    /**
     * next 指针
     */
    public ListNode next;

    /**
     * 构造函数
     */
    public ListNode() {}
    public ListNode(int val) { this.val = val; this.next = null; }
    public ListNode(int val , ListNode next) { this.val = val; this.next = next; }
}