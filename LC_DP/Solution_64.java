package leetcode.LC_DP;

public class Solution_64 {

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示从下标 [0][0] 走到 [i][j] 的路径数字最小总和
     * 初始化：包含在下述状态转移中了
     * 状态转移：
     *      dp[0][0] = grid[0][0]                                   第一个格子初始化，即为自己的格子数值
     *      dp[0][j] = dp[0][j-1] + grid[0][j]                      第一行初始化，一路向右连续累加即可
     *      dp[i][0] = dp[i-1][0] + grid[i][0]                      第一列初始化，一路向下连续累加即可
     *      dp[i][j] = min(dp[i][j-1] , dp[i-1][j]) + grid[i][j]    从上来或从左来，选一个最小的，与自己的格子数值累加
     * 遍历顺序：同 62
     * @see Solution_746
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i == 0 && j ==0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] , dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
