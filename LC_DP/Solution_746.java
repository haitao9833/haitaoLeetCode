package leetcode.LC_DP;

public class Solution_746 {

    /**
     * 注意：是从下标 i 台阶出发向上继续跳<strong>才需要支付</strong> cost[i]
     * @see Solution_70
     */
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        if (n == 2) {
            return Math.min(cost[0] , cost[1]);
        }

        // 初始化 dp[0] 和 dp[1]
        int downdown = 0;
        int down = 0;
        int res = 0;

        for (int i = 2 ; i <= n ; i++){
            res = Math.min(downdown + cost[i - 2] , down + cost[i - 1]);
            downdown = down;
            down = res;
        }
        return res;
    }
}
