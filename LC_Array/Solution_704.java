package leetcode.LC_Array;

public class Solution_704 {

    /**
     * 模板一
     */
    public int search1(int[] nums, int target) {

        int n = nums.length;
        if (target < nums[0] || nums[n - 1] < target) {
            return -1;
        }

        // 初始化
        int l = 0;
        int r = n - 1;

        // 最后在 l == r 时还得判断是否有 nums[l] == nums[r] == target
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

    /**
     * 模板二
     */
    public int search2(int[] nums, int target) {

        int n = nums.length;
        if (target < nums[0] || nums[n - 1] < target) {
            return -1;
        }

        // 初始化
        int l = 0;
        int r = n;

        // 因为必然找得到 ==> 当 l == r 时，即夹逼出了该位置，直接退出循环即可
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 特判
        if (l != n && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    /**
     * 模板三
     */
    public int search3(int[] nums, int target) {

        int n = nums.length;
        if (target < nums[0] || nums[n - 1] < target) {
            return -1;
        }

        // 初始化
        int l = -1;
        int r = n - 1;

        // 因为必然找得到 ==> 当 l == r 时，即夹逼出了该位置，直接退出循环即可
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 特判
        if (l != -1 && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}