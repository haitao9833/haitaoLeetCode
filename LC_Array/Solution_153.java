package leetcode.LC_Array;


public class Solution_153 {

    /**
     * 详见官方图解
     * @see Solution_154
     */
    public int findMin(int[] nums) {

        // 最小值必然存在于 [0 , n-1]
        int l = 0;
        int r = nums.length - 1;

        // 最小值必然存在
        while (l < r) {
            int mid = l + ((r - l) >> 1);

            // 也可以使用 nums[n-1] ，但在含重复元素的 Solution_154 中只能使用 nums[r]，最好还是统一优先使用 nums[r]
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
