package leetcode.LC_Greedy;

/**
 * 跳跃游戏Ⅰ 55：能否跳到最后一个位置
 * 跳跃游戏Ⅱ 45：使用最少的跳跃次数跳到最后一个位置
 */
public class Solution_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int coverIndex = 0;
        for (int i = 0 ; i <= coverIndex ; i++) { // 注意细节 0 <= i <= cover
            coverIndex = Math.max(coverIndex , i + nums[i]);
            if (coverIndex >= nums.length - 1) return true;
        }
        return false;
    }
}
