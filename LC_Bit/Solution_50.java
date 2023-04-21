package leetcode.LC_Bit;

public class Solution_50 {

    /**
     * @see Solution_231
     */
    public double myPow(double x , int n) {

        if (x == 0.0f) {
            return 0;
        }

        // 首先：负次幂需要统一处理为正次幂
        // 且题目给定范围 n ∈ [Integer.MIN_VALUE , Integer.MAX_VALUE]
        // 为避免 -Integer.MIN_VALUE 的溢出，将 n 存入 long 型变量
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }

        double res = 1.0;

        // 从最低位到最高位依次移位和处理 b 的每一位 bit
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            // x 倍增 x^1 , x^2 , x^4 , ...
            x *= x;
            b >>= 1;
        }

        return res;
    }
}