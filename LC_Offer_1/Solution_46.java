package leetcode.LC_Offer_1;

/**
 * 0 ~ 25 - a ~ z
 * 有多少种可能的转换
 * 动态规划：
 *        dp[i] 表示前 i 个数字的转换方案数
 *        状态转移：
 *               dp[i] = dp[i - 1] + dp[i - 2]    第 i 个数和前面的第 i - 1 个数可以组合翻译 ∈ [10,25]
 *               dp[i] = dp[i - 1]                第 i 个数和前面的第 i - 1 个数不可能组合翻译
 *        初始化：
 *               dp[0] = dp[1] = 1
 *               因为状态转移中有 i-1 与 i-2 ，所以要从 dp[0] 初始起
 *               当第 1 、2 位的数字可以组合翻译时时，显然前两个数组共有 2 种翻译方法
 *               即 dp[2] = dp[1] + dp[0] = 2
 *               而显然 dp[1] = 1 ，因此推出 dp[0] = 1
 */
public class Solution_46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int dp_prepre = 1;
        int dp_pre = 1;  // 空间优化
        for (int i = 2 ; i <= s.length() ; i++) {   // s[i] 是第 i + 1 个数字
            String temp = s.substring(i - 2 , i);
            int dp_now = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? dp_prepre + dp_pre : dp_pre;
            dp_prepre = dp_pre;
            dp_pre = dp_now;
        }
        return dp_pre;
    }
}

/**
 * 对称的动态规划
 *      动态规划的计算对称的
 *      可以从左向右（开辟 String 空间，用 substring()）
 *      可以从右向左（低位-->高位，求余）
 */
class Solution_46_02 {
    public int translateNum(int num) {
        int dp_prepre = 1;
        int dp_pre = 1;
        int x;                   // 高位
        int y = num % 10;        // 低位
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int temp = x * 10 + y;

            int dp_now = temp >= 10 && temp <= 25 ? dp_prepre + dp_pre : dp_pre;
            dp_prepre = dp_pre;
            dp_pre = dp_now;

            y = x;               // 更新低位
        }
        return dp_pre;
    }
}
