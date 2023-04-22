package leetcode.LC_DP;

public class Solution_413 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示以 nums[i] 为结尾的等差数列的个数
     * 状态转移：
     *      【划分：nums[i] 是否可以接在以 nums[i-1] 为结尾的等差数列之后】
     *      【即可维护一个 diff 来判断是否有 nums[i-1] - nums[i-2] == nums[i] - nums[i-1]】
     *      dp[i] = dp[i-1] + 1          在 nums[i-1] - nums[i-2] == nums[i] - nums[i-1] 的情况下
     *                                   则以 nums[i-1] 为结尾的等差数列都可以在尾部接上 nums[i] 依旧为等差数列
     *                                   且比以 nums[i-1] 为结尾的等差数列多了一个 {nums[i-2] , nums[i-1] , nums[i]}
     *      dp[i] = 0                    在 nums[i-1] - nums[i-2] != nums[i] - nums[i-1] 的情况下
     * 遍历顺序：
     *      【综上可知 ，i 基于 i-1 ，则 i 必须正序遍历，且至少要从 1 开始】
     *      【且又有等差数列至少要有 3 个元素，则 i 可以从 2 开始正序遍历 [2 -> len(nums)-1]】
     *      【切配合初始化 i=0 , i=1 的情况】
     * 初始化：
     *      dp[0] = 0   不足以形成等差数列
     *      dp[1] = 0   不足以形成等差数列
     */
    public int numberOfArithmeticSlices1(int[] nums) {

        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // 维护一个 diff
        int res = 0;
        int[] dp = new int[n];
        int diff = nums[1] - nums[0];

        for (int i = 2 ; i < n ; i++) {
            if (diff == nums[i] - nums[i - 1]) {
                // diff 连续，即 nums[i] 可以接在以 nums[i-1] 为结尾的等差数列之后
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            } else {
                // diff 不连续，则需要更新 diff
                diff = nums[i] - nums[i - 1];
                dp[i] = 0;
            }
        }
        return res;
    }

    /**
     * 一维化常量，空间优化：
     * 分析上述二维算法的项可知：
     *      dp[i] 仅基于左值 dp[i-1]
     *      则可以使用一个变量 dp 记录左值 dp[i-1] 即可
     *      且在 diff 不连续的时候，必须更新 dp = 0 ，以避免滚动遗传值的影响
     *      初始化和遍历顺序则确保和上述二维算法一模一样即可
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        // preliminary
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // 初始化 dp[i-1]
        int dp = 0;
        int res = 0;
        int diff = nums[1] - nums[0];

        for (int i = 2 ; i < n ; i++) {
            if (diff == nums[i] - nums[i - 1]) {
                dp = dp + 1;
                res += dp;
            } else {
                // 必须手动更新 dp = 0 ，上述二维算法则可以直接使用 dp[] 数组的默认值 0
                diff = nums[i] - nums[i - 1];
                dp = 0;
            }
        }
        return res;
    }
}
