package leetcode.LC_DP;

/**
 * 看图 == 画图 == 思路
 */

public class Solution_221 {

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示以下标 matrix[i][j] 为右下角的最大正方形的边长
     * 状态转移：
     *      【划分一：matrix[i][j] 是不是 1】
     *      【划分二：matrix[i][j] 是 1 的时候，则由最小的 min(上 , 左 , 左上) 决定】
     *      dp[i][j] = 0                                                在 matrix[i][j] == 0 的情况下
     *      dp[i][j] = min(dp[i-1][j] , dp[i][j-1] , dp[i-1][j-1]) + 1  在 matrix[i][j] == 1 的情况下
     *      【第一行 i=0 无上和左上，第一列 j=0 无左和左上】
     *      【第一维度 i 必须从 1 开始正序遍历 [1 -> row-1] 且配合初始化 i=0 的各种情况】
     *      【第二维度 j 必须从 1 开始正序遍历 [1 -> col-1] 且配合初始化 j=0 的各种情况】
     * 遍历顺序：【综上】
     * 初始化：【初始化可以合并到遍历中去】
     *      dp[0][j] = matrix[0][j] - '0'
     *      dp[i][0] = matrix[i][0] - '0'
     */
    public int maximalSquare1(char[][] matrix) {
        // preliminary
        int row = matrix.length;
        int col = matrix[0].length;

        // 初始化
        int[][] dp = new int[row][col];
        int maxLen = 0;

        // 第一行 i=0 和第一列 j=0 的初始化合并到遍历中去了
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j] , dp[i][j - 1])) + 1;
                    }
                    maxLen = Math.max(maxLen , dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    /**
     * 二维化一维，空间优化：
     * 分析上述二维算法的项可知：
     *        上 dp[i-1][j]    == 旧值 dp[j]
     *        左 dp[i][j-1]    == 新值 dp[j-1]   说明 j 必须正序遍历
     *      左上 dp[i-1][j-1]  == 旧值 dp[j-1]   说明需要用 upperLeft 记录下
     * 【初始化要保持和二维算法一模一样，则 dp[0] 在每轮循环开始时，都要手动更新】
     */
    public int maximalSquare2(char[][] matrix) {
        // preliminary
        int row = matrix.length;
        int col = matrix[0].length;

        // 初始化，第一行 i=0 的初始化不合并到遍历中去了
        int[] dp = new int[col];
        int maxLen = 0;
        for (int j = 0 ; j < col ; j++) {
            dp[j] = matrix[0][j] - '0';
            maxLen = Math.max(maxLen , dp[j]);
        }

        // 第一列 j=0 的初始化需要在每轮循环开始前手动更新，避免滚动数组的遗传旧值的影响
        for (int i = 1 ; i < row ; i++) {

            // dp[0] 更新计算前旧值 == 下一轮 dp[1] 的 upperLeft
            int upperLeft = dp[0];
            dp[0] = matrix[i][0] - '0';
            maxLen = Math.max(maxLen , dp[0]);

            for (int j = 1 ; j < col ; j++) {
                // dp[j] 更新计算前旧值 == 下一轮 dp[j+1] 的 upperLeft
                int temp = dp[j];

                if (matrix[i][j] == '1') {
                    dp[j] = Math.min(upperLeft , Math.min(dp[j] , dp[j - 1])) + 1;
                    maxLen = Math.max(maxLen , dp[j]);
                } else {
                    // 必须手动更新，避免滚动数组的遗传旧值的影响
                    dp[j] = 0;
                }

                upperLeft = temp;
            }
        }
        return maxLen * maxLen;
    }
}
