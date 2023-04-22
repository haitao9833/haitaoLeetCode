package leetcode.LC_DP;

public class Solution_674 {

    /**
     * 本质也是 dp 动态规划，也可以视为贪心 <P>
     * 即 len 的本质为以 nums[i] 为结尾的最长连续递增子数组的长度
     */
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 初始的 len 代表的是 nums[0] 的长度
        int res = 1;
        int len = 1;

        for (int i = 1 ; i < n ; i++) {
            if (nums[i - 1] < nums[i]) {
                // 即 nums[i] 接到 nums[i-1] 后面
                len++;
            } else {
                // 从 nums[i] 重新开始
                len = 1;
            }
            res = Math.max(res , len);
        }
        return res;
    }
}
