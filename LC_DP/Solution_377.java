package leetcode.LC_DP;

public class Solution_377 {

    /**
     * nums[] 为物品列表<p>
     * 且有 nums[i] = weight[i] = value[i]
     */
    public int combinationSum4(int[] nums , int target) {

        int[] dp = new int[target + 1];

        // 初始化
        dp[0] = 1;

        // 排列
        for (int j = 0 ; j <= target ; j++){
            for (int i = 0 ; i < nums.length ; i++){
                if (nums[i] <= j) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
