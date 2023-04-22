package leetcode.LC_DP;

public class Solution_518 {

    /**
     * coins[] 为物品列表<p>
     * 且有 coins[i] = weight[i] = value[i]
     */
    public int change(int amount , int[] coins) {
        int[] dp = new int[amount + 1];

        // 初始化
        dp[0] = 1;

        // 组合
        for (int i = 0 ; i < coins.length ; i++){
            for (int j = coins[i] ; j <= amount ; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
