package leetcode.LC_Array;

public class Solution_283 {

    public void moveZeroes1(int[] nums) {
        int idx = 0;
        for (var num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        // 最后还得把数组末尾的无效元素置为 0
        while (idx != nums.length) {
            nums[idx++] = 0;
        }
    }

    /**
     * <strong>双指针交换</strong>
     * <P> l 即上述的 idx ，指向待填充元素的位置，即必定指向一个 0
     * <P> r 遍历 nums[] 将非零元素与 nums[l] 交换
     */
    public void moveZeroes2(int[] nums) {
        int l = 0;
        for (int r = 0 ; r < nums.length ; r++) {
            if (nums[r] != 0) {
                if (l < r) {
                    // l < r 交换
                    nums[l++] = nums[r];
                    nums[r] = 0;
                } else {
                    // l == r 无需交换
                    l++;
                }
            }
        }
    }
}
