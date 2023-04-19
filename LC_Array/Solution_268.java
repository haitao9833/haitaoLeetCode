package leetcode.LC_Array;

public class Solution_268 {

    /**
     * 同 136<p>
     * 用 nums[] 与 [0 , ... , n] 异或一遍
     * @see Solution_136
     * @see Solution_448
     */
    public int missingNumber1(int[] nums) {

        int n = nums.length;
        int res = 0;

        for (int i = 0 ; i < n ; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res ^ n;
    }

    /**
     * 作差法：(0 + 1 + ... + n) - (nums[0] + .. + nums[n-1])
     */
    public int missingNumber2(int[] nums) {

        int n = nums.length;

        // (0 + 1 + ... + n)
        int res = n * (n + 1) / 2;

        for (int num : nums) {
            res -= num;
        }
        return res;
    }
}
