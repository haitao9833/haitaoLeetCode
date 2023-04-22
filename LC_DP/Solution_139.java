package leetcode.LC_DP;

import java.util.*;

public class Solution_139 {

    /**
     * dp 动态规划
     * 含义：
     *      dp[i] 表示 s 的前 i 个字符能否用 wordDict[] 拼接出来
     *      注意 i 非下标
     *      前 0 个字符（即空字符串）是可以用 wordDict[] 拼接出来的（即不使用任何单词）
     * 状态转移：
     *      dp[i] = dp[j] && (s[j~i-1] ∈ wordDict)
     *      【其中需要使用 j 逆序遍历 [i-1 -> 0] ，且只要存在一个 j 的划分使得 dp[i] = true 的话，即可退出 j 循环】
     *      【进一步优化的话，其实 j 只需要逆序遍历到最长单词长度即可，即 [i-1 -> i-1-maxLen(wordDict)+1] 范围即可】
     * 遍历顺序：
     *      【 i 基于 j ，即基于 [0 ~ i-1] ，即从 dp[0] 开始的所有的正左方列 [dp[0] , dp[i-1]] 】
     *      【表明了首先需要保证 dp[0] 必须在正左方，即 i 至少要从 1 开始，且为正序遍历 [1 -> len(s)]】
     *      【则也同时表明了 dp[0] 必须手动初始化，因为 dp[0] 无法由状态转移方程更新计算出来】
     * 初始化：
     *      dp[0] = true    对于空字符串，不选择 wordDict[] 中的任何单词，即可"拼接"出来
     * @see Solution_140
     */
    public boolean wordBreak(String s , List<String> wordDict) {

        // 将 List 转化为 Set 以便于使用 contains(word) 函数
        int n = s.length();
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen , word.length());
        }
        Set<String> wordSet = new HashSet<>(wordDict);

        // 初始化
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1 ; i <= n ; i++){
            for (int j = i - 1 ; j >= Math.max(0 , i - 1 - maxLen + 1) ; j--){
                if (dp[j] && wordSet.contains(s.substring(j , i))){
                    // s.substring(start , end) == s[start , end)
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
