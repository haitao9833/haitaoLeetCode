package leetcode.LC_Array;

public class Solution_581 {

    /**
     * 图解：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * [l , r] 中的最小值 min 决定左边界 l ，即向左的最后一个 > min 的数即为左边界 nums[l]<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * [l , r] 中的最大值 max 决定右边界 r ，即向右的最后一个 < max 的数即为右边界 nums[r]<p>
     * 左有序 < [l , r] < 右有序<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * max(左有序) <= min([l , r])   且 [l , r] 的最小值 min 必然不在左边界 l 处<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * max([l , r]) <= min(右有序)   且 [l , r] 的最大值 max 必然不在右边界 r 处
     */
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        // 初始化见下述 return 返回值
        int l = 0;
        int r = -1;

        // 维护一个 min 向左寻找最后一个 > min 的数 nums[l]
        // 维护一个 max 向右寻找最后一个 < max 的数 nums[r]
        int min = nums[n - 1];
        int max = nums[0];

        for (int i = 1 ; i < n ; i++) {

            // 向左遍历 ==>
            if (max <= nums[i]) {
                // 更新 max
                max = nums[i];
            } else {
                // 或者更新 r
                r = i;
            }

            // 向右遍历 <==
            if (min >= nums[n - 1 - i]) {
                // 更新 min
                min = nums[n - 1 - i];
            } else {
                // 或者更新 l
                l = n - 1 - i;
            }
        }

        // 若整个 nums[] 本来就有序
        // 则此处应该返回 0 所以可以理解上述 l & r 的初始化
        return r - l + 1;
    }
}
