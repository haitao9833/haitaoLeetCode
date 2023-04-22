package leetcode.LC_DP;

import java.util.Arrays;

public class Solution_494 {

    public static void main(String[] args) {
        int[] nums = new int[]{2 , 2 , 2};
        int target = 2;
        // W = sum(nums + target) / 2
        findTargetSumWays1(nums , target);
        System.out.println();
        findTargetSumWays2(nums , target);
    }

    /**
     * 二维算法<p>
     * 预先判断一：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;若 nums[] 全体元素的和 sum < |target|<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;那么就算 target 为正时，且 nums[] 全部元素前面添加 "+" 也无法构造该表达式<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;那么就算 target 为负时，且 nums[] 全部元素前面添加 "-" 也无法构造该表达式<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;直接返回 0
     * <hr>
     * 预先判断一：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;令前面填 + 号的 nums[i] 元素分为一组令其和为 one<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;令前面填 - 号的 nums[i] 元素分为一组令其和为 two<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可列方程组：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;one + two = sum<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;one - two = target<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解方程有 one = (sum + target) / 2<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果不能整除，则说明无法将 nums[] 构造成 == target 的表达式<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;也直接返回 0
     * <hr>
     * nums[] 为物品列表，且有 nums[i] == weight[i] == values[i]<p>
     * 求把容量为 one 的背包装满有多少种组合方式
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        // 预先判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || ((sum + target) & 1) == 1) {
            return 0;
        }

        // 计算 W = one
        int one = (sum + target) / 2;
        int[][] dp = new int[nums.length][one + 1];

        // 初始化，好好看笔记！！！
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= one) {
                dp[0][nums[0]] = 1;
            }
        }


        for (int i = 1 ; i < nums.length ; i++){
            for (int j = 0 ; j <= one ; j++){
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        for (var arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[nums.length - 1][one];
    }

    /**
     * 一维算法
     */
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || ((sum + target) & 1) == 1) {
            return 0;
        }

        int one = (sum + target) / 2;
        int[] dp = new int[one + 1];

        // 初始化
        dp[0] = 1;


        for (int i = 0 ; i < nums.length ; i++){
            for (int j = one ; j >= nums[i] ; j--){
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[one];
    }
}
