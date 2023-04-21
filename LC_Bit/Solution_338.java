package leetcode.LC_Bit;

public class Solution_338 {

    /**
     * lowBit 的动态规划
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) {
            // i 与 i & (i-1) 的二进制仅相差了一个 1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
