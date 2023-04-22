package leetcode.LC_DP;

/**
 * 至多买卖两次，则每一天仅可能处于如下 5 种状态中：
 *      1、没有买卖任何股票
 *      2、第一次买入的状态
 *      3、第一次卖出的状态
 *      4、第二次买入的状态
 *      5、第二次卖出的状态
 */

public class Solution_123 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][0] 表示到下标 i 天为止，没有任何买卖操作时的最大收益，始终保持为数组默认值 0 即可
     *      dp[i][1] 表示到下标 i 天为止，处于第一次买入状态的最大收益
     *      dp[i][2] 表示到下标 i 天为止，处于第一次卖出状态的最大收益
     *      dp[i][3] 表示到下标 i 天为止，处于第二次买入状态的最大收益
     *      dp[i][4] 表示到下标 i 天为止，处于第二次卖出状态的最大收益
     * 状态转移：
     *      dp[i][1] == max(dp[i-1][1] , dp[i-1][0] - prices[i])   今天买入，或者之前就买入了
     *      dp[i][2] == max(dp[i-1][2] , dp[i-1][1] + prices[i])   今天卖出，或者之前就卖出了
     *      dp[i][3] == max(dp[i-1][3] , dp[i-1][2] - prices[i])   今天买入，或者之前就买入了
     *      dp[i][4] == max(dp[i-1][4] , dp[i-1][3] + prices[i])   今天卖出，或者之前就卖出了
     *      【项分析：dp[i][1~4] 都得依赖正上方 dp[i-1][1~4] 和左上方 dp[i-1][0~3]】
     *      【且仅在第一行 i=0 时 dp[i][1~4] 无正上方和左上方，则 i 必须从 1 开始正序遍历 [1 -> len(prices)-1]】
     *      【且需配合初始化 i=0 的各种情况】
     * 遍历顺序：【第一维度 i 正序遍历 [1 -> len(prices)-1] ，内层 [1 ~ 4] 正序逆序无所谓】
     * 初始化：
     *      dp[0][1] = -prices[0]     第 0 天买入
     *      dp[0][2] = 0              第 0 天买入并卖出
     *      dp[0][3] = -prices[0]     第 0 天买入并卖出，然后再买入
     *      dp[0][4] = 0              第 0 天买入并卖出，然后再买入再卖出
     *      【无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，这是因为这一操作带来的收益为零】
     */
    public int maxProfit1(int[] prices) {
        // preliminary
        int n = prices.length;

        // 初始化
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1 ; i < n ; i++) {
            dp[i][1] = Math.max(dp[i - 1][1] , dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2] , dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3] , dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4] , dp[i - 1][3] + prices[i]);
        }
        return dp[n - 1][4];
    }

    /**
     * 二维化一维，空间优化：
     * 分析上述二维算法的项：
     *      左上方 dp[i-1][0~3] == 旧值 dp[0~3]
     *      正上方 dp[i-1][1~4] == 旧值 dp[1~4]
     *      【则 i 同时正序遍历 [1 -> len(prices)-1]】
     *      【而 j 必须逆序遍历 [4 -> 1]】
     *      【初始化同上述二维算法一模一样即可】
     */
    public int maxProfit2(int[] prices) {
        // preliminary
        int n = prices.length;

        // 初始化
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1 ; i < n ; i++) {
            dp[4] = Math.max(dp[4] , dp[3] + prices[i]);
            dp[3] = Math.max(dp[3] , dp[2] - prices[i]);
            dp[2] = Math.max(dp[2] , dp[1] + prices[i]);
            dp[1] = Math.max(dp[1] , dp[0] - prices[i]);
        }
        return dp[4];
    }
}