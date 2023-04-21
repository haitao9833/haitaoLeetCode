package leetcode.LC_Bit;

public class Solution_461 {

    /**
     * 异或一下 ==> 191
     */
    public int hammingDistance(int x , int y) {
        x ^= y;
        return Integer.bitCount(x);
    }
}
