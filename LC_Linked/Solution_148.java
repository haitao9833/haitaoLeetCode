package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_148 {

    /**
     * 直接复制 21 的代码
     */
    public ListNode merge(ListNode l1 , ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = merge(l1.next , l2);
            return l1;
        } else {
            l2.next = merge(l1 , l2.next);
            return l2;
        }
    }

    /**
     * 自底向上<strong>迭代式归并</strong>（空间复杂度 O(1)）<P>
     * 需要<strong>双层循环</strong>实现：外层循环代表轮次 、即有几轮，内层循环执行两两相邻的合并 <P>
     * 但不如 23 数组那么方便
     */
    public ListNode sortList2(ListNode head) {
        // 特判，空链或单个结点
        if (head == null || head.next == null) {
            return head;
        }

        // 计算链表长度
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0 , head);

        // 每轮合并相邻的、有序的、两个长度为 subLen == 1 、2 、4 ...  的子链表 head1 、head2
        for (int subLen = 1 ; subLen < len ; subLen <<= 1) {

            // tail 用来链接每个合并好的子链，为有效尾节点
            // find 用来划分 head1 、head2
            ListNode tail = dummy;
            ListNode find = dummy.next;

            while (find != null) {

                // 找 head1 （有可能不足 subLen 长度）
                // 循环结束时 find 为 head1 子链的尾节点
                ListNode head1 = find;
                for (int i = 1 ; i < subLen && find.next != null ; i++) {
                    find = find.next;
                }

                // 取下 head1 ，即断开 head1 子链的尾节点和下一节点
                // 找 head2 （有可能为 null 或者不足 subLen 长度）
                // 循环结束时 find 为 head2 子链的尾节点
                ListNode head2 = find.next;
                find.next = null;
                find = head2;
                for (int i = 1 ; i < subLen && find != null && find.next != null ; i++) {
                    find = find.next;
                }

                // 取下 head2 并且保存 head2 之后的 rest （有可能为 null）
                ListNode rest = null;
                if (find != null) {
                    rest = find.next;
                    find.next = null;
                }

                // 合并 head1 、head2 并链接到 tail 后
                tail.next = merge(head1 , head2);
                while (tail.next != null) {
                    tail = tail.next;
                }

                // 从剩下的 rest 开始继续划分 head1 和 head2
                find = rest;
            }
        }

        return dummy.next;
    }

    /**
     * 自顶向下<strong>递归式归并</strong>（空间复杂度 O(log(n))）
     * @see leetcode.LC_Array.Solution_912#sort(int[], int, int) 
     */
    public ListNode sortList(ListNode head) {
        // 递归边界，空链或单个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 快、慢指针等分链表
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 取下后半部分子链
        ListNode head2 = slow.next;
        slow.next = null;

        // 排序左右两边
        ListNode l = sortList(head);
        ListNode r = sortList(head2);

        // 合并左右两边
        return merge(l , r);
    }
}