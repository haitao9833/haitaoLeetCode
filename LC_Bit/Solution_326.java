package leetcode.LC_Bit;

public class Solution_326 {

    /**
     * int 范围内最大的 3 的幂 3^{19} == 1162261467
     * <P> 判断 n 是否为 1162261467 的<strong>约数</strong>即可
     * <P> 231 中判断 2^x 也能用判断 n 是否为 2^{30} == (1 << 30) 的<strong>约数</strong>即可
     * <P> <strong>通解：要判断 n 是否为 k 次幂 k^x ，当 k 为质数的时候，只需要判断是否有 k^{max} % n == 0 即可</strong>
     * @see Solution_231
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
