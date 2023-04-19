package leetcode.LC_Array;

public class Solution_34 {

    /**
     * 二分法的模板二、模板三
     */
    public int[] searchRange(int[] nums , int target) {

        if(nums.length == 0) {
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int[] res = new int[]{-1 , -1};

        // 二分法模板二
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 特判
        if (l == n || nums[l] != target) {
            return new int[]{-1 , -1};
        }
        res[0] = l;

        // 二分法模板三
        // l 初始化为 0
        // 因为运行到这里，说明上面已经找到了开始位置下标
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 最后也不需要特判了
        // 因为上述已确定 nums[] 中必然有 target 了
        res[1] = l;

        return res;
    }
}
