package leetcode.LC_Array;

import leetcode.LC_Bit.Note;

public class Solution_260 {

    /**
     * 两个数可以通过他们异或后的 lowBit 划分
     * <P>划分后同 136
     * @see Note#lowBit()
     * @see Solution_136
     */
    public int[] singleNumber(int[] nums) {
        // res == x1 ^ x2
        int res = 0;
        for (var num : nums) {
            res ^= num;
        }

        // 取 res 的 lowBit
        // 由于 res 是 x1 、x2 异或的结果
        // 所以在该二进制位 x1 、x2 必然一个为 0 一个为 1
        int lowBit = res & (-res);

        // 将 x1 划分到 nums[] 中所有该位为 0 的子数组中异或得出
        // 将 x2 划分到 nusm[] 中所有该位为 1 的子数组中异或得出
        int one = 0;
        int two = 0;
        for (var num : nums) {
            if ((num & lowBit) != 0) {
                one ^= num;
            } else {
                two ^= num;
            }
        }
        return new int[]{one , two};
    }
}
