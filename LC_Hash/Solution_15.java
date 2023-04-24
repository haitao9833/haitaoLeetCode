package leetcode.LC_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {

    /**
     * 预先排序：方便找组合 、去重 、剪枝优化 <P>
     * 固定 nums[i] 用双指针 l 、r 在 nums[i+1 , n-1] 中找 nums[i] + nums[l] + nums[r] == 0
     * @see leetcode.LC_Back.Note
     * @see Solution_16
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // 预排序，找组合常用手段
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            // 剪枝优化
            if (0 < nums[i]) {
                return res;
            }
            // 去重 i
            if (0 < i && nums[i - 1] == nums[i]) {
                continue;
            }

            // [l , r] == [i+1 , n-1]
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (0 < sum) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i] , nums[l] , nums[r]));

                    // 去重 l
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;

                    // 去重 r
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
