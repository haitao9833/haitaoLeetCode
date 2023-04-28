package leetcode.LC_Offer_1;

/**
 * 见 k神
 */
public class Solution_49 {
    public boolean isUgly(int n) {  // 263 判断丑数Ⅰ
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public int nthUglyNumber(int n) {  // 264 第 n 个丑数Ⅱ
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            int condidate1 = dp[a] * 2;    // 指向首个大于
            int condidate2 = dp[b] * 3;
            int condidate3 = dp[c] * 5;
            dp[i] = Math.min(condidate1 , Math.min(condidate2 , condidate3));
            if (dp[i] == condidate1) a++;
            if (dp[i] == condidate2) b++;
            if (dp[i] == condidate3) c++;
            /**
             * 不能用 if ... else if ... else 更新 a 、b 、c
             * 因为 2a 、3b 、5c 相同时，都要移动，例如 k神 题解图中的 b 和 a 都满足 2a == 3b == 12
             */
        }
        return dp[n - 1];
    }
}