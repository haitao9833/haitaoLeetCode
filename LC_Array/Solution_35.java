package leetcode.LC_Array;

public class Solution_35 {

    /**
     * 二分法模板二
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}