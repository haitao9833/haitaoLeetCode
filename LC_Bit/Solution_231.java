package leetcode.LC_Bit;


public class Solution_231 {

    /**
     * 2 的幂次方必然是 1 << x 的形式
     * <P> 即最高位为 1 ，其他位都为 0
     * <P> lowBit 技巧
     * @see Solution_342
     */
    public boolean isPowerOfTwo(int n) {
        // && (n & (-n)) == n
        // && (n&(n^(n-1))) == n
        return n > 0 && (n & (n - 1)) == 0;
    }
}
