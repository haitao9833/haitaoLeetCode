package leetcode.LC_DP;

public class Solution_152 {

    /**
     * 对于子数组的连续乘积，根据负负得正原理有：
     *      两个数中越大的数 * 负数 -> 越小
     *      两个数中越小的数 * 负数 -> 越大
     * 所以对于每一个 nums[i] ，需要同时记录以 nums[i] 为结尾的连续子数组中的最大乘积 iMax 和最小乘积 iMin
     *      当 nums[i+1] 为正数时，iMax * nums[i+1] 依旧为最大，iMin * nums[i+1] 依旧为最小
     *      当 nums[i+1] 为负数时，iMax * nums[i+1] 转化为最小，iMin * nums[i+1] 转化为最大
     * @see Solution_674
     */
    public int maxProduct2(int[] nums) {

        int n = nums.length;

        // 初始化 dp[i-1] 的 max 和 min
        int iMax = nums[0];
        int iMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1 ;  i < n ; i++) {
            // 负数，调换一下 iMax 和 iMin
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            // 更新计算 dp[i] 的 max 和 min
            iMax = Math.max(nums[i] , iMax * nums[i]);
            iMin = Math.min(nums[i] , iMin * nums[i]);

            // 过程中记录最大乘积
            maxProduct = Math.max(maxProduct , iMax);
        }
        return maxProduct;
    }
}
