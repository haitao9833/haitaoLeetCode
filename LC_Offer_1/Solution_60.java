package leetcode.LC_Offer_1;

import java.util.Arrays;

/**
 * 见 k神
 * dp[n-1] 对 dp[n] 的贡献
 * 注意下标 0 ~ 5n+1 代表的和为 n ~ 6n
 *     下标：dp[n-1 , i] 的贡献在 dp[n , i+0 ~ i+5]
 *     组和：dp[n-1 ，x] 的贡献在 dp[n , x+1 ~ x+6]
 */
public class Solution_60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2 ; i <= n ; i++) {
            double[] tmp = new double[5 * i + 1];  // n 个筛子的组和范围为 [n , 6n] 共 5n + 1 个数
            for (int j = 0 ; j < dp.length ; j++) {
                for (int k = 0 ; k < 6 ; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
