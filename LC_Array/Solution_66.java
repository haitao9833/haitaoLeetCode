package leetcode.LC_Array;

import leetcode.LC_Linked.Solution_2;

public class Solution_66 {

    /**
     * 和 2 恰好相反，首元素 nums[0] 为最高位
     * @see Solution_2
     */
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        // 进位 up ∈ [0 , 1]
        for (int i = n - 1 ; i >= 0 ; i--) {
            // sum
            digits[i]++;

            // 当前位的位值
            digits[i] %= 10;

            // 没有出现进位了，直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }

        // digit[] 算完后还有进位
        // 只有 [9 ... 9] + 1 这一种可能，直接返回 [1 , ...]
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
