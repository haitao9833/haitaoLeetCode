package leetcode.LC_Greedy;

public class Solution_376 {

    /**
     * 动态规划
     * <p> 含义：
     * <p>   up == 在 nums[0 ~ i-1] 范围内最后两个元素差值 > 0 的最长摆动子序列的长度
     * <p> down == 在 nums[0 ~ i-1] 范围内最后两个元素差值 < 0 的最长摆动子序列的长度
     * <p> 状态转移：
     * <p>      【划分：nums[i] - nums[i-1] > 0 还是 < 0】
     * <p>        up == down + 1   当 nums[i] - nums[i-1] > 0
     * <p>      down ==   up + 1   当 nums[i] - nums[i-1] < 0
     * <p> 遍历顺序：i 正序遍历 [1 -> n-1]
     * <p> 初始化：题意表明一个元素也算作摆动子序列
     * <p>     up == 1
     * <p>   down == 1
     */
    public int wiggleMaxLength(int[] nums) {
        // preliminary
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        // 初始化
        int up = 1;
        int down = 1;

        for (int i = 1 ; i < n ; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                up = down + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                down = up + 1;
            }
        }
        return Math.max(up , down);
    }
}