package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

    /**
     * @see Solution_15
     */
    public int[] twoSum(int[] nums, int target) {
        // {nums[i] , i}
        Map<Integer , Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]) , i};
            }
            map.put(nums[i] , i);
        }
        return new int[0];
    }
}
