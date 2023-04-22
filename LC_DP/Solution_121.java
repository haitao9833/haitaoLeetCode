package leetcode.LC_DP;

public class Solution_121 {

    /**
     * 动态规划 + 贪心 ，同 53 的一维算法，即求股票价格 prices[] 的日差值数组的连续子数组最大和
     * 只需将 53 的 nums[i] 改为 prices[i+1] - prices[i] 即可，注意 i+1 不要越界即可
     */
    public int maxProfit1(int[] prices) {
        // preliminary
        int n;
        if ((n = prices.length) == 1) {
            return 0;
        }

        // 初始化
        // 价格 P：price
        // 收益 B：profit / benefit
        int nowB = prices[1] - prices[0];
        int maxB = prices[1] - prices[0];

        for (int i = 1 ; i < n - 1 ; i++) {
            nowB = Math.max(prices[i + 1] - prices[i] , nowB + prices[i + 1] - prices[i]);
            maxB = Math.max(maxB , nowB);
        }

        // 与 53 的唯一不同之处，53 要求的连续子数组必须至少包含一个元素
        // 而若股票价格一直跌的话，可以选择不买卖股票，即收益最低为 0
        return Math.max(0 , maxB);
    }

    /**
     * 正向思维：假设今天买入，我在后面的哪一天卖出能使得收益最高
     * 逆向思维：假设今天卖出，我在前面的哪一天买入能使得收益最高
     *         对于当前遍历到的 prices[i] 确保记录有一个 minP = min(prices[0] ~ prices[i-1])
     *         则在当前下标 i 天卖出能获得的最大收益为 prices[i] - minP
     *         即计算每一天卖出能获得的最大收益，并比较、记录其中的最大值
     */
    public int maxProfit2(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxB = 0;
        for (int price : prices) {
            maxB = Math.max(maxB , price - minP);
            minP = Math.min(minP , price);
        }
        return maxB;
    }
}
