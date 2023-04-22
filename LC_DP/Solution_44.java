package leetcode.LC_DP;

public class Solution_44 {

    /**
     * dp 动态规划
     * 含义：
     *      同 10
     * 初始化：
     *      dp[i][0] = false      数组默认值
     *      dp[0][0 ~ k] = true   在 s[0 ~ k] == "***...***" 即前缀为连续 '*' 的情况
     * 状态转移：
     *      【划分一：s[i-1] 匹配 p[j-1] ，p[j-1] = '*' ，s[i-1] 不匹配 p[j-1]】
     *      【划分二：若 p[j-1] = '*' 则看该 * 匹配 0 次，或 1~n 次】
     *      dp[i][j] = false                     同 44
     *      dp[i][j] = dp[i-1][j-1]              同 44
     *      dp[i][j] = dp[i][j-1] || dp[i-1][j]  当 p[j-1] == '*' ，则末尾的该 '*' 可以匹配 0 次、1~n次（多次）
     *                                           与 44 的区别正在于此，'*' 无需与前一个字符一起作用，其本身即可匹配任意字符串
     * 遍历顺序：
     *      同 10
     */
    public boolean isMatch(String s, String p) {
        // preliminary
        if (s == null || p == null) {
            return false;
        }
        int lenS = s.length();
        int lenP = p.length();
        char[] chS = s.toCharArray();
        char[] chP = p.toCharArray();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        // 初始化
        dp[0][0] = true;
        for (int j = 1 ; j <= lenP ; j++) {
            if (chP[j - 1] != '*') {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1 ; i <= lenS ; i++) {
            for (int j = 1 ; j <= lenP ; j++) {
                if (chP[j - 1] == chS[i - 1] || chP[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (chP[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } // else 情况即 s[i-1] 与 p[j-1] 不匹配，则 dp[] 默认值为 false ，无需显式赋值
            }
        }
        return dp[lenS][lenP];
    }
}
