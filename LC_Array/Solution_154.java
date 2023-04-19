package leetcode.LC_Array;

public class Solution_154 {

    /**
     * 详见官方图解
     * @see Solution_153
     */
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] == nums[r]) {
                // 比 153 多了此 if 两行
                // 无法判断、无法排除哪一边，只能 r-- 进一步缩小有效区间
                r--;
            } else {
                l = mid +1;
            }
        }
        return nums[l];
    }
}
