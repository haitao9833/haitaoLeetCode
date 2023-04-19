package leetcode.LC_Array;

import leetcode.LC_Offer_1.Solution_51;

import java.util.ArrayList;
import java.util.List;

public class Solution_315 {

    /**
     * 官方图解很不错
     * <P> aux[] == 辅助数组
     * <P> cnt[] == 排序过程中累加记录每个元素 nums[i] 的逆序对个数，即题目要求的最后的结果 counts[]
     * <P> idx[] == 并不实际排序 nums[i] 而仅仅排序其下标 i
     * <P> 因为若直接对 nums[i] 排序，则每个元素可能因为移动而失去其本来的下标 i ，则无法在 cnt[i] 中累加了
     */
    private int[] aux;
    private int[] cnt;
    private int[] idx;

    /**
     * 归并逆序排序中求逆序对的技巧：
     * <P> 待合并两个有序子区间  [5 3 1 | 6 4 2]
     * <P> 对应下标为 idx[] == [0 1 2 | 3 4 5]
     * <P> 用 i 遍历 idx[0 1 2]
     * <P> 用 j 遍历 idx[3 4 5]
     * <P> 第一次放入 aux[] 的是后半部分子区间的首元素 6 的下标 aux == [3]
     * <P> 且无需计算对应元素 6 的逆序对，且其后的 [4 2] 必然已经在之前的合并排序后半部子区间 [6 4 2] 中计算累加过了
     * <P> 第二次放入 aux[] 的是前半部分子区间的首元素 5 的下标 aux == [3 0]
     * <P> 则对应元素 5 需要累加后半部分子区间 [4 2] 对其贡献的逆序对 len([4 2]) == len([4 5]) == 2
     * <P> 即 cnt[0] += 2
     * <P> <strong>本质即：放 [i] 的时候需要累加计算逆序对</strong>
     * @see Solution_51
     */
    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        idx = new int[n];
        cnt = new int[n];
        aux = new int[n];

        // 逻辑排序：nums[i]
        // 实际排序：idx[] 中的 i
        for (int i = 0 ; i < n ; i++) {
            idx[i] = i;
        }

        sortAndMerge(nums , 0 , n - 1);

        // cnt[] --> List
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0 ; i < n ; i++) {
            res.add(cnt[i]);
        }
        return res;
    }

    /**
     * 将 912 的 sort() 和 merge() 的合并写法
     * @see Solution_912#sort(int[], int, int)
     */
    private void sortAndMerge(int[] nums , int l , int r) {
        // 与 912 不同
        // 递归边界，待排序合并区间 [l , r] 仅一个元素
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        sortAndMerge(nums , l , mid);
        sortAndMerge(nums , mid + 1 , r);

        int i = l;
        int j = mid + 1;

        // 将 912 中的 idx 改名为 k 避免和 idx[] 同名
        for (int k = l ; k <= r ; k++) {
            if (i > mid) {
                aux[k] = idx[j++];
            } else if (j > r) {
                aux[k] = idx[i++];
            } else if (nums[idx[i]] <= nums[idx[j]]) {
                // 与 912 不同
                // 逆序排序
                // 且相等的时候优先选择后半部分 [j , r] 中的
                // 因为并不能保证 [j+1 , r] 可以对 [i] 贡献逆序对
                aux[k] = idx[j++];
            } else {
                // 放 [i] 的时候计算逆序对，说明 [j , ... , r] 区间内的元素可以对 [i] 贡献逆序对
                cnt[idx[i]] += r - j + 1;
                aux[k] = idx[i++];
            }
        }

        // 与 912 略不同
        // 先合并到 aux[] 中，然后复制回 idx[]
        System.arraycopy(aux , l , idx , l , r - l + 1);
    }
}
