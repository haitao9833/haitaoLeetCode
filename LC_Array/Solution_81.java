package leetcode.LC_Array;

public class Solution_81 {

    /**
     * @see Solution_33
     */
    public boolean search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);

            // 建议最优先判断
            if (nums[mid] == target) {
                return true;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                    // 比 33 多了此 if 三行
                    // 无法判断、无法排除哪一边，只能 l++ & r-- 进一步缩小有效区间
                    l++;
                    r--;
                } else if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
