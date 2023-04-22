package leetcode.LC_DP;

public class Solution_70 {

    /**
     * 动态规划<p>
     * 可以理解为从无意义的第 0 阶开始爬<p>
     * 含义：dp[i] 表示从第 0 阶爬到第 i 阶的方案数，注意 dp[0] 无意义<p>
     * 初始化：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dp[1] = 1<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dp[2] = 2<p>
     * 状态转移：dp[i] = dp[i-1] + dp[i-2]   同斐波那契数列的递推公式<p>
     * 遍历顺序：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i 基于 i-1 和 i-2 ，固 i 正序遍历 [3 -> n]<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配合初始化 i=1 和 i=2 ，且注意 i=0 无意义<p>
     * 可直接一维<strong>优化为常数</strong>
     */
    public int climbStairs1(int n) {
        // 特例预先判断
        if (n <= 2) {
            return n;
        }

        // 初始化第 1 阶、第 2 阶
        int downdown = 1;
        int down = 2;

        // 从第 3 阶开始遍历
        for (int i = 3 ; i <= n ; i++){
            int dp = downdown + down;
            downdown = down;
            down = dp;
        }
        return down;
    }

    /**
     * 转化为背包问题<p>
     * 即用 [1 , 2] 装满容量为 n 的背包有几种<strong>排列方案数</strong>
     * <hr>
     * 可扩展到每次可上 [1 , 2 , ... , m] 台阶 ==> 内层 i 正序遍历 [1 -> m]
     */
    public int climbStairs2(int n) {

        int[] dp = new int[n + 1];

        // 初始化
        dp[0] = 1;

        // 排列
        for (int j = 0 ; j <= n ; j++){
            for (int i = 1 ; i <= 2 ; i++){
                if (i <= j) {
                    dp[j] += dp[j - i];
                }
            }
        }
        return dp[n];
    }


    /**
     * 数学：详见 509
     *      状态转移方程同斐波那契数列的递推公式：
     *                dp[i] = dp[i-1] + dp[i-2]
     *                 F(n) =  F(n-1) +  F(n-2)
     *      初始化不同：dp[1] = 1 ，dp[2] = 2
     *                 F(0) = 0 ， F(1) = 1 ， F(2) = 1 ， F(3) = 2
     *      可得出：dp[n] = F(n+1)
     *      即只需将 509 的求 F(n) 改为求 F(n+1) 即可
     */
    public int climbStairs3(int n) {
        // preliminary
        if (n <= 2) {
            return n;
        }
        // 求 F(n+1)
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = matrixPow(q , n);
        return res[0][0];
    }
    public int[][] matrixMultiply(int[][] A , int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0 ; i < 2 ; i++) {
            for (int j = 0 ; j < 2 ; j++) {
                C[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j];
            }
        }
        return C;
    }
    public int[][] matrixPow(int[][] A , int n) {
        int[][] res = {{1, 0}, {0, 1}};
        while (n != 0) {
            if ((n & 1) == 1) {
                res = matrixMultiply(res , A);
            }
            A = matrixMultiply(A , A);
            n >>= 1;
        }
        return res;
    }
}