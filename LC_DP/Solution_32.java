package leetcode.LC_DP;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_32 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i] 表示以第 i 个字符为结尾的最长有效括号长度
     *      dp[i] 表示以 s[i-1] 为结尾的最长有效括号长度
     *      注意 i 非下标，即第 i 个字符 == s[i-1]
     *      按理来说可以改成下标 i ，因为前 0 个字符对此 dp[] 无意义，但第 i 个字符语义更加丰富
     * 状态转移：
     *      【划分一：s[i-1] = '(' 或 ')'】
     *      【划分二：s[i-1] = ')' 的情况下看 s[i-2] = '(' 或 ')'】
     *      dp[i] = 0               在 s[i-1] == '(' 的情况下
     *      dp[i] = dp[i-2] + 2     在 s[i-1] == ')' && s[i-2] == '(' 的情况下
     *      dp[i] = dp[i-1] + 2 + dp[i-1-dp[i-1]-1]
     *                              在 s[i-1] == ')' && s[i-2] == ')' && s[i-1-dp[i-1]-1] == '(' 的情况下
     *                              解析：
     *                                  dp[i-1] == 以 s[i-2] 为结尾的最长有效括号长度
     *                                  s[i-1-dp[i-1]-1] 即应该与 s[i-1] 匹配的 '('
     *                              见图：
     *                                  ...                  (               (...)         )
     *                           dp[i-1-dp[i-1]-1]    s[i-1-dp[i-1]-1]      dp[i-1]     s[i-1]
     *                              注意：要判断是否越界 dp[0]
     * 遍历顺序：
     *      i 基于 i - 1 和 i - 2 ，所以 i 正序遍历
     *      且 i 表示第 i 个字符，且第 0 个字符和第 1 个字符无法组成有效括号表达式，必有 dp[0] = dp[1] = 0
     *      所以 i 正序遍历 [2 -> n]
     * 初始化：见上述遍历顺序
     */
    public int longestValidParentheses1(String s) {

        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        char[] chS = s.toCharArray();
        int res = 0;

        // 直接从第 2 个字符开始遍历，因为第一个字符无法组成有效的括号表达式
        for (int i = 2 ; i <= n ; i++) {
            if (chS[i - 1] == ')') {
                if (chS[i - 2] == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    if (i - 1 - dp[i - 1] - 1 >= 0 && chS[i - 1 - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - 1 - dp[i - 1] - 1];
                    }
                }
            }
            // 用 res 进行比较、记录下最大的
            res = Math.max(res , dp[i]);
        }

        return res;
    }

    /**
     * 栈
     *    依次遍历 s[0 ~ n-1]
     *    s[i] == '('   下标 i 入栈
     *    s[i] == ')'   直接出栈
     *                     栈空：出栈的是有效括号表达式的起始下标 startIdx （初始值 == -1）
     *                   栈非空：匹配到了一个 '(' ，栈顶此时为 startIdx ，求长度 i - startIdx
     *    举例：s = ( ( ) ( ) ) ) ( )
     *         i = 0 1 2 3 4 5 6 7 8
     *    栈内下标变化如下：
     *         -1
     *         -1 0
     *         -1 0 1
     *         -1 0    下标 1 出栈，栈非空，匹配 1 、2，可求 len = 2 - 0 = 2
     *         -1 0 3
     *         -1 0    下标 3 出栈，栈非空，匹配 3 、4，可求 len = 4 - 0 = 4
     *         -1      下标 0 出栈，栈非空，匹配 0 、5，可求 len = 5 - (-1) = 6
     *         6       下标 -1 出栈，栈空，表示无匹配，下标 6 入栈
     *         6 7
     *         6       下标 7 出栈，栈非空，匹配 7 、8，可求 len  = 8 - 6 = 2
     *         记录过程中最长的 res = 6
     */
    public int longestValidParentheses2(String s) {
        // preliminary ，初始值 startIdx == -1
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                // 有可能有多个连续的 '(' ，其下标作为 startIdx
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 确保栈中始终有且只有一个 -1 或 ')' ，其下标作为 startIdx
                    stack.push(i);
                } else {
                    res = Math.max(res , i - stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * 贪心双指针
     *      l == '(' 的数量
     *      r == ')' 的数量
     *      从左向右遍历一遍：
     *              l = r 计算有效长度
     *              l < r 重置为 0 ，且注意，在 l < r 的情况之前，肯定已经遇到且计算过 l = r 的情况了
     *              l > r 无定义，仅会漏掉一种情况 ...((...)... ，所以还需要从右向左遍历一遍
     *      从右向左遍历一遍：
     *              l = r 计算有效长度
     *              l > r 重置为 0 ，且注意，在 l > r 的情况之前，肯定已经遇到且计算过 l = r 的情况了
     *              l < r 无定义，仅会漏掉一种情况 ...(...))... ，所以还需要从左向右遍历一遍
     */
    public int longestValidParentheses3(String s) {

        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        char[] chS = s.toCharArray();
        int l = 0;
        int r = 0;
        int res = 0;

        // s 遍历顺序 [0 -> n-1]
        for (int i = 0 ; i < n ; i++) {
            if (chS[i] == '(') {
                l++;
            } else {
                r++;
            }
            if (l < r) {
                l = 0;
                r = 0;
            } else if (l == r) {
                res = Math.max(res , l + r);
            }
        }
        l = 0;
        r = 0;

        // s 遍历顺序 [n-1 -> 0]
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (chS[i] == ')') {
                r++;
            } else {
                l++;
            }
            if (l > r) {
                l = 0;
                r = 0;
            } else if (l == r) {
                res = Math.max(res , l + r);
            }
        }

        return res;
    }
}
