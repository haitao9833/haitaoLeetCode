package leetcode.LC_DP;


public class Solution_5 {

    /**
     * 中心扩展法：<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以 1 个字符为中心向左右扩展<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以 2 个字符为中心向左右扩展
     * @see Solution_516
     */
    public String longestPalindrome(String s) {

        int n = s.length();
        if (n <= 1) {
            return s;
        }

        char[] chs = s.toCharArray();
        int L = 0;
        int R = 0;

        // [i , i+j] 为扩展中心，j ∈ [0 , 1]
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <= 1 ; j++) {

                // [l , r] 为回文串左右边界
                int l = i;
                int r = i + j;

                // 扩展
                while (0 <= l && r < n && chs[l] == chs[r]) {
                    if (r - l + 1 > R - L + 1) {
                        // [L , R] 记录更长的 [l , r]
                        L = l;
                        R = r;
                    }
                    l--;
                    r++;
                }
            }
        }

        // chs[L , R] -> String
        return String.valueOf(chs , L , R - L + 1);
    }
}
