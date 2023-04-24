package leetcode.LC_Hash;

import java.util.Arrays;

public class Solution_16 {

    /**
     * 类似 15 ，仅剪枝优化不同
     * @see Solution_18
     */
    public int threeSumClosest(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0 ; i < n ; i++) {
            // 去重 i
            if (0 < i && nums[i - 1] == nums[i]) {
                continue;
            }

            // [l , r] == [i+1 , n-1]
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                // 剪枝优化，target < 固定 i 移动 l 、r 所能达到的最小
                int min = nums[i] + nums[l] + nums[l + 1];
                if (target < min) {
                    if (Math.abs(target - res) > Math.abs(target - min)) {
                        res = min;
                    }
                    if (res == target) {
                        return target;
                    }
                    break;
                }

                // 剪枝优化，target > 固定 i 移动 l 、r 所能达到的最大
                int max = nums[i] + nums[r - 1] + nums[r];
                if (target > max) {
                    if (Math.abs(target - res) > Math.abs(target - max)) {
                        res = max;
                    }
                    if (res == target) {
                        return target;
                    }
                    break;
                }

                // 固定 i 移动 l 、r 遍历所有可能
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (res == target) {
                    return target;
                }
                if (target < sum) {
                    // 去重 r
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;
                }
                else if (sum < target) {
                    // 去重 l
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
            }
        }
        return res;
    }
}
