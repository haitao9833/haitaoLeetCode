package leetcode.LC_Offer_1;

/**
 * 详见 k神 找规律
 * 数组下标的一些规律运算：
 *                     0 1 2 3 4 5 6 7 8 9 ...
 *       / 长度(比如 3) 0 0 0 1 1 1 2 2 2 3 ... （假想为二维数组，找行）
 *       % 长度(比如 3) 0 1 2 0 1 2 0 1 2 0 ... （假想为二维数组，找列）
 */
public class Solution_44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = start + (n - 1) / digit;                         // 见上找行
        return String.valueOf(num).charAt((n - 1) % digit) - '0';   // 见上找列
    }
}
