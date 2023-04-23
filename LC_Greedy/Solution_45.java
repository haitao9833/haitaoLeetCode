package leetcode.LC_Greedy;

/**
 * 跳跃游戏Ⅰ 55：能否跳到最后一个位置
 * 跳跃游戏Ⅱ 45：使用最少的跳跃次数跳到最后一个位置
 */
public class Solution_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        int curFarIndex = 0;
        int nextFarIndex = 0;
        for (int i = 0 ; i < n - 1 ; i++) {  // i 到 n-2 即可，因为题目给定总是可以跳到数组的最后一位
            nextFarIndex = Math.max(nextFarIndex , i + nums[i]);
            if (i == curFarIndex) {
                res++;
                curFarIndex = nextFarIndex;
            }
        }
        return res;
    }
}
