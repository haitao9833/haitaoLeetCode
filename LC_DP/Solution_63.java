package leetcode.LC_DP;

public class Solution_63 {

    /**
     * dp 动态规划
     * 含义：同 62
     * 初始化：
     *      dp[0~i][0] = 1   当 [0~i][0] 连续无障碍物，且在 [i+1][0] 处遇到障碍物之后，后续 [i+1~m-1][0]都为数组默认值 0
     *      dp[0][0~j] = 1   当 [0][0~j] 连续无障碍物，且在 [0][j+1] 处遇到障碍物之后，后续 [0][j+1~n-1]都为数组默认值 0
     * 状态转移：
     *      dp[i][j] = 0                          当 [i][j] 处为障碍物，即 dp[][] 数组默认值
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1]    同 62
     * 遍历顺序：
     *      同 62
     * @see Solution_64
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 初始化第一行、第一列
        for (int i = 0 ; i < m && obstacleGrid[i][0] == 0 ; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0 ; j < n && obstacleGrid[0][j] == 0 ; j++) {
            dp[0][j] = 1;
        }

        // 第一行、第一列已经初始化过了，i 和 j 可以从 1 开始遍历
        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 空间优化，二维变一维：
     *      同 62 ，旧值 dp[j] 和新值 dp[j-1]
     *      唯一的区别是，需要手动对于障碍物位置处设置 dp[j] = 0 ，避免无效值遗留
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // preliminary
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // 初始化第一行
        for (int j = 0 ; j < n && obstacleGrid[0][j] == 0 ; j++) {
            dp[j] = 1;
        }

        for (int i = 1 ; i < m ; i++){
            if (obstacleGrid[i][0] == 1) {
                // 障碍物处手动设置 dp = 0 ，避免无效值遗留
                dp[0] = 0;
            }
            for (int j = 1 ; j < n ; j++){
                if (obstacleGrid[i][j] == 0) {
                    dp[j] += dp[j - 1];
                } else {
                    // 障碍物处手动设置 dp = 0 ，避免无效值遗留
                    dp[j] = 0;
                }
            }
        }
        return dp[n - 1];
    }
}
