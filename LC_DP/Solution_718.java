package leetcode.LC_DP;

public class Solution_718 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i][j] 表示以 nums1[] 第 i 个元素和 nums2[] 第 j 个元素结尾的最长公共连续子数组的长度
     *      注意 i 和 j 非下标，虽然对于数组来说，前 0 个元素不像字符串的前 0 个字符（空字符串）有意义
     *      但这样多申请一行一列，实现起来更加方便，避免边界值处理的烦琐性
     * 状态转移：
     *      【划分一：看 nums1[i-1] 和 nums2[j-1] 是否相同】
     *      dp[i][j] = dp[i-1][j-1] + 1        在 nums1[i-1] == nums2[j-1] 的情况下
     *      dp[i][j] = 0                       在 nums1[i-1] != nums2[j-1] 的情况下
     *      【项分析：dp[i-1][j-1] 左上角】
     *      【第一行 i=0 和第一列 j=0 没有左上角，固 i 和 j 需要从 1 开始遍历】
     * 遍历顺序：
     *      【需要保证左上角的更新计算】
     *      【第一维度 i 必须正序遍历 [1 -> len(nums1)]】
     *      【第二维度 j 必须正序遍历 [1 -> len(nums2)]】
     *      策略一二：先 i 后 j ，或者先 j 后 i ，都可以
     * 初始化：
     *      【第一行 i=0 和第一列 j=0 没有左上角，需要手动初始化】
     *      dp[i][0] = 0   数组的前 0 个元素没有意义，公共长度肯定为 0 ，使用 dp[][] 数组默认值即可
     *      dp[0][j] = 0   数组的前 0 个元素没有意义，公共长度肯定为 0 ，使用 dp[][] 数组默认值即可
     */
    public int findLength1(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int res = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res , dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 二维化一维，空间优化
     * 先分析上述原始二维算法：
     *      左上方 dp[i-1][j-1] == 正左方 dp[j-1] 旧值
     *      即 j 需要逆序遍历
     * 状态转移：
     *      dp[j] = dp[j-1] + 1        在 nums1[i-1] == nums2[j-1] 的情况下
     *      dp[j] = 0                  在 nums1[i-1] != nums2[j-1] 的情况下
     * 遍历顺序：
     *      唯一策略：先正序遍历 i [1 -> len(nums1)] ，再逆序遍历 j [len(nums2) -> 1]
     * 初始化：
     *      【保持和上述二维算法一模一样】
     *      dp[0] = 0
     */
    public int findLength2(int[] nums1, int[] nums2) {
        // preliminary
        int n = nums1.length;
        int m = nums2.length;

        // 初始化
        int[] dp = new int[m + 1];


        int res = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = m ; j >= 1 ; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    // 二维化一维度的细节之处
                    // 在 nums1[i-1] != nums2[j-1] 的情况下必须手动赋值 0
                    // 避免滚动数组直接遗传的无效旧值的影响
                    dp[j] = 0;
                }
                res = Math.max(res , dp[j]);
            }
        }
        return res;
    }
}
