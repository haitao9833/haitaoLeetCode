package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_23 {

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
     * 逐一合并
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = merge(head , list);
        }
        return head;
    }

    /**
     * 自底向上两两合并 <P>
     * 就是一种<strong>迭代式归并</strong>（空间复杂度 O(1)） <P>
     * 需要<strong>双层循环</strong>实现：外层循环代表轮次 、即有几轮，内层循环执行两两相邻的合并
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        int k = lists.length;
        if (k == 0) {
            return null;
        }

        // k 表示 lists[] 中共有多少个链表待合并
        while (k != 1) {

            // idx 为 lists[] 中待填充的下标位
            int idx = 0;

            // i 遍历 lists[0 , k-1] 两两合并
            for (int i = 0 ; i < k ; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge(lists[i] , lists[i + 1]);
                }
            }

            // 一轮两两合并后有效链表的个数
            k = idx;
        }
        return lists[0];
    }

    /**
     * 自顶向下两两合并 <P>
     * 就是一种<strong>递归式归并</strong>（空间复杂度 O(log(n))）
     * @see leetcode.LC_Array.Solution_912#sort(int[], int, int) 
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 合并 lists[l , r] 区间内的链表
        return mergeLR(lists , 0 , lists.length - 1);
    }
    private ListNode mergeLR(ListNode[] lists , int l , int r) {
        // 递归边界
        if (l == r) {
            return lists[l];
        }

        // 同 912 等分 ==> 合并好两边再将两边合并
        int mid = l + (r - l) / 2;
        ListNode l1 = mergeLR(lists , l , mid);
        ListNode l2 = mergeLR(lists ,mid + 1 , r);

        return merge(l1 , l2);
    }

    /**
     * <strong>优先队列 + 多路归并：出堆一个元素，就入堆其相邻的元素</strong>
     * @see leetcode.LC_Array.Solution_378#kthSmallest1(int[][], int)
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        // 小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // 第一列元素入堆
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // 依次取出堆顶
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            // 入堆该节点的下一节点
            if (min.next != null) {
                queue.offer(min.next);
            }
            tail.next = min;
            tail = tail.next;
        }
        return dummy.next;
    }
}
