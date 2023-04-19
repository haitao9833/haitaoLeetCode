package leetcode.LC_Array;

import leetcode.LC_Hash.Solution_76;

public class Solution_209 {

    /**
     * 求以 nums[r] 为结尾的、且满足元素和 >= target 的最短的连续子数组的长度
     * @see Solution_713
     * @see Solution_76
     */
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        // 初始化
        // 对于连续子数组的长度来说，初始化为 n+1 即等同于初始化为一个无效值
        int l = 0;
        int sum = 0;
        int res = n + 1;

        // 滑动 r
        for (int r = 0 ; r < n ; r++) {
            sum += nums[r];

            // 只要区间 [l , r] 满足 >= target
            // 就不断缩小 l 看是否有区间更小但元素和依然 >= target 的可能子区间
            while (sum >= target) {
                res = Math.min(res , r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == n + 1 ? 0 : res;
    }
}
