package leetcode.LC_Linked;

import leetcode.LC_50.ListNode;

public class Solution_2 {

    /**
     * 和 66 恰好相反，head 为最低位，个位
     * @see leetcode.LC_Array.Solution_66
     * @see leetcode.LC_Bit.Solution_371
     */
    public ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        // 首节点 head 和有效尾指针 tail
        ListNode resHead = null;
        ListNode resTail = null;

        // 进位
        int up = 0;

        // 当 l1 或 l2 遍历完后，其对应 null 节点数值为 0
        while (l1 != null || l2 != null) {

            // 总和 sum
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + up;

            // 当前位值
            if (resHead == null) {
                // 创建首节点
                resHead = resTail = new ListNode(sum % 10);
            } else {
                // 创建非首节点
                resTail.next = new ListNode(sum % 10);
                resTail = resTail.next;
            }

            // 进位 up
            up = sum / 10;

            // 移动 l1 、l2 指针
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 最后是否还有进位
        if (up != 0) {
            resTail.next = new ListNode(up);
        }
        return resHead;
    }
}
