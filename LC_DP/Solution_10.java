package leetcode.LC_DP;

public class Solution_10 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示 p 的前 j 个字符能否匹配 s 的前 i 个字符
     *      注意：i 和 j 非下标，而是从 1 开始的第几个字符
     *      即有：s[i-1] 为 s 的第 i 个字符，p[j-1] 为 p 的第 j 个字符
     * 初始化：
     *      dp[i][0] = false     数组默认值
     *      dp[0][0] = ture
     *      dp[0][j] = p[j-1] == '*' && dp[0][j-2]  因为 '*' 可以消除前一个字符的影响
     *                                              例如 s = aab 与 p = a*b*cd*
     *                                              其中 a* 、a*b* 都可以匹配 s 的前 0 个字符（即空字符串）
     *                                              但 a*b*cd* 不行，因为最后一个 '*' 只能消除 d 不能消除 c
     *      正因为要初始化 p 匹配 s 的前 0 个字符（空字符串）的情况
     *      所以在 dp[][] 中 i 、j 不能代表下标，不然就会出现 dp[-1][j] = true
     * 状态转移：
     *      【划分一：看 s[i-1] 与 p[j-1] 匹配或不匹配，或者 p[j-1] = '*'】
     *      【划分二：若 p[j-1] = '*' 则看 s[i-1] 与 p[j-2] 匹配或不匹配】
     *      dp[i][j] = false          当 s[i-1] 与 p[j-1] 不匹配的情况下，即 dp[] 数组的默认值
     *      dp[i][j] = dp[i-1][j-1]   当 p[j-1] == s[i-1] || p[j-1] == . 即 s[i-1] 与 p[j-1] 匹配的情况下
     *      dp[i][j] = dp[i][j-2]     当 p[j-1] == '*' && (p[j-2] != s[i-1] && p[j-2] != .) 情况下
     *                                即 s[i-1] 与 p[j-2] 不匹配，此时 p[j-1] 位置的 '*' 作用是消除 p[j-2]
     *      dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
     *                                当 p[j-1] == '*' && (p[j-2] == s[i-1] || p[j-2] == .) 情况下
     *                                即 s[i-1] 与 p[j-2] 匹配，此时末尾的 2 个字符 "p[j-1]*" 可以匹配 0 次、1~n次（多次）
     *      详解：
     *          0 次：dp[i][j-2] 忽略 "p[j-1]*" 的作用，看 p 的前 j-2 个字符能否匹配 s 的前 i 个
     *          1 次：dp[i][j-1] 忽略 '*' 的作用，看 p 的前 j-1 个字符能否匹配 s 的前 i 个
     *          n 次：dp[i-1][j] 假设 s[i-1] 已经被 "p[j-1]*" 匹配掉了，再继续使用 p 的前 j 个字符看是否能匹配 s 的前 i-1 个
     *          其实 1 次包含在 n 次中，可以省略
     * 遍历顺序：
     *      i 基于 i - 1 ，即 i 遍历顺序从 [1 -> lenS]
     *      j 基于 j - 1 ，即 j 遍历顺序从 [1 -> lenP]
     */
    public boolean isMatch(String s, String p) {
        // preliminary
        int lenS = s.length();
        int lenP = p.length();
        char[] chS = s.toCharArray();
        char[] chP = p.toCharArray();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        // 初始化
        dp[0][0] = true;
        for (int j = 1 ; j <= lenP ; j++) {
            if (chP[j - 1] == '*' && dp[0][j - 2]) {
                // 题目保证 j == 1 时，即 p 的第一个字符不可能为 *
                // 由于 && 的短路性质，不可能出现 dp[0][1 - 2] = dp[0][-1] 出现
                dp[0][j] = true;
            }
        }

        for (int i = 1 ; i <= lenS ; i++) {
            for (int j = 1 ; j <= lenP ; j++) {
                if (chP[j - 1] == chS[i - 1] || chP[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (chP[j - 1] == '*') {
                    if (chP[j - 2] != chS[i - 1] && chP[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                } // else 情况即 s[i-1] 与 p[j-1] 不匹配，则 dp[] 默认值为 false ，无需显式赋值
            }
        }
        return dp[lenS][lenP];
    }
}
