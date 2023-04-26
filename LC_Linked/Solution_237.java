package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_237 {

    /**
     * 直接给定需要删除的节点 node
     * <P> 无法寻找前驱节点  pre
     * <P> <strong>与后驱节点交换 val 并删除后驱节点</strong>
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
