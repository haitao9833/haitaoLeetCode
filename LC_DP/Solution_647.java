package leetcode.LC_DP;

public class Solution_647 {

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示下标 s[i , j] 是不是回文子串
     * 初始化：包含在下述状态转移中了
     * 状态转移：
     *      dp[i][j] = s[i] == s[j] && j == (i | i+1 | i+2)   初始化长度为 1 、2 、3 的回文子串
     *      dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
     * 遍历顺序：
     *      i 基于 i+1 ，逆序 [n-1 -> 0]
     *      j 基于 j-1 ，且要保证 s[i , j] 区间有效，正序 [i -> n-1]
     *      左下角 dp[i+1][j-1]
     * @see Solution_132
     */
    public int countSubstrings1(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int res = 0;
        char[] ch = s.toCharArray();

        for  (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = i ; j < n ; j++) {
                if (ch[i] == ch[j]) {
                    if (Math.abs(j - i) <= 2) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 空间优化，二维变一维：
     *      策略一，且内层 j 正序遍历 [i -> n-1]
     *      会破坏左下角 dp[i+1][j-1] 即 dp[j-1] ，需用 temp + lowerLeft 记录
     *      二维变一维的常规点：不符合条件的 dp[] ，需要手动修改为 false
     */
    public int countSubstrings2(String s) {
        // preliminary
        int n = s.length();

        // 初始化
        boolean[] dp = new boolean[n];
        int res = 0;
        char[] ch = s.toCharArray();

        for  (int i = n - 1 ; i >= 0 ; i--) {

            // 理解外层循环：对于第 i 次遍历，数组旧值 dp[j] == dp[i+1][j]
            // lowerLeft 的初始值无关紧要，因为前 dp[i][i] ~ dp[i][i+2] 都无需依据左下角进行计算更新
            // lowerLeft 的第一个有效值从记录 dp[i+1][i+2] 开始，用于后面的 dp[i][i+3] ~ dp[i][n-1]
            boolean lowerLeft = false;
            boolean temp;

            for (int j = i ; j < n ; j++) {

                // 计算更新当前 dp[j] 之前，此 dp[j] 代表的是 dp[i+1][j] ，保存下来
                // 待当前 dp[j] 依据 lowerLeft 计算更新后再赋值给 lowerLeft 用于下一个 dp[j+1] 的计算更新使用
                temp = dp[j];

                // lowerLeft 保存着对当前 dp[j] 而言的 dp[i+1][j-1] ，用于状态转移计算更新
                if (ch[i] == ch[j]) {
                    if (i + 2 >= j) {
                        res++;
                        dp[j] = true;
                    }
                    else if (lowerLeft) {
                        res++;
                        dp[j] = true;
                    } else { dp[j] = false; }
                } else { dp[j] = false; }

                // lowerLeft 更新，保存着对于下一个 dp[j+1] 而言的 dp[i+1][j]
                lowerLeft = temp;
            }
        }
        return res;
    }

    /**
     * 空间优化，二维变一维：
     *      策略一，且内层 j 逆序遍历 [n-1 -> j]
     *      不会破坏左下角 dp[i+1][j-1] 即 dp[j-1] ，无需用 lowerLeft 记录
     *      直接使用 dp[j - 1] 判断即可
     *      二维变一维的常规点：不符合条件的 dp[] ，需要手动修改为 false
     */
    public int countSubstrings3(String s) {
        // preliminary
        int n;
        if (s == null || (n = s.length()) == 0) {
            // 赋值语句 = 的返回值就是 = 号右端的值
            return 0;
        }
        boolean[] dp = new boolean[n];
        int res = 0;
        char[] ch = s.toCharArray();

        for  (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = n - 1 ; j >= i ; j--) {
                if (ch[i] == ch[j]) {
                    if (i + 2 >= j) {
                        res++;
                        dp[j] = true;
                    }
                    else if (dp[j - 1]) {
                        res++;
                        dp[j] = true;
                    } else { dp[j] = false; }
                } else { dp[j] = false; }
            }
        }
        return res;
    }

    /**
     * 中心扩展算法
     * @see Solution_5
     */
    public int countSubstrings4(String s) {

        int n = s.length();

        int res = 0;
        char[] chs = s.toCharArray();

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <= 1 ; j++) {

                // [l , r] 为回文串左右边界
                int l = i;
                int r = i + j;

                // 扩展
                while (0 <= l && r < n && chs[l--] == chs[r++]) {
                    res++;
                }
            }
        }
        return res;
    }
}
