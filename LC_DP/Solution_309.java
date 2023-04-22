package leetcode.LC_DP;

/**
 * 没有买卖次数限制，但今天卖出则明天不能买入，即冷冻期 1 天，则每一天仅可能处于如下 3 种状态中：
 *      1、持股
 *      2、不持股，且今天卖出
 *      3、不持股，且今天非卖出
 * 相比较于 714 ，将不持股状态细分为两种，是为了保证第 1 种状态只能由第 3 种状态转移而来，即保证第 1 种状态能分清楚前一天是否卖出
 */

public class Solution_309 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][0] 表示到下标 i 天为止，处于持股状态的最大收益
     *      dp[i][1] 表示到下标 i 天为止，处于不持股且今天卖出的最大收益
     *      dp[i][2] 表示到下标 i 天为止，处于不持股且今天非卖出的最大收益
     * 状态转移：
     *      dp[i][0] = max(dp[i-1][0] , dp[i-1][2] - prices[i])   注意，必须是 dp[i-1][2]
     *      dp[i][1] = dp[i-1][0] + prices[i]
     *      dp[i][2] = max(dp[i-1][2] , dp[i-1][1])
     *      【项分析一：第一列 dp[i][0] 依赖正上方 dp[i-1][0] 和右上方 dp[i-1][2]】
     *      【项分析二：第二列 dp[i][1] 依赖左上方 dp[i-1][0]】
     *      【项分析三：第三列 dp[i][0] 依赖正上方 dp[i-1][2] 和左上方 dp[i-1][1]】
     *      【即表明第一维度 i 必须从 i=1 开始正序遍历，且初始化 i=0 的第一行即可】
     * 遍历顺序：【综上 i 正序遍历 [1 -> len(prices)-1] ，内层 [0 ~ 2] 正序逆序都可以，并配合初始化 i=0 第一行】
     * 初始化：
     *      dp[0][1] = -prices[0]
     *      dp[0][2] = 0
     *      dp[0][3] = 0
     */
    public int maxProfit1(int[] prices) {
        // preliminary
        int n = prices.length;

        // 初始化
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];

        for(int i = 1 ; i < n ; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2] , dp[i - 1][1]);
        }

        // 比较两种不持股状态的最大值，并返回
        return Math.max(dp[n - 1][1] , dp[n - 1][2]);
    }

    /**
     * 二维化一维，空间优化：
     *      【第一维度 i 依旧外层正序遍历 [1 -> len(prices)-1] 且配合初始化 i=0 的情况】
     *      第一列 j=0 依赖正上方和右上方 j=2 旧值
     *      第二列 j=1 依赖左上方 j=1 旧值
     *      第三列 j=2 依赖正上方和左上方 j=1 旧值
     *      每一层也就 3 列，可以使用 3 个 _temp 依据全部的旧值计算完全后，再赋值给 j=0 、j=1 、j=2 列即可
     */
    public int maxProfit2(int[] prices) {
        // preliminary
        int n = prices.length;

        // 初始化第一列 dp[0] 和第二列 dp[1] 和第三列 dp[2]
        int have = -prices[0];
        int sell = 0;
        int none = 0;

        for(int i = 1 ; i < n ; i++)
        {
            // have_temp 和 sell_temp 和 none_temp 依据旧值 have 和 sell 和 none 计算完全后
            int have_temp = Math.max(have , none - prices[i]);
            int sell_temp = have + prices[i];
            int none_temp = Math.max(none , sell);

            // 再赋值给 have 和 sell 和 none
            have = have_temp;
            sell = sell_temp;
            none = none_temp;
        }
        return Math.max(sell , none);
    }
}