package leetcode.LC_DP;

public class Solution_1277 {

    /**
     * 在 221 中，每个 dp[i][j] 表示以下标 matrix[i][j] 为右下角的最大正方形的边长
     *                        也表示以下标 matrix[i][j] 为右下角的正方形有多少个
     * 即把 maxLen 换成一个 res 去累加 dp[i][j] 即可：
     *      下面直接使用 res 累加 221 的一维算法
     *      且需把 - '0' 去掉，因为字符 '0' 、'1' 换成了数字 0 、1
     */
    public int countSquares(int[][] matrix) {
        // 直接 copy 211 代码，将 maxLen = max(...) 换成 res += ... 即可
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        int res = 0;
        for (int j = 0 ; j < col ; j++) {
            dp[j] = matrix[0][j];
            // 累加第一行
            res += dp[j];
        }
        for (int i = 1 ; i < row ; i++) {
            int upperLeft = dp[0];
            dp[0] = matrix[i][0];
            // 累加第一列
            res += dp[0];

            for (int j = 1 ; j < col ; j++) {
                int temp = dp[j];

                if (matrix[i][j] == 1) {
                    dp[j] = Math.min(upperLeft , Math.min(dp[j] , dp[j - 1])) + 1;
                    // 累加 dp[j]
                    res += dp[j];
                } else {
                    dp[j] = 0;
                }

                upperLeft = temp;
            }
        }
        return res;
    }
}
