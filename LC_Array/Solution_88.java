package leetcode.LC_Array;

public class Solution_88 {

    /**
     * 逆向思维： <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;从后向前合并，即逆序、从大到小填充 nums1[] <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因为若从前向后合并，则还需额外的后移操作
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // idx 为待填充的下标处
        int idx = m + n - 1;

        // 用 m 作为指针逆序遍历 nums1
        // 用 n 作为指针逆序遍历 nums2
        m--;
        n--;

        // 遍历完 nums2 才算结束
        while (0 <= n) {
            // 注意判断 0 <= m
            // 若 nums1 前 m 个遍历完了，只能遍历 nums2 了
            if (0 <= m && nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];
            } else {
                nums1[idx--] = nums2[n--];
            }
        }
    }
}
