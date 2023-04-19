package leetcode.LC_Array;


public class Solution_136 {

    /**
     * 异或满足<strong>交换律</strong>和<strong>结合律</strong>
     * @see Solution_137
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
