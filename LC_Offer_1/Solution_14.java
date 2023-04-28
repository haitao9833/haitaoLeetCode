package leetcode.LC_Offer_1;

/**
 * 14-Ⅰ 见 LC.LC_DP 343
 * 求 pow(2 , a) 过程中取余，见 LC.LC_Bit 50 幂运算
 * 取余运算规律：
 *      (a + b) % p = (a % p + b % p) % p
 *      (a - b) % p = (a % p - b % p) % p
 *      (a * b) % p = (a % p * b % p) % p
 */
public class Solution_14 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int count = n / 3 - 1;      // -1 是为了留一个 3 与余数作搭配
        int rest = n % 3;
        int p = 1000000007;

        long x = 3;
        long res = 1;
        while (count != 0) {
            if ((count & 1) == 1) res = (res * x) % p;
            x = (x * x) % p;
            count >>= 1;
        } // res = 3^{count - 1} ，在 50 的基础上加了两个 % p

        if (rest == 0) return (int)(res * 3 % p);
        else if (rest == 1) return (int)(res * 4 % p);
        else return (int)(res * 6 % p);
    }
}
