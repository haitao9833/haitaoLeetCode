package leetcode.LC_Bit;

public class Solution_9 {

    /**
     * 反转 x 的后半部分
     */
    public boolean isPalindrome(int x) {

        // 依题意，负数都不是回文数
        if (x < 0) {
            return false;
        }

        // 个位数为 0 不是回文数
        if (x != 0 && (x % 10) == 0) {
            return false;
        }

        // 反转 x 的后半部分存储到 half 中
        int half = 0;
        while (x > half) {
            int digit = x % 10;
            half = half * 10 + digit;
            x /= 10;
        }

        // x 有偶数位 ，x == half
        // x 有奇数位 ，x == half / 10
        return x == half || x == half / 10;
    }
}
