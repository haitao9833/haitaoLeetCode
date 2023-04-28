package leetcode.LC_Offer_1;

/**
 * 求 1 + ... + n
 * 不能用 × 、÷
 *       for 、while
 *       if 、 else
 *       switch 、case
 *       ... ? ... : ...
 */
public class Solution_64 {
    public int sumNums(int n) {
        boolean short_circuit = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;  // 不用 if 而用 && 的短路性质，达到递归边界判断（n == 1）的效果
    }
}
