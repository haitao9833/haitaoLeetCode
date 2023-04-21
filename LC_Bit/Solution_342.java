package leetcode.LC_Bit;

public class Solution_342 {

    /**
     * 4 的幂次方必然是 1 << 2x 的形式
     * <P> 即最高位为 1 ，其他位都为 0
     * <P> 且 1 必须<strong>在偶数位上</strong>
     * <P> 比 231 多了一个<strong>判断在偶数位上</strong>
     * @see Solution_326
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) == n;
    }
}
