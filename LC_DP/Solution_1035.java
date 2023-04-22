package leetcode.LC_DP;

public class Solution_1035 {

    /**
     * 本质和 1143 一模一样，求公共的、最长的、子序列的长度，只是将两个 String 换成了两个 nums[]
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 直接 copy 1143 的代码，将 text 换成了 nums[]
        int n = nums1.length;
        int m = nums2.length;
        int[] dp = new int[m + 1];

        for (int i = 1 ; i <= n ; i++) {
            int upperLeft = dp[0];
            for (int j = 1; j <= m ; j++) {
                int temp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
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
