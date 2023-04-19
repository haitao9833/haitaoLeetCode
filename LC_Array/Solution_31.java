package leetcode.LC_Array;

public class Solution_31 {

    /**
     * 升序表示最小了
     * <P> 降序表示最大了
     * <P> 逆序向前找第一对 A[i] < A[i+1] 且 A[i+1 ~ n-1] 为降序
     * <P> 表明 A[i+1 ~ n-1] 已经是最大化了，需要通过与最高位 A[i] 交换才能进一步更大化
     * <P> 交换 A[i] 与 A[i+1 ~ n-1] 中第一个比 A[i] 大，此时 A[i+1 ~ n-1] 依然降序，再翻转为升序最小化即可
     * <P> 例如 1 3 2 5 4 3
     * <P> 找到     2 5 4 3
     * <p> 交换     3 5 4 2
     * <p> 翻转     3 2 4 5 即可
     */
    public void nextPermutation(int[] nums) {
        // preliminary
        int n = nums.length;

        int i = n - 2;
        while (0 <= i && nums[i] >= nums[i + 1]) {
            i--;
        }

        // i == -1 表明整个 nums[] 都为逆序，即翻转整个 nums[] 即可
        if (0 <= i) {
            // 找第一个 nums[i] < nums[k] 交换为最高位
            int k = n - 1;
            while (i < k && nums[i] >= nums[k]) {
                k--;
            }
            swap(nums , i , k);
        }
        reverse(nums, i + 1 , n - 1);
    }
    private void reverse(int[] nums , int l , int r) {
        while (l < r) {
            swap(nums , l , r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
