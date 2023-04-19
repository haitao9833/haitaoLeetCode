package leetcode.LC_Array;

public class Solution_713 {

    /**
     * 求以 nums[r] 为结尾的、且满足元素乘积 < k 的所有连续子数组的个数
     * @see Solution_209
     */
    public int numSubarrayProductLessThanK(int[] nums , int k) {

        int n = nums.length;
        if (k == 0 || k == 1) {
            return 0;
        }

        // 初始化
        int l = 0;
        int res = 0;
        int prod = 1;

        // 滑动 r
        for (int r = 0 ; r < n ; r++) {
            prod *= nums[r];

            // 不满足 product([l , r]) < k 则移动 l
            // 以确保 [l , r] 滑动区间有效
            while (prod >= k) {
                prod /= nums[l++];
            }

            // 累加该有效区间 [l , r] 内的所有有效的子区间个数
            res += r - l + 1;
        }
        return res;
    }
}