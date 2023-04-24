package leetcode.LC_Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_349 {

    /**
     * Set
     * @see Solution_350
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        // 确保 nums1[] 为较短的数组
        if (nums1.length > nums2.length) {
            return intersection(nums2 , nums1);
        }

        // 对较短的 nums1[] 建立 Set 优化空间
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // 判断 nums2[] 的元素是否在 nums1[] 的 Set 中
        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * <strong>若 nums1[] 和 nums2[] 有序</strong> ==> 双指针
     */
    public int[] intersection2(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;

        // i 遍历 nums1[]
        // j 遍历 nums2[]
        int i = 0;
        int j = 0;

        // idx 为 res[] 的待填充下标
        int idx = 0;
        int[] res = new int[Math.min(n , m)];

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                // 去重
                if (idx == 0 || nums1[i] != res[idx - 1]) {
                    res[idx++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // 最后没有遍历完的那个指针后面也不会有交集元素了

        return Arrays.copyOfRange(res , 0 , idx);
    }
}