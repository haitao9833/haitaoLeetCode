package leetcode.LC_DP;

public class Solution_198 {

    /**
     * dp 动态规划
     * 含义：dp[i] 偷至下标为 i 的房间时能偷到的最大金额总数
     * 状态转移：
     *      【划分：偷下标 i 的房间还是不偷下标 i 的房间】
     *      dp[i] = max(dp[i-2] + nums[i] , dp[i-1])
     *      【项分析：dp[i-1] 和 dp[i-2] 都为正左方，即 i 必须从 2 开始正序遍历，且配合初始化 dp[0] 和 dp[1]】
     * 遍历顺序：【同上 ，i 正序遍历 [2 -> len(nums)-1]】
     * 初始化：
     *      dp[0] = nums[0]
     *      dp[1] = max(nums[0] , nums[1])
     * 下述直接使用一维化常量：
     *      dp[i-2] == downdown
     *      dp[i-1] == down
     * @see Solution_213
     */
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0] , nums[1]);
        }

        // 初始化 dp[0] 和 dp[1]
        int downdown = nums[0];
        int down = Math.max(nums[0] , nums[1]);
        int res = 0;

        for (int i = 2 ; i < n ; i++) {
            res = Math.max(downdown + nums[i] , down);
            downdown = down;
            down = res;
        }
        return res;
    }
}