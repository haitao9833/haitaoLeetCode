package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.Map;

public class Solution_454 {

    /**
     * a + b + c + d == 0
     * <p> a + b == -(c + d)
     * @see Solution_1
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // {a + b , cnt}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j , map.getOrDefault(i + j , 0) + 1);
            }
        }

        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-(i + j), 0);
            }
        }
        return res;
    }
}
