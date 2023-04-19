package leetcode.LC_Array;

public class Solution_41 {

    /**
     * 同 448 ，把值 [1 , n] 放到下标 [0 , n-1] 处<p>
     * 对于负值和不在 [1 , n] 范围内的值，不需要交换移动
     * @see Solution_448
     */
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            // 比 448 多了范围判断 nums[i] ∈ [1 , n]
            // 因为 nums[] 并非全是 [1 , n] 中的数值，还有负值，这些其他值不需要交换移动
            while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 检查下标与元素值不对应，返回第一个不存在的正整数
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // [1 , n] 都有的情况下，返回 n+1
        return n + 1;
    }
}
