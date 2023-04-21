package leetcode.LC_Bit;

public class Solution_190 {

    /**
     * 循环：n 的第 i 位，对于 res 的第 31-i 位
     */
    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0 ; i < 32 && n != 0 ; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }

    /**
     * Integer.reverse() & Integer.reverseBytes() 源码方法
     * @see Solution_191#hammingWeight2(int) 
     */
    public int reverseBits2(int n) {

        n = ((n & 0x55555555) << 1) | ((n >>> 1) & 0x55555555);
        n = ((n & 0x33333333) << 2) | ((n >>> 2) & 0x33333333);
        n = ((n & 0x0f0f0f0f) << 4) | ((n >>> 4) & 0x0f0f0f0f);
        n = ((n & 0x00ff00ff) << 8) | ((n >>> 8) & 0x00ff00ff);
        n = (n << 16) | (n >>> 16);

        return n;
    }
}

