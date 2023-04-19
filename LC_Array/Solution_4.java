package leetcode.LC_Array;

/**
 * 题目要求时间复杂度为 O(log(m+n))，只有二分法能达到 log 级别
 */

public class Solution_4 {

    /**
     * O(log(m+n)) 算法：将求中位数转换为求第 k 小的数
     * getKth(k , nums1[] , l1 , r1 , nums2[] , l2 , r2) == 在 nums1[l1 , r1] 和 nums2[l2 , r2] 中找第 k 小的元素
     *      每次在两个数组中从头开始各选 k/2 个数（向下取整）
     *          A[l1] 、A[l1+1] 、... 、A[l1+k/2-1]
     *          B[l2] 、B[l2+1] 、... 、B[l2+k/2-1]
     *      不失一般性，若 A[l1+k/2-1] <= B[l2+k/2-1] ，则 A[l1]...A[l1+k/2-1] 都可以排除了，不可能是第 k 小的数
     *      则继续在 A[l1+k/2 , r1] 和 B[l2 , r2] 中找第 k - k/2 小的数，每次排除掉 k/2 个数，即为二分法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // preliminary
        int m = nums1.length;
        int n = nums2.length;

        // 第几小的编号为 [1 , m+n] 区间
        // 中间偏左 == (1 + m + n) / 2
        // 中间偏右 == (2 + m + n) / 2
        int midL = getKth((1 + m + n) / 2 , nums1 , 0 , m - 1 , nums2 , 0 , n - 1);
        int midR = getKth((2 + m + n) / 2 , nums1 , 0 , m - 1 , nums2 , 0 , n - 1);
        return (midL + midR) / 2.0;
    }
    private int getKth(int k , int[] nums1 , int l1 , int r1 , int[] nums2 , int l2 , int r2) {
        // 递归边界一，nums1[l1 , r1] 空或 nums2[l2 , r2] 空
        // 则可直接在另一个非空有序数组中计算下标 O(1) 取第 k 小的元素
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if (len1 == 0) {
            return nums2[l2 + k - 1];
        }
        if (len2 == 0) {
            return nums1[l1 + k - 1];
        }

        // 递归边界二，取第 1 小的元素，返回 min(nums1[l1] , nums2[l2]) 即可
        if (k == 1) {
            return Math.min(nums1[l1] , nums2[l2]);
        }

        // 在 nums1[l1 , r1] 和 nums2[l2 , r2] 中各取第 k/2 个元素，注意不要越界各自的 len
        int i = l1 + Math.min(len1 , k/2) - 1;
        int j = l2 + Math.min(len2 , k/2) - 1;
        if (nums1[i] <= nums2[j]) {
            // 排除掉 nums1[l1 , i]
            return getKth(k - (i - l1 + 1) , nums1 , i + 1 , r1 , nums2 , l2 , r2);
        } else {
            // 排除掉 nums2[l2 , j]
            return getKth(k - (j - l2 + 1) , nums1 , l1 , r1 , nums2 , j + 1 , r2);
        }
    }

    /**
     * O(log(min(m,n))) 算法：见题解
     * 重点是找到一条分割线满足分割线左边所有元素 <= 分割线右边所有元素：
     *      1、nums1[分割线左边] <= nums2[分割线右边] && nums1[分割线右边] >= nums2[分割线左边]
     *      2、全部元素数量为偶数时，分割线左边元素个数 == 分割线右边元素个数
     *      3、全部元素数量为奇数时，分割线左边元素个数比右边多一个
     *      4、记分割线左边元素个数为 leftCnt
     * 可证：在 nums1[] 中二分找最后一个 nums1[i] <= nums2[leftCnt - (i+1)] 为一条有效的分割线位置
     *      规定 nums1[i] 为分割线左边第一个元素，nums2[leftCnt - (i+1)] 为分割线右边第一个元素
     *      因为是最后一个，所以若 nums1[i+1] 存在，则 nums1[i+1] > nums2[leftCnt - (i+1) - 1] 满足分割线条件
     *      若 nums1[i+1] 不存在，即全部 nums1[] <= nums2[] ，也满足分割线左边所有元素 <= 分割线右边所有元素
     * 二分：有可能全部 nums1[] > nums2[] 则 nums1[i] 应为 nums[-1]
     *      则 i 的取值范围应该为 [l , r] == [-1 , m-1] 当夹逼到 l 初始值 -1 时会退出循环，无需担心数组下标越界
     *      但对于满足条件 nums1[i] <= nums2[leftCnt - (i+1)] 需满足 0 <= leftCnt-(i+1) < n
     *      即 i+1 <= leftCnt 即 m <= leftCnt 所以 m 应取较短的数组
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 预处理，确保 nums1 为较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2 , nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边应有的元素个数，偶数时平分，奇数时比右边多一个
        int leftCnt = (m + n + 1) / 2;

        // 二分法模板三，找最后一个 nums1[i] <= nums2[leftCnt - (i+1)] 的元素 nums[i] 及其下标 i
        int l = -1;
        int r = m - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums1[mid] <= nums2[leftCnt - (mid + 1)]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // nums1[i] 为分割线左边第一个元素
        // nums2[j] 为分割线右边第一个元素
        int i = l;
        int j = leftCnt - (i + 1);

        // 特殊的分割情况，分割线的某一边没有元素
        int nums1LeftMax = (i == -1) ? Integer.MIN_VALUE : nums1[i];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int nums1RightMin = (i == m - 1) ? Integer.MAX_VALUE : nums1[i + 1];
        int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax , nums2LeftMax);
        } else {
            return (Math.max(nums1LeftMax , nums2LeftMax) + Math.min(nums1RightMin , nums2RightMin)) / 2.0;
        }
    }
}
