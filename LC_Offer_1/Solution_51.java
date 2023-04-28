package leetcode.LC_Offer_1;

import java.util.Arrays;

public class Solution_51 {

    /**
     * res 即 315 中的 cnt[] 的总和 == <strong>逆序对个数</strong>  <P>
     * 比 315 少用了一个 idx[] 因为只需要统计所有的逆序对个数 res 即可，无需对应到某个数的逆序对为多少 <P>
     * 315 为<strong>逆序归并</strong>计算逆序对：+= r - j + 1 <P>
     * 此处为<strong>正序归并</strong>计算逆序对：+= mid - i + 1
     */
    int res;
    int[] aux;

    /**
     * 正序归并计算逆序对 <P>
     * <strong>本质即：放 [j] 的时候需要累加计算逆序对</strong>
     * @see leetcode.LC_Array.Solution_315
     */
    public int reversePairs(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        res = 0;
        aux = new int[n];

        sortAndMerge(nums , 0 , n - 1);

        return res;
    }
    private void sortAndMerge(int[] nums , int l , int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        sortAndMerge(nums , l , mid);
        sortAndMerge(nums , mid + 1 , r);

        int i = l;
        int j = mid + 1;

        // 同 912
        System.arraycopy(nums , l , aux , l , r - l + 1);

        for (int k = l ; k <= r ; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > r) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                // 同 912 的稳定性，相等的情况下优先选择前半部分 [i , mid] 中的
                nums[k] = aux[i++];
            } else {
                // 放 [j] 的时候计算逆序对，说明 [j] 可以对 [i , ... , mid] 区间内的元素贡献逆序对
                res += mid - i + 1;
                nums[k] = aux[j++];
            }
        }
    }
}