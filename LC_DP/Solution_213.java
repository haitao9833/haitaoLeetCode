package leetcode.LC_DP;

import java.util.Arrays;

public class Solution_213 {

    /**
     * 第一家 nums[0] 和最后一家 nums[n-1] 最多只能偷一家，当然也可能都不偷，偷不偷交由状态转移方程去选择
     * 则取如下两种情况的最大值即可：
     *      1、在 nums[0 ~ n-2] 中能偷到的最大金额总数
     *      2、在 nums[1 ~ n-1] 中能偷到的最大金额总数
     *      至于仅偷 nums[1 ~ n-2] 的情况，必然包括在情况 1 和 2 内
     * @see Solution_337
     */
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0] , nums[1]);
        }

        // 指定范围 [start , end) 复制数组
        int res1 = rob198(Arrays.copyOfRange(nums , 0 , n - 1));
        int res2 = rob198(Arrays.copyOfRange(nums , 1 , n));
        return Math.max(res1 , res2);
    }

    /**
     * 直接复制 198 的代码
     */
    public int rob198(int[] nums) {
        int n = nums.length;
        if (nums.length == 2) {
            return Math.max(nums[0] , nums[1]);
        }
        int downdown = nums[0];
        int down = Math.max(nums[0] , nums[1]);
        int res = 0;

        for (int i = 2 ; i < n ; i++) {
            res = Math.max(down , downdown + nums[i]);
            downdown = down;
            down = res;
        }
        return res;
    }
}
