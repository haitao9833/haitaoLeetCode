package leetcode.LC_Array;

public class Solution_27 {

    /**
     * @see Solution_80
     */
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (var num : nums) {
            if (num != val) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
