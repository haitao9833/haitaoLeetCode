package leetcode.LC_DP;

public class Solution_62 {

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示从下标 [0][0] 走到下标 [i][j] 的路径条数
     * 初始化：包含在下述状态转移中了
     * 状态转移：
     *      dp[i][0] = 1                           初始化了第一列，只有 1 条路径，即一路向下
     *      dp[0][j] = 1                           初始化了第一行，只有 1 条路径，即一路向右
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 遍历顺序：
     *      i 基于 i-1 ，i 正序遍历 [0 -> m-1]
     *      j 基于 j-1 ，j 正序遍历 [0 -> n-1]
     * @see Solution_63
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if (i == 0 | j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 空间优化，二维变一维：
     *      遍历顺序同上
     *      状态转移 dp[i][j] = dp[i-1][j] + dp[i][j-1] 中：
     *              dp[i-1][j] == 上一轮 i-1 循环的 dp[j] ，即旧值 dp[j]
     *              dp[i][j-1] == 当前轮 i 循环的 dp[j-1] ，即新值 dp[j-1] ，所以内层 j 循环必须正序
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if (i == 0 | j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 组合数学
     *      要从左上角下标 [0][0] 走到右下角下标 [m-1][n-1]
     *      必然要向下走 m-1 步，必然要向右走 n-1 步，即一共要走 m+n-2 步
     *      路径条数 == 从 m+n-2 步中选 m-1 步，求组合 C
     *      路径条数 == 从 m+n-2 步中选 n-1 步，求组合 C
     *      公式见官方题解
     * 无需担心除不尽
     * down 自增从 [1 -> x]
     * up 自增从 [n -> n+x]
     * 连续的 x 个 up [n -> n+x] 中，必然有能整除 x 的部分
     */
    public int uniquePaths3(int m, int n) {

        // 避免溢出
        long res = 1;

        //   up 为分子 == (m+n-2)·...·(n)    共 m-1 项
        // down 为分母 == (m-1)!             共 m-1 项
        for (int up = n , down = 1 ; down < m ; up++ , down++){
            res = res * up / down;
        }

        return (int)res;
    }
}
