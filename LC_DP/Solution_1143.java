package leetcode.LC_DP;

public class Solution_1143 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符中最长的、公共的、子序列的长度
     *      注意 i 和 j 表示第几个字符，非下标，因为前 0 个字符（空字符串）是有意义的
     *      多一行一列，也比较方便处理边界条件
     * 状态转移：
     *      【划分：看 text1 的第 i 个字符和 text2 的第 j 个字符是否相同】
     *      dp[i][j] = dp[i-1][j-1] + 1               在 text1[i-1] == text2[j-1] 的情况下
     *      dp[i][j] = max(dp[i-1][j] , dp[i][j-1])   在 text1[i-1] != text2[j-1] 的情况下
     *      【项分析一：dp[i-1][j]     正上方】
     *      【项分析二：dp[i][j-1]     正左方】
     *      【项分析三：dp[i-1][j-1]   左上方】
     * 遍历顺序：
     *      【保证项分析一、二、三的更新计算过】
     *      【第一维度 i 从正序遍历 [1 -> len(text1)] 并配合初始化 i=0 的情况】
     *      【第一维度 j 从正序遍历 [1 -> len(text2)] 并配合初始化 j=0 的情况】
     *      策略一：先 i 后 j
     *      策略二：先 j 后 i
     * 初始化：
     *      【第一行 i=0 即取 text1 的前 0 个字符，即空字符串】
     *      【第一列 j=0 即取 text2 的前 0 个字符，即空字符串】
     *      dp[0][j] = 0    即与空字符串的最长的、公共的、子序列的长度
     *      dp[i][0] = 0    即与空字符串的最长的、公共的、子序列的长度
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        // preliminary
        int n = text1.length();
        int m = text2.length();
        char[] chA = text1.toCharArray();
        char[] chB = text2.toCharArray();

        // 初始化
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (chA[i - 1] == chB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 二维化一维，空间优化
     * 先分析上述二维算法的项：
     *        左上方 dp[i-1][j]   ==   旧值 dp[j]      说明 i 依旧必须正序遍历 [1 -> len(text1)]
     *        正左方 dp[i][j-1]   ==   新值 dp[j-1]    说明 j 依旧必须正序遍历 [1 -> len(text2)]
     *      左上方 dp[i-1][j-1]   ==   旧值 dp[j-1]    必须用 upperLeft 记录
     * 状态转移：
     *      dp[j] = upperLeft + 1           在 text1[i-1] == text2[j-1] 的情况下
     *      dp[j] = max(dp[j] , dp[j-1])    在 text1[i-1] != text2[j-1] 的情况下
     * 遍历顺序：
     *      唯一策略：先 i 后 j
     *      注意：若先 j 后 i ，则左边列已经全部更新完毕，则过程中需要用到的 upperLeft 没法记录了
     * 初始化：【同上二维】
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        // preliminary
        int n = text1.length();
        int m = text2.length();
        char[] chA = text1.toCharArray();
        char[] chB = text2.toCharArray();

        // 初始化
        int[] dp = new int[m + 1];

        for (int i = 1 ; i <= n ; i++) {
            // dp[0] 始终为 0
            // 对于 dp[1] 来说，滚动数组直接遗传的旧值 dp[0] 即为 upperLeft
            int upperLeft = dp[0];

            for (int j = 1; j <= m ; j++) {
                // 当前待更新计算的旧值 dp[j] 将作为下一轮 j+1 循环的 upperLeft
                int temp = dp[j];

                // 更新计算当前 dp[j]
                // 当前 upperLeft 中记录的是上一轮 j-1 循环中的旧值 dp[j-1]
                if (chA[i - 1] == chB[j - 1]) {
                    dp[j] = upperLeft + 1;
                } else {
                    dp[j] = Math.max(dp[j] , dp[j - 1]);
                }

                upperLeft = temp;
            }
        }
        return dp[m];
    }
}
