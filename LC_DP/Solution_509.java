package leetcode.LC_DP;

/**
 * 数学：斐波那契数列
 *      F(0) = 0 ，F(1) = 1
 *      F(n) = F(n - 1) + F(n - 2)
 */

public class Solution_509 {

    /**
     * 动态规划
     */
    public int fib1(int n) {
        // preliminary
        if (n <= 1) {
            return n;
        }

        // 初始 F(0) 和 F(1) 和 F(n)
        int downdown = 0;
        int down = 1;
        int res = 0;

        for (int i = 2 ; i <= n ; i++){
            res = downdown + down;
            downdown = down;
            down = res;
        }
        return res;
    }

    /**
     * 矩阵快速幂，见官方题解
     * 快速幂可参考 50 ，不过无需像 50 一样处理 n == 0 和负次幂的情况
     */
    public int fib(int n) {
        // preliminary
        if (n <= 1) {
            return n;
        }
        // 求 F(n)
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = matrixPow(q , n - 1);
        return res[0][0];
    }
    public int[][] matrixMultiply(int[][] A , int[][] B) {
        // 计算矩阵相乘 A * B = C
        int[][] C = new int[2][2];

        // i 为 A 的行号，j 为 B 的列号
        for (int i = 0 ; i < 2 ; i++) {
            for (int j = 0 ; j < 2 ; j++) {
                C[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j];
            }
        }
        return C;
    }
    public int[][] matrixPow(int[][] A , int n) {
        // 计算矩阵快速幂 A^n
        // res 初始化为单位矩阵
        int[][] res = {{1, 0}, {0, 1}};

        while (n != 0) {
            if ((n & 1) == 1) {
                res = matrixMultiply(res , A);
            }
            // 基础之自增 + 指数二进制移位
            A = matrixMultiply(A , A);
            n >>= 1;
        }
        return res;
    }
}
