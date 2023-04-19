package leetcode.LC_Array;

public class Solution_80 {

    /**
     * 有效尾元素 nums[idx - 2] 、nums[idx - 1]<p>
     * 可以扩展为至多保留 k 个重复的通解，见宫水三叶
     * @see Solution_283
     */
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (var num : nums) {
            if (idx == 0 || idx == 1 || nums[idx - 2] != num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
