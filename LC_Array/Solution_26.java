package leetcode.LC_Array;

public class Solution_26 {

    /**
     * 有效尾元素 nums[idx - 1]
     * @see Solution_27
     */
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (var num : nums) {
            if (idx == 0 || nums[idx - 1] != num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
