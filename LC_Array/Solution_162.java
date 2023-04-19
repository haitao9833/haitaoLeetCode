package leetcode.LC_Array;

/**
 * 要求时间复杂度为 O(log(n)) 则二分
 */

public class Solution_162 {

    /**
     * <strong>突破模板</strong><p>
     * 数组 nums[] 的所有可能性起伏：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-∞ 升序 -∞<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-∞ 降序 -∞<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-∞ 多峰 -∞<p>
     * 要理解：对于相邻元素 nums[i] 和 nums[i+1] 向更高的元素走一定可以走到一个峰
     */
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // 初始化覆盖所有可能：[0 , n-1] 内一定有峰
        int l = 0;
        int r = n - 1;

        // 一定存在
        while (l < r) {
            // 其实也不是什么模板不模板
            // 搞清楚逻辑 ==> 确定 l & r 的变化 ==> 选择 mid 的计算方式 ==> 不要陷入循环即可
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid + 1]) {
                // l 向更高的元素 nums[mid + 1] 收缩
                l = mid + 1;
            } else {
                // r 向更高的元素 nums[mid] 收缩
                r = mid;
            }
        }
        return l;
    }
}
