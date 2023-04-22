package leetcode.LC_DP;

public class Solution_132 {

    /**
     * dp 动态规划
     * 含义：cnt[i] 表示将下标 s[0 , i] 分割成回文子串的最小切割数，此处 i 为下标
     * 状态转移：
     *      【划分一：下标 s[0 , i] 自身是不是回文子串】
     *      【划分二：下标 s[0 , i] 自身不是回文子串的情况下，则需比较所有的对 s[0 , i] 的切割方案，并取其中的最小值】
     *      【在所有的对 s[0 , i] 的切割方案中，最后一个字符 s[i] 必然要切割到某个回文子串中】
     *      【则遍历所有以 s[i] 为结尾的回文子串，即遍历了所有的对 s[0 , i] 的切割方案】
     *      【需配合 647 的 dp[i][j] 表示判断下标 s[i , j] 是不是回文子串】
     *      cnt[i] = 0                   dp[0][i] == true 即下标 s[0 , i] 为回文子串，无需分割
     *      cnt[i] = min(cnt[j]) + 1     dp[0][i] != true && dp[j+1][i] == true ，且 j 需遍历 [0 , i-1]
     *      【项分析可知，i 必须正序遍历 [1 -> len(s)-1] ，j 正序逆序无所谓，并配合初始化 i=0 的情况】
     * 遍历顺序：【综上同上】
     * 初始：
     *      cnt[0] = 0  即 s 的第一个字符即为回文子串，无需分割
     */
    public int minCut(String s) {

        // 直接复制 647 的代码
        int n = s.length();
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for  (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = i ; j < n ; j++) {
                if (ch[i] == ch[j]) {
                    if (Math.abs(j - i) <= 2) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[n];

        for (int i = 1 ; i < n ; i++) {
            if (dp[0][i]) {
                cnt[i] = 0;
            } else {
                // 预设一个最大值，s[0 , i] 之间共 i 个空隙，至多可分割 i 次为 i+1 个字符
                cnt[i] = i;
                for (int j = i - 1 ; j >= 0 ; j--) {
                    if (dp[j + 1][i]) {
                        cnt[i] = Math.min(cnt[i] , cnt[j] + 1);
                    }
                }
            }
        }
        return cnt[n - 1];
    }
}
