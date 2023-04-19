package leetcode.LC_Array;

import leetcode.LC_Linked.Solution_142;

public class Solution_287 {

    /**
     * 同 142 找环入口 <P>
     * 见题解图解 <P>
     * 数值范围为 [1 , n] ，且给定 n+1 个整数，说明下标范围为 [0 , n] <P>
     * 建立 "下标 --> 元素 --> 下标 --> ... --> 元素" 的<strong>逻辑链表</strong> <P>
     * 且需从下标 0 节点开始，因为元素值 [1 , n] 范围不包括 0 ，即 0 节点必在环外 <P>
     * 题目要求 O(1) 空间，不能像 217 那样使用 Set
     * @see Solution_142
     * @see Solution_202
     */
    public int findDuplicate(int[] nums) {

        // 同 142 初始化，先走 1 、2 步，保持步数的两倍关系
        int slow = nums[0];
        int fast = nums[nums[0]];

        // 题目保证一定存在环
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // slow 从 head（0） 重新走 ==> 找环入口
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
