package leetcode.LC_Bit;

public class Solution_191 {

    /**
     * 循环：lowBit
     * @see Solution_338
     */
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    /**
     * Integer.bitCount() 源码方法
     * @see Solution_461
     */
    public int hammingWeight2(int n) {
        n = ((n & 0x55555555)) + ((n >>> 1) & 0x55555555);
        n = ((n & 0x33333333)) + ((n >>> 2) & 0x33333333);
        n = ((n & 0x0f0f0f0f)) + ((n >>> 4) & 0x0f0f0f0f);
        n = ((n & 0x00ff00ff)) + ((n >>> 8) & 0x00ff00ff);
        n = (n >>> 16) + (n & 0x0000ffff);
        return n;
    }
}