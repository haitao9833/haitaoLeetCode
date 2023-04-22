package leetcode.LC_DP;

public class Solution_312 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示在下标 (i , j) 区间内戳气球能获得的最大收益
     *      注意 i 、j 表示下标，且下标 i 、j 处的气球不戳破、不计入收益
     *      即长度为 1 和长度为 2 的区间无气球可戳破，收益为 0
     *      首先需要扩展 nums[] 数组，首尾各插入一个 1 ，方便处理边界，即 newNums[] 的长度为 n+2
     * 状态转移：
     *      【划分：需要比较所有的对 (i , j) 区间的戳爆方案，并取其中的最大值】
     *      【在所有的对 (i , j) 区间的戳爆方案，总有一个最后戳爆的气球】
     *      【则用 k 遍历所有可能的最后一个戳爆的气球 [i+1 , j-1] 即遍历了所有可能的戳爆方案，此分析过程同 132】
     *
     *      dp[i][j] = max(dp[i][k] + nums[i]*nums[k]*nums[j] + dp[k][j])  其中 k 需遍历 [i+1 ~ j-1]
     *
     *      【首先需保证 k 遍历有效区间 [i+1 , j-1] ，即 i+1 <= j-1 ，即 i+2 <= j ，即 j 至少要从 i+2 开始遍历】
     *               【本质即区间 (i , j) 长度至少为 3 的时候才有意义，才有气球可戳破，才有收益】
     *               【即确定了 i 外层，j 中层依赖于外层 i ，k 内层依赖于外层 i 和中层 j】
     *               【且 k 正序逆序遍历 [i+1 ~ j-1] 都可以】
     *      【项分析一：dp[i][j] 依赖于正下方 dp[i+1 ~ j-1][j] ，所以 i 必须逆序遍历】
     *               【且须保证 j=i+2 <= n+1 不越界，即 i 逆序遍历 [n-1 -> 0]】
     *               【且对于 i=n 和 i=n+1 的初始化，区间 (i , j) 长度无效，收益保持 dp[][] 数组默认值 0 即可】
     *      【项分析二：dp[i][j] 依赖于正左方 dp[i][i+1 ~ j-1] ，所以 j 必须正序遍历 [i+2 , n+1]】
     *               【且对于 j=[0 ~ i+1] 的初始化，区间 (i , j) 长度无效，收益保持 dp[][] 数组默认值 0 即可】
     * 遍历顺序：【综上】
     * 初始化：【综上】
     */
    public static int maxCoins2(int[] nums) {
        // preliminary ，填充 nums[] 的首尾 1
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums , 0 , newNums , 1 , n);

        // 初始化
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = i + 2 ; j <= n + 1 ; j++) {
                for (int k = i + 1 ; k <= j - 1 ; k++) {
                    int l = dp[i][k];
                    int r = dp[k][j];
                    dp[i][j] = Math.max(dp[i][j] , l + newNums[i] * newNums[k] * newNums[j] + r);
                }
            }
        }
        return dp[0][n + 1];
    }

    /**
     * 另一种写法
     * 分析上述二维算法的项：
     *     dp[i][j] 依赖于 dp[i+1 ~ j-1][j] 和 dp[i][i+1 ~ j-1]
     *     表示区间 (i , j) 依赖于长度更短的区间 (i+1 ~ j-1 , j) 和 (i , i+1 ~ j-1)
     *     则可以遍历区间长度 len 从 [3 -> n+2] 来更新计算 dp[i][j] ，注意 len=1 或 len=2 时无意义
     *     且可以有效保证 dp[i+1 ~ j-1][j] 和 dp[i][i+1 ~ j-1] 都已经计算更新过了
     */
    public static int maxCoins22(int[] nums) {
        // preliminary ，填充 nums[] 的首尾 1
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums , 0 , newNums , 1 , n);

        // 初始化
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 3 ; len <= n + 2 ; len++) {
            // 对 newNums[] 中每个长度为 len 的子数组都要计算更新
            for (int j = len - 1 ; j <= n + 1 ; j++) {
                int i = j - len + 1;
                for (int k = i + 1 ; k <= j - 1 ; k++) {
                    int l = dp[i][k];
                    int r = dp[k][j];
                    dp[i][j] = Math.max(dp[i][j] , l + newNums[i] * newNums[k] * newNums[j] + r);
                }
            }
        }
        return dp[0][n + 1];
    }
}