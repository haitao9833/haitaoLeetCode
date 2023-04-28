package leetcode.LC_Offer_1;

/**
 * 动态规划：dp[i][j] 表示走到 grid[i][j] 最多能拿到的礼物价值
 *        只能向下或者先右走
 *        转移方程：
 *               dp[i][j] = max(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j]
 *        初始化：
 *              dp[0][0] = grid[0][0]
 *              dp[0][i] = 第一行累加
 *              dp[i][0] = 第一列累加
 */
public class Solution_47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1 ; i < row ; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];  // 第一列
        for (int i = 1 ; i < col ; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];  // 第一行
        for (int i = 1 ; i < row ; i++) {
            for (int j = 1 ; j < col ; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}

/**
 * 空间优化:
 *        去行保列
 *        只需要用到 dp[i - 1][j]  （二维旧的上面的，一维即自身）
 *                 dp[i][j - 1]  （二维新的左边的，从左到右跟新即可）
 *        每行遍历开始前都更新下 dp[0]
 */
class Solution_47_02 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for (int i = 1 ; i < col ; i++) dp[i] = grid[0][i] + dp[i - 1];
        for (int i = 1 ; i < row ; i++) {
            dp[0] += grid[i][0];  // 每行遍历开始前都更新下 dp[0]
            for (int j = 1 ; j < col ; j++) {
                dp[j] = grid[i][j] + Math.max(dp[j] , dp[j - 1]);
            }
        }
        return dp[col - 1];
    }
}
