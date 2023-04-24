package leetcode.LC_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {

    /**
     * 同 15 ，固定 nums[i] 和 nums[j]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 去重 i
            if (0 < i && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 去重 j
                if (i + 1 < j && nums[j - 1] == nums[j]) {
                    continue;
                }

                // [l , r] == [j+1 , n-1]
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (target < sum) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

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
        }
        return res;
    }
}
