package leetcode.LC_Array;

public class Solution_137 {

    /**
     * 把 nums[] 中的每一个数的<strong>第 i 位二进制</strong>加起来 % 3 == res 的<strong>第 i 位二进制</strong><p>
     * <strong>通用解法</strong>：将 % 3 改为 % m 即可对应于其他元素都出现了 m 次，找出仅出现了一次的那个元素
     * @see Solution_136
     * @see Solution_260
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0 ; i < 32 ; i++) {
            int total = 0;
            for (var num : nums) {
                total += ((num >> i) & 1);
            }
            // 置 res 的第 i 位为 1
            if (total % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
