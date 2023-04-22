package leetcode.LC_DP;


public class Solution_416 {

    /**
     * nums[] 为物品列表，且有 nums[i] == weight[i] == value[i]<p>
     * 判断能不能装满一个容量为 sum(nums[]) / 2 的背包<p>
     * 判断是否装满背包即判断 dp[j] == j
     */
    public boolean canPartition(int[] nums) {
        // 先求目标背包的容量 W == sum(nums[])/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int W = sum / 2;

        // 初始化 dp[] 数组
        int[] dp = new int[W + 1];

        for (int i = 0 ; i < nums.length ; i++){
            for (int j = W ; j >= nums[i] ; j--){
                dp[j] = Math.max(dp[j] , dp[j - nums[i]] + nums[i]);
            }
            if (dp[W] == W) {
                // 过程中若有某种装法已经可以装满了，则可以提前返回 true
                return true;
            }
        }
        return dp[W] == W;
    }
}
