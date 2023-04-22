package leetcode.LC_DP;

/**
 * 至多买卖次数从 2 --> k 次，则每一天仅可能处于如下 1 + 2*k 种状态中：
 *          1、没有买卖任何股票
 *          2、第一次买入的状态
 *          3、第一次卖出的状态
 *             ......
 *        2*k、第 K 次买入的状态
 *      1+2*k、第 K 次卖出的状态
 */

public class Solution_188 {

    /**
     * 同 123 ，次数 2 扩展到次数 k，即 dp[][] 第二维度：
     *      为 0 表示没有买卖过股票的状态
     *      为奇数表示买入状态
     *      为偶数表示卖出状态
     * 直接使用 123 的空间优化一维算法
     */
    public int maxProfit(int k , int[] prices) {
        // preliminary
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 初始化，奇数买入状态都初始化为 -prices[0]
        int[] dp = new int[2 * k + 1];
        for (int i = 1 ; i <= 2 * k - 1 ; i += 2) {
            dp[i] = -prices[0];
        }

        // 外层 i 正序 [1 -> len(prices)-1] ，内层 [2*k -> 1] 逆序
        for (int i = 1 ; i < n ; i++) {
            for (int j = 2 * k - 1 ; j >= 1 ; j -= 2) {
                dp[j + 1] = Math.max(dp[j + 1] , dp[j] + prices[i]);
                dp[j] = Math.max(dp[j] , dp[j - 1] - prices[i]);
            }
        }
        return dp[2 * k];
    }
}
