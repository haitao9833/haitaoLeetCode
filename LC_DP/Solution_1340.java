package leetcode.LC_DP;

/**
 * 为什么需要记忆化同 337 ，避免重复的递归计算，即此 dp[] == 337 的 memo
 */

public class Solution_1340 {


    /**
     * 共享信息
     * dp[] 先不预先填充 1 ，用默认值 0 表示还未计算更新过和非 0 值表示已经计算更新过
     */
    int d;
    int n;
    int[] dp;
    int[] arr;

    /**
     * 递归型动态规划 + 记忆化
     *      dp[i] == getDP(i) == 从下标 i 开始跳跃，最多可以访问的下标数（柱子数），至少是 1 自己
     *          1、向左遍历 [i-d , i-1] 且确保 arr[j~i-1] < arr[i]
     *          2、向右遍历 [i+1 , i+d] 且确保 arr[i+1~j] < arr[i]
     *          3、取遍历过程中的最大值并 +1
     */
    private int getDP(int i) {
        // 递归边界为当 nums[i-1] >= nums[i] <= nums[i+1] 时，dp[i] = 1

        // 记忆化
        if (dp[i] != 0) {
            return dp[i];
        }

        // 跳跃的左边界 l 和右边界 r
        int maxStep = 0;
        int l = Math.max(i - d , 0);
        int r = Math.min(i + d , n - 1);

        // 向左跳 [i-1 -> l] 找 max(dp[j])
        for (int j = i - 1 ; j >= l ; j--) {
            if (arr[j] >= arr[i]) {
                break;
            }
            maxStep = Math.max(maxStep , getDP(j));
        }

        // 向右跳 [i+1 -> r] 找 max(dp[j])
        for (int j = i + 1 ; j <= r ; j++) {
            if (arr[i] <= arr[j]) {
                break;
            }
            maxStep = Math.max(maxStep , getDP(j));
        }

        // 更新计算过后记忆化
        return dp[i] = maxStep + 1;
    }
    public int maxJumps(int[] arr , int d) {
        // preliminary
        this.d = d;
        this.n = arr.length;
        this.arr = arr;
        this.dp = new int[n];

        // 比较、记录每个 dp[i] 中的最大值
        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            res = Math.max(res , getDP(i));
        }
        return res;
    }
}
