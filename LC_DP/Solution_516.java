package leetcode.LC_DP;

public class Solution_516 {

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示下标 s[i , j] 内的最⻓的回⽂⼦序列的⻓度
     * 初始化：包含在下述状态转移中了
     * 状态转移：
     *      dp[i][j] = j - i + 1                       在 s[i] == s[j] 的情况下，用于初始化长度为 1 、2 、3 的回文子序列
     *      dp[i][j] = dp[i+1][j-1] + 2                在 s[i] == s[j] 的情况下
     *      dp[i][j] = max(dp[i][j-1] , dp[i+1][j])    在 s[i] != s[j] 的情况下
     * 遍历顺序：
     *      i 基于 i+1 ，逆序 [n-1 -> 0]
     *      j 基于 j-1 ，且要保证 s[i , j] 区间有效，正序 [i -> n-1]
     *      左下角 dp[i+1][j-1]
     *      正下方 dp[i+1][j]
     *      正左方 dp[i][j-1]
     * @see Solution_647
     */
    public int longestPalindromeSubseq1(String s) {

        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }

        char[] ch = s.toCharArray();
        int[][] dp = new int[n][n];

        for  (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = i ; j < n ; j++) {
                if (ch[i] == ch[j]) {
                    if (Math.abs(j - i) <= 2) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 空间优化，同 647 ：
     *       策略一，且内层 j 正序遍历 [j -> n-1] ，破坏左下角
     *       内层必须正序遍历，是因为状态转移需要用到正左方 dp[i][j-1] ，即新的、已经更新计算过的 dp[j-1]
     *       再分清楚：
     *          左下角 dp[i+1][j-1]  == lowerLeft 记录
     *          正下方 dp[i+1][j]    == 旧值 dp[j] 自己
     *          正左方 dp[i][j-1]    == 新的 dp[j-1]
     */
    public int longestPalindromeSubseq2(String s) {
        // preliminary
        int n;
        if (s == null || (n = s.length()) == 0) {
            // 赋值语句 = 的返回值就是 = 号右端的值
            return 0;
        }
        int[] dp = new int[n];
        char[] ch = s.toCharArray();

        for  (int i = n - 1 ; i >= 0 ; i--) {

            // 理解外层循环：对于第 i 次遍历，数组旧值 dp[j] == dp[i+1][j]
            int lowerLeft = 0;
            int temp;

            for (int j = i ; j < n ; j++) {
                temp = dp[j];
                if (ch[i] == ch[j]) {
                    if (i + 2 >= j) {
                        dp[j] = j - i + 1;
                    }
                    else {
                        dp[j] = lowerLeft + 2;
                    }
                } else {
                    dp[j] = Math.max(dp[j] , dp[j-1]);
                }
                lowerLeft = temp;
            }
        }
        return dp[n - 1];
    }

    /**
     * 还有第三种方法，懒得写出来：
     *      详见 5 的回文子串陷阱
     *      求 S 与其倒置 S' 的最长公共子序列，不要求连续
     *      可以使用 1143
     */
}

