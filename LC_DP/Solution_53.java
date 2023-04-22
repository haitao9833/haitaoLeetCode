package leetcode.LC_DP;

public class Solution_53 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示以下标 nums[i] 为结尾的连续子数组中的最大和
     * 状态转移：
     *      【划分：以 nums[i] 结尾的子数组或纯 nums[i]】
     *      dp[i] = max(nums[i] , dp[i-1] + nums[i])
     * 遍历顺序：i 基于 i - 1 ，即 i 正序遍历 [1 -> n-1] 且配合初始化 i=0 的情况
     * 初始化：dp[0] = nums[0]
     * @see Solution_152
     */
    public int maxSubArray(int[] nums) {

        int n = nums.length;

        // 初始化 dp[i-1]
        int dp = nums[0];
        int maxSum = nums[0];

        for (int i = 1 ; i < n ; i++) {
            dp = Math.max(nums[i] , dp + nums[i]);
            maxSum = Math.max(maxSum , dp);
        }
        return maxSum;
    }
}
