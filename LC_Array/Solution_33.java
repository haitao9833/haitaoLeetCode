package leetcode.LC_Array;

public class Solution_33 {

    /**
     * nums[] == [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]<p>
     *            ----------------------------------  ================================
     * @see Solution_81
     */
    public int search1(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);

            // 建议最优先判断
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                // 判断 target 是否在有序区 nums[l , mid) （因为 mid 在第一个 if 已经判断过了，所以是开区间）
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 判断 target 是否在有序区 nums(mid , r] （因为 mid 在第一个 if 已经判断过了，所以是开区间）
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 通过第一元素 nums[k] 找旋转点 nums[n-1] <p>
     * 再决定选择两个有序子区间之一进行二分查找模板一
     */
    public int search2(int[] nums, int target) {

        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // 二分法模板三，找最后一个 >= nums[k] 的元素 nums[n-1]
        // 循环结束后 nums[l] == nums[r] == nums[n-1]
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= nums[0]) {
                // l 向 mid 收缩
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        if (nums[0] <= target) {
            // 选左边的 [nums[k] , nums[k+1] , ... , nums[n-1]]
            l = 0;
        } else {
            // 选右边的 [nums[0] , nums[1] , ... , nums[k-1]]
            l = l + 1;
            r = n - 1;
        }

        // 二分法模板一
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}