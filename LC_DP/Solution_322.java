package leetcode.LC_DP;

import java.util.Arrays;

public class Solution_322 {

    /**
     * coins[] 为物品列表<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;且有 coins[i] == weight[i]<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;且有 value[i] == 1<p>
     * bug 最小的思路二<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;coins[] 中有最小硬币面值 1 的时候，易知 dp[] 的上限为 amount<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;但不能确保 coins[] 中一定有面值为 1 的硬币<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所以需要设置 -∞ 无效状态 max = 上限 + 1 = amount + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 上限 + 1 == 无效状态
        int max = amount + 1;
        Arrays.fill(dp , max);

        // 但不要忘记了 dp[0] 始终为 0 ，不能设置为无效状态
        dp[0] = 0;

        for (int i = 0 ; i < coins.length ; i++){
            for (int j = coins[i] ; j <= amount ; j++){
                dp[j] = Math.min(dp[j] , dp[j - coins[i]] + 1);
            }
        }

        // 判断是否装满，亦或是无效状态
        return dp[amount] == max ? -1 : dp[amount];
    }
}
