package leetcode.LC_DP;

public class Solution_122 {

    /**
     * 即贪心地吃掉每一段上升收益
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for(int i = 1 ; i < n ; i++) {
            profit += Math.max(0 , prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
