package leetcode.LC_DP;

public class Solution_583 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示 word1 的前 i 个和 word2 的前 j 个字符，通过删除转换成相同字符串所需的最少操作次数
     *      注意 i 和 j 表示前几个字符，而非下标
     *      因为前 0 个字符（空字符）也是有意义的
     * 状态转移：
     *      【划分一：看 word1 的第 i 个字符（word1[i-1]）和 word2 的第 j 个字符（word2[j-1]）是否相同】
     *      【划分二：不同的情况下，是删 word1 删 word2 还是都删除，取三者中操作数最小的情况】
     *      dp[i][j] = dp[i-1][j-1]         在 word1[i-1] == word2[j-1] 的情况下
     *      dp[i][j] = dp[i-1][j] + 1       在 word1[i-1] != word2[j-1] 的情况下，删除 word1[i]
     *      dp[i][j] = dp[i][j-1] + 1       在 word1[i-1] != word2[j-1] 的情况下，删除 word2[j]
     *      dp[i][j] = dp[i-1][j-1] + 2     在 word1[i-1] != word2[j-1] 的情况下，删除 word1[i] 和 word2[j]
     *      【项分析一：dp[i-1][j-1]  左上方，不管是 word1[i-1] 和 word2[j-1] 是 == 还是 != 都需要依赖之】
     *      【项分析二：dp[i][j-1]    正左方，仅在 word1[i-1] != word2[j-1] 时依赖之】
     *      【项分析三：dp[i-1][j]    正上方，仅在 word1[i-1] != word2[j-1] 时依赖之】
     *      【项分析和 72 完全相同】
     * 遍历顺序：【和 72 完全相同】
     * 初始化：【和 72 完全相同】
     * 【与 72 比较，唯一唯一唯一的区别在于状态转移中第 4 种情况从 +1 改为 +2 ，其他完全相同】
     */
    public int minDistance1(String word1, String word2) {
        // preliminary
        int n = word1.length();
        int m = word2.length();
        char[] word1Ch = word1.toCharArray();
        char[] word2Ch = word2.toCharArray();

        // 初始化
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0 ; j <= m ; j++) {
            dp[0][j] = j;
        }
        for (int i = 0 ; i <= n ; i++) {
            dp[i][0] = i;
        }

        // 先 i 后 j 或者先 j 后 i 都行
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (word1Ch[i - 1] == word2Ch[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2 , Math.min(dp[i - 1][j] , dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 与 72 的唯一区别：仅状态转移方程中旧值 upperLeft+1 改为 upperLeft+2 的区别
     */
    public int minDistance(String word1, String word2) {
        // preliminary
        int n = word1.length();
        int m = word2.length();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

        // 即将二维中 i=0 的情况提前手动初始化
        int[] dp = new int[m+1];
        for (int j = 0 ; j <= m ; j++) {
            dp[j] = j;
        }

        for (int i = 1 ; i <= n ; i++) {
            // 即将二维中 j=0 的情况合并到循环内部中去
            // 滚动数组直接遗传的 dp[0] 对于 dp[1] 来说即为左上方 upperLeft
            // 在更新 dp[0] 之前，先将旧值 dp[0] 记录下来
            int upperLeft = dp[0];
            dp[0] = i;

            for (int j = 1 ; j <= m ; j++) {
                // upperLeft = dp[0]-1
                // 更新计算前先记录下来，作为下一轮 j+1 循环需要使用的 upperLeft
                int temp = dp[j];

                // 更新计算，此时 upperLeft 代表的是上一轮 j-1 循环中的旧值 dp[j-1]
                // 而 min(... , dp[j-1]) 中的 dp[j-1] 代表的是上一轮 j-1 循环中更新计算后的新值 dp[j-1]
                if (ch1[i-1]==ch2[j-1]) {
                    dp[j] = upperLeft;
                } else {
                    dp[j] = Math.min(upperLeft + 2 , Math.min(dp[j] , dp[j-1]) + 1);
                }

                // 当前 dp[j] 旧值作为下一轮 dp[j+1] 的左上方 upperLeft
                upperLeft = temp;
            }
        }
        return dp[m];
    }
}
