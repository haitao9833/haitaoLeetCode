package leetcode.LC_DP;

import java.util.Arrays;

public class Solution_279 {

    /**
     * 四平方和定理：任意一个正整数 n 都可以表示为<strong>至多</strong> 4 个完全平方数的和<p>
     * 即任何容量 n 都<strong>必能被装满</strong>，且已知的最坏情况为 4 ，初始化为 4 即可
     * <hr>
     * 完全平方数 [1*1 , 2*2 , ... , ] 为物品列表<p>
     * 且有 i*i == weight[i]<p>
     * 且有 value[i] == 1
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // 其他的 dp[j] 初始化为 4
        Arrays.fill(dp , 4);

        // 但不要忘记了 dp[0] 始终为 0 ，不能设置为最坏情况
        dp[0] = 0;

        // 物品只需从 1*1 遍历到 i*i <= n 即可，因为后续的物品肯定装不下
        for (int i = 1 ; i*i <= n ; i++){
            for (int j = i*i ; j <= n ; j++){
                dp[j] = Math.min(dp[j] , dp[j - i*i] + 1);
            }
        }
        return dp[n];
    }
}
