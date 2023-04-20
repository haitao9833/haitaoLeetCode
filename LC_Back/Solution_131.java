package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_131 {

    /**
     * 共享信息
     */
    int n;
    char[] ch;
    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    /**
     * back(startIndex) == 在 s[startIndex , ... , n-1] 中分割出一个回文串
     */
    public List<List<String>> partition(String s) {
        this.n = s.length();
        this.ch = s.toCharArray();

        // 直接 copy Solution_647 的代码
        // dp[i][j] 表示 s[i , j] 子串是不是回文串
        this.dp = new boolean[n][n];
        for  (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = i ; j < n ; j++) {
                if (ch[i] == ch[j]) {
                    if (i + 2 >= j) {
                        dp[i][j] = true;
                    }
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        back(0);
        return res;
    }
    void back(int startIndex) {
        // 递归边界
        if (startIndex == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历本层：s[startIndex , ... , n-1]
        for (int i = startIndex ; i < n ; i++) {
            // 判断 s[startIndex , i] 是否回文
            if (dp[startIndex][i]) {
                // 取下该回文子串
                path.add(String.valueOf(ch , startIndex , i - startIndex + 1));
                back(i + 1);

                path.removeLast();
            }
        }
    }
}