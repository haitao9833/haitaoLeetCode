package leetcode.LC_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_350 {

    /**
     * 将 349 的 Set 改为 Map {num , cnt}
     * @see Solution_349
     */
    public int[] intersect(int[] nums1 , int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2 , nums1);
        }

        // 对较短的 nums1[] 建立 Map 优化空间
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        // idx 为 res[] 的待填充下标
        int idx = 0;
        int[] res = new int[nums1.length];

        for (int num : nums2) {
            int cnt = map.getOrDefault(num , 0);
            if (cnt != 0) {
                res[idx++] = num;
                map.put(num , --cnt);
            }
        }

        return Arrays.copyOfRange(res , 0 , idx);
    }

    /**
     * 仅比 349 少了一行去重
     */
    public int[] intersect2(int[] nums1 , int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;

        int idx = 0;
        int[] res = new int[Math.min(n , m)];

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                // 仅比 349 少了一行去重
                res[idx++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res , 0 , idx);
    }
}