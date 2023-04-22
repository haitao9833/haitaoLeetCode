package leetcode.LC_DP;

public class Solution_1049 {

    /**
     * stones[] 为物品列表，且有 stones[i] = weight[i] = value[i]<p>
     * 尽量把一个容量为 sum(nums[]) / 2 的背包装满
     */
    public int lastStoneWeightII(int[] stones) {
        // 先求 sum(stones[])
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        // 背包容量 W = sum/2 向下取整
        // 放入背包中的石头堆重量为 dp[bag]，未放入背包中的石头堆重量为 sum-dp[bag]
        // sum - dp[bag] - dp[bag] 即两堆石头抵消后的最后一块石头的重量
        int W = sum / 2;
        int[] dp = new int[W + 1];

        for (int i = 0 ; i < stones.length ; i++){
            for (int j = W ; j >= stones[i] ; j--){
                dp[j] = Math.max(dp[j] , dp[j - stones[i]] + stones[i]);
            }
            if (dp[W] == W) {
                // 过程中若有某种装法已经可以装满了，则可以提前返回最后一块石头的最小重量
                return sum - W - W;
            }
        }
        return sum - dp[W] - dp[W];
    }
}
