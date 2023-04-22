package leetcode.LC_DP;

/**
 * 没有买卖次数限制，则每一天仅可能处于如下 2 种状态中：
 *      1、持股
 *      2、不持股
 */

public class Solution_714 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][0] 表示到下标 i 天为止，处于持股状态的最大收益
     *      dp[i][1] 表示到下标 i 天为止，处于不持股状态的最大收益
     * 状态转移：
     *      dp[i][0] = max(dp[i-1][0] , dp[i-1][1] - prices[i])
     *      dp[i][1] = max(dp[i-1][1] , dp[i-1][0] + prices[i] - fee)   在卖出时交手续费 fee
     *      【项分析一：dp[i][0] 依赖正上方 dp[i-1][0] 和右上方 dp[i-1][1]】
     *      【项分析二：dp[i][1] 依赖正上方 dp[i-1][1] 和左上方 dp[i-1][0]】
     *      【表明 i 必须正序遍历，且必须初始化 i=0 的第一行】
     * 遍历顺序：【综上 i 正序遍历 [1 -> len(prices)-1] ，内层 [0~1] 正序逆序都可以】
     * 初始化：
     *      dp[0][0] = -prices[0]
     *      dp[0][1] = 0
     */
    public int maxProfit1(int[] prices , int fee) {
        // preliminary
        int n = prices.length;

        // 初始化
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];

        for (int i = 1 ; i < n ; i++) {
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] + prices[i] - fee);
        }

        return dp[n - 1][1];
    }

    /**
     * 二维化一维，空间优化：
     *      【第一维度 i 依旧外层正序遍历 [1 -> len(prices)-1] 且配合初始化 i=0 的情况】
     *      第一列 j=0 依赖正上方旧值和右上方 j=1 旧值
     *      第二列 j=1 依赖正上方旧值和左上方 j=0 旧值
     *      若内层 j 正序，则需要使用 upperLeft  记录 j=0 的旧值供 j=1 列使用
     *      若内层 j 逆序，则需要使用 upperRight 记录 j=1 的旧值供 j=0 列使用
     *      不过每一层也就 2 列，可以使用 2 个 _temp 依据全部的旧值计算完全后，再赋值给 j=0 、j=1 列即可
     */
    public int maxProfit2(int[] prices , int fee) {
        // preliminary
        int n = prices.length;

        // 初始化第一列 dp[0] 和第二列 dp[1]
        int have = -prices[0];
        int none = 0;

        for (int i = 1 ; i < n ; i++) {
            // have_temp 和 none_temp 依据旧值 have 和 none 计算完全后
            int have_temp = Math.max(have , none - prices[i]);
            int none_temp = Math.max(none , have + prices[i] - fee);

            // 再赋值给 have 和 none
            have = have_temp;
            none = none_temp;
        }
        return none;
    }

    /**
     * 正向思考：在卖出时交手续费
     * 逆向思考：在买入时交手续费，贪心算法：
     *      成本 == 买入价 + 手续费
     *      贪心性一：成本能降就降
     *      贪心性二：利润有吃就吃 （吃完后成本变为卖出价，表示不着急开启一场新的买卖，可能只是中途利润）
     * 例如 prices[] = [4 , 1 , 3 , 2 , 8 , 10 , 4 , 9] 手续费为 fee = 2
     *      初始成本  cost = 4 + 2
     *      降低成本  cost = 1 + 2 < 4 + 2
     *      没有操作  3 - cost =  0 && cost < 3 + 2
     *      没有操作  2 - cost = -1 && cost < 2 + 2
     *      吃到利润  8 - cost =  5      （此时 cost =  8）
     *      吃到利润 10 - cost =  2      （此时 cost = 10）
     *      降低成本  cost = 4 + 2 < 10  （表明开始一场新的买卖操作）
     *      吃到利润  9 - cost =  3
     *       总利润 == 5 + 2 + 3 == 10
     */
    public int maxProfit3(int[] prices , int fee) {
        // preliminary
        int n = prices.length;

        // 初始化
        int cost = prices[0] + fee;
        int profit = 0;

        for (int i = 1 ; i < n ; i++) {
            if (cost > prices[i] + fee) {
                // 贪心性一：成本能降就降
                cost = prices[i] + fee;
            } else if (cost < prices[i]) {
                // 贪心性二：利润有吃就吃
                profit += prices[i] - cost;
                cost = prices[i];
            } // else 其他情况，没动作，不操作
        }
        return profit;
    }
}