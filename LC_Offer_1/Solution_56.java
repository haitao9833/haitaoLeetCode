package leetcode.LC_Offer_1;

/**
 * Ⅰ ——
 * 类似 LC_Office_3 19_02
 */
public class Solution_56 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) sum ^= num; // sum 现在是两个缺失的数的异或了
        int lowbit = sum & (-sum);
        int one = 0;
        for (int i = 0 ; i < nums.length ; i++) { // 比 19_02 还方便，nums[] 中成对出现
            if ((nums[i] & lowbit) == lowbit) {
                one ^= nums[i];
            }
        }
        return new int[]{one , one ^ sum};
    }
}
