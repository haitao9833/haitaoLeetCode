package leetcode.LC_DP;

public class Solution_91 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i] 表示前 i 个字符的解码方案数
     *      注意 i 非下标，表示第几个字符
     *      前 0 个字符是有意义的，即空字符，即空消息，也算一种解码方案
     * 状态转移：
     *      【划分：第 i 个字符 s[i-1] 可以单独解码时候的方案数 + 可以和前面一个数字联合解码时候的方案数】
     *      【其他不可以单独解码（本身是 0）、联合解码的情况（前导 0 、超范围），则保持 dp[] 数组的默认值 0 即可】
     *      dp[i] = dp[i-1]                 s[i-1] != 0               可以单独解码
     *      dp[i] = dp[i-1] + dp[i-2]       s[i-2]s[i-1] ∈ [10~26]    可以联合解码，下限为 10 是避免前导 0
     *      【 i 从 2 开始正序遍历 [2 -> len(s)] 可确保一定有前面一个数字，并配合初始化 dp[0] 和 dp[1]】
     * 遍历顺序：【综上】
     * 初始化：
     *      dp[0] = 1   可以理解为在 s[0]s[1] 联合解码时，必须有 dp[2] 累加 dp[0] = 1 方案数
     *      dp[1] = 1   需确保 s[0] != '0'
     * @see Solution_139
     */
    public static int numDecodings1(String s) {

        int n = s.length();
        char[] chS = s.toCharArray();
        if (chS[0] == '0') {
            return 0;
        }

        // 初始化
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i <= n ; i++) {

            // s[i-2]s[i-1]
            int pre = chS[i - 2] - '0';
            int cur = chS[i - 1] - '0';
            int num = pre * 10 + cur;

            if (cur != 0) {
                dp[i] = dp[i - 1];
            }
            if (10 <= num && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * 二维化一维，空间优化
     * 先分析上述二维算法的项：
     *      dp[i-1] == down
     *      dp[i-2] == downdown
     * 初始保持同上述二维一模一样即可
     */
    public static int numDecodings2(String s) {
        // preliminary
        int n = s.length();
        char[] chS = s.toCharArray();
        if (chS[0] == '0') {
            return 0;
        }

        // 初始化 dp[0] 和 dp[1] 和 dp[i]
        int downdwon = 1;
        int down = 1;

        for (int i = 2 ; i <= n ; i++) {
            int cur = chS[i - 1] - '0';
            int pre = chS[i - 2] - '0';
            int num = pre * 10 + cur;

            int res = 0;
            if (cur != 0) {
                res = down;
            }
            if (10 <= num && num <= 26) {
                res += downdwon;
            }

            downdwon = down;
            down = res;
        }
        return down;
    }
}