package leetcode.LC_DP;

public class Solution_343 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示将正整数 i 拆成若干正整数后可以获得的最大乘积
     * 状态转移：
     *      【划分一：拆 i 和不拆 i】
     *      【划分二：拆 i 的话，至少拆成两部分正整数 j 和 i-j ，对 j 继续拆或者不拆】
     *             【至于 i-j 拆还是不拆，其实囊括在了 j 的拆或者不拆里面】
     *             【因为 j 要遍历 [2 ~ i-1] ，则 i-j 从 [i-2 ~ 1] ，其中的 1 不能拆】
     *             【则有 i-j 的各种情况 [i-2 ~ 2] ∈ j 的各种情况 [2 ~ i-1]】
     *      dp[i] = max{j * (i-j) , dp[j] * (i-j)}  其中 j 遍历 [2 ~ i-1]
     *      【项分析：dp[j] 正左方，表明 i 必须正序遍历】
     *      【注意 i=0 和 i=1 无意义，因为 0 和 1 无法按题目要求分解成至少两个正整数】
     *      【且 j 要遍历 [2 ~ i-1] ，即 i 至少从 3 开始遍历】
     * 遍历顺序：【分析见上，即 i 正序遍历 [3 -> n] + 内层 j 的正序或逆序遍历 [2 ~ i-1] 都可以】
     * 初始化：
     *      dp[2] = 1    2 最多拆分成 1 和 1 ，则唯一的乘积为 1 × 1 = 1
     */
    public int integerBreak1(int n) {
        // 初始化
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3 ; i <= n ; i++){
            for (int j = 2 ; j <= i - 1 ; j++){
                dp[i] = Math.max(dp[i] , Math.max(j * (i - j) , dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * 数学：将正整数 n 拆分为尽可能多的 3 可以使得乘积最大
     */
    public int integerBreak(int n) {
        // 特殊处理
        if (n == 2 || n == 3) {
            return n - 1;
        }

        // 商和余数
        // n = quotient * 3 + remainder
        int quotient = n / 3;
        int remainder = n % 3;

        if (remainder == 0) {
            return (int)Math.pow(3 , quotient);
        } else if (remainder == 1) {
            // 余数若为 1 ，则搭配一个 3 以拆分成 2 * 2 > 3 * 1
            return (int)Math.pow(3 , quotient - 1) * 2 * 2;
        } else {
            return (int)Math.pow(3 , quotient) * 2;
        }
    }
}