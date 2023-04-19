package leetcode.LC_Array;

public class Solution_172 {

    /**
     * 末尾的 0 一定是某个 2 和某个 5 的杰作
     * <p> 依据 62 的整除原理
     * <p> 5 的个数必然比 2 的个数少，所以统计有多少个 5 即可
     * <p> 每 5 个连续的整数中必有且仅有一个数可以整除 5
     * <p> 每 25 个连续的整数中必有且仅有一个数可以整除 25
     * <p> 每 125 个连续的整数中必有且仅有一个数可以整除 125
     * <p> ...
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
