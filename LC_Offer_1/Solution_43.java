package leetcode.LC_Offer_1;

/**
 * 详见 k神，算每一位取 1 的个数：
 *        cur == 0 —— high * digit
 *                 —— 230X
 *                 —— [00 ~ 22] 1 [0 ~ 9]
 *        cur == 1 —— high * digit + low + 1
 *                 —— 231X
 *                 —— [00 ~ 22] 1 [0 ~ 9]
 *                 —— [23] 1 [0 ~ X]
 *        cur >= 2 —— high * digit + digit
 *                 —— [00 ~ 22] 1 [0 ~ 9]
 *                 —— [23] 1 [0 ~ digit-1]
 *        注意：
 *        与 digit 相乘的 high 都是原 High - 1
 *        后面 + 的 (low + 1) | (digit) 都是取 High 的时候
 */
public class Solution_43 {
    public int countDigitOne(int n) {
        int res = 0;

        int digit = 1; // 每一位取 1 的时候，其 low 部分以取的数的总类：1 、10 、100 、1000 、...
        int high = n / 10;
        int cur = n % 10;
        int low = 0;

        while (high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += high * digit + digit;

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
