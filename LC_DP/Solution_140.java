package leetcode.LC_DP;

import java.util.*;

public class Solution_140 {

    /**
     * 共享信息
     */
    private int n;
    private int maxLen;
    private Set<String> wordSet;
    private List<String> res;
    private LinkedList<String> path;

    /**
     * 正序划分，纯回溯，需要 startIndex
     * @see leetcode.LC_Back.Note
     */
    public List<String> wordBreak1(String s , List<String> wordDict) {
        n = s.length();
        maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        wordSet = new HashSet<>(wordDict);
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracking1(0 , s);
        return res;
    }
    private void backTracking1(int startIndex , String s) {

        if (startIndex == n) {
            res.add(String.join(" " , path));
            return;
        }

        // 对 s 依次从 s[startIndex] 开始向后取长度为 1 、2 、... 、maxLen 的单词 s[startIndex , endIndex)
        for (int endIndex = startIndex + 1 ; endIndex <= Math.min(n , startIndex + maxLen) ; endIndex++) {

            String word = s.substring(startIndex , endIndex);

            // s[startIndex , endIndex) ∈ wordDict
            if (wordSet.contains(word)) {
                path.addLast(word);
                backTracking1(endIndex , s);
                path.removeLast();
            }
        }
    }

    /**
     * 逆序划分，dp 预处理优化 + 回溯，需要 endIndex 表示 s 的前 endIndex 个字符
     * @see Solution_139
     */
    private boolean[] dp;
    public List<String> wordBreak2(String s , List<String> wordDict) {
        n = s.length();
        maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        wordSet = new HashSet<>(wordDict);
        dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1 ; i <= n ; i++){
            for (int j = i - 1; j >= Math.max(0 , i - 1 - maxLen + 1) ; j--){
                if (dp[j] && wordSet.contains(s.substring(j , i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        // 以上直接复制 139 的代码

        // dp[] 的价值在于可以知道字符串 s 的前 i 个字符是否可以依据 dict 进行全划分
        // 只有在字符串 s 的前 n 个字符能依据 dict 进行完全划分的情况下，才用回溯去收集所有可能的结果
        res = new ArrayList<>();
        if (dp[n]) {
            path = new LinkedList<>();
            backTracking2(n , s);
        }
        return res;
    }
    private void backTracking2(int endIndex , String s) {
        if (endIndex == 0) {
            res.add(String.join(" " , path));
            return;
        }

        // 对 s 依次从 s[endIndex-1] 开始向前取长度为 1 、2 、... 、maxLen 的单词 s[startIndex , endIndex)
        for (int startIndex = endIndex - 1 ; startIndex >= Math.max(0 , endIndex - maxLen) ; startIndex--) {

            String word = s.substring(startIndex , endIndex);

            // s[startIndex , endIndex) ∈ wordDict
            // 且剩余的 s 的前 startIndex 个字符能依据 wordDict 进行全划分的情况下，才继续递归划分
            // 其实这里去掉 dp[startIndex] 判断也能通过测试用例，递归到一定程度会自己返回
            // 但 dp[] 预处理的优化之处就在于免去了那些无效的、无意义的、必定失败而返的递归
            if (wordSet.contains(word) && dp[startIndex]) {
                path.addFirst(word);
                backTracking2(startIndex , s);
                path.removeFirst();
            }
        }
    }
}
