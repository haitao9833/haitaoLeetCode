package leetcode.LC_DP;

public class Solution_72 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示将 word1 的前 i 个字符转化为 word2 的前 j 个字符，所需要的最少操作次数
     *      注意 i 和 j 表示前几个字符，而非下标
     *      因为前 0 个字符（空字符）也是可以转换而成的，是有意义的
     * 状态转移：
     *      【划分一：看 word1 的第 i 个字符（word1[i-1]）和 word2 的第 j 个字符（word2[j-1]）是否相同】
     *      【划分二：不同的情况下，是增、删还是改，取三者中操作数最小的情况】
     *      dp[i][j] = dp[i-1][j-1]         在 word1[i-1] == word2[j-1] 的情况下
     *      dp[i][j] = dp[i][j-1] + 1       在 word1[i-1] != word2[j-1] 的情况下，增
     *      dp[i][j] = dp[i-1][j] + 1       在 word1[i-1] != word2[j-1] 的情况下，删
     *      dp[i][j] = dp[i-1][j-1] + 1     在 word1[i-1] != word2[j-1] 的情况下，改
     *      【项分析一：dp[i-1][j-1]  左上方，不管是 word1[i-1] 和 word2[j-1] 是 == 还是 != 都需要依赖之】
     *      【项分析二：dp[i][j-1]    正左方，仅在 word1[i-1] != word2[j-1] 时依赖之】
     *      【项分析三：dp[i-1][j]    正上方，仅在 word1[i-1] != word2[j-1] 时依赖之】
     * 遍历顺序：
     *      【核心是要保证项分析的左上方、正左方和正上方都已经计算更新过了】
     *      【第一维度 i 必须正序遍历，且 i=0 时第一行无左上方，需要手动初始化，即 i 必须从 1 开始正序遍历 [1 -> len(word1)]】
     *      【第二维度 j 必须正序遍历，且 j=0 时第一列无左上方，需要手动初始化，即 j 必须从 1 开始正序遍历 [1 -> len(word2)]】
     *      策略一：先正序遍历 i 再正序遍历 j
     *      策略二：先正序遍历 j 再正序遍历 i ，都可以
     * 初始化：
     *      【整个 dp[][] 中无法通过状态转移方程自动更新计算的部分都需要手动初始化】
     *      【综合上述分析，即 i=0 的情况和 j=0 的情况】
     *      dp[0][j] = j   即 word1 从空字符串增加 j 个字符以转换成 word2 的前 j 个字符
     *      dp[i][0] = i   即 word1 删除前 i 个字符以转换成空字符串 word2
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
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j] , dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 二维化一维，空间优化：
     *      由原始二维的项分析可知：
     *          dp[i-1][j-1]  左上方 == dp[j-1] 旧值，必然要用 upLeft 记录
     *          dp[i][j-1]    正左方 == dp[j-1] 新值，说明 j 必然要正序遍历
     *          dp[i-1][j]    正上方 == dp[j] 自身旧值
     *      状态转移方程：
     *          dp[j] = upperLeft                                  在 word1[i-1] == word2[j-1] 的情况下
     *          dp[j] = max(upperLeft , dp[j-1] , dp[j]) + 1       在 word1[i-1] != word2[j-1] 的情况下
     *      遍历顺序：
     *          【第一维度 i 正序遍历 [1 -> len(word1)] + 同上述二维手动初始化 i=0 的第一行】
     *          【第二维度 j 正序遍历 [1 -> len(word2)] + 同上述二维，在循环内部每次循环 j=1 之前，初始化 dp[0] = i】
     *          策略一、二：先 i 后 j 或者先 j 后 i 都行
     *                    不过先 i 后 j 写起来更顺
     *      初始化：
     *          【见上述遍历顺序分析，本质即要保持和原始二维的初始化一模一样】
     */
    public int minDistance2(String word1, String word2) {
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
            // 求滚动数组直接遗传的 dp[0] 对于 dp[1] 来说即为左上方 upperLeft
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
                    dp[j] = Math.min(upperLeft , Math.min(dp[j] , dp[j-1])) + 1;
                }

                // 当前 dp[j] 旧值作为下一轮 dp[j+1] 的左上方 upperLeft
                upperLeft = temp;
            }
        }
        return dp[m];
    }
}