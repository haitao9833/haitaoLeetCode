package leetcode.LC_DBFS;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {

    /**
     * 共享信息
     */
    int n;
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    /**
     * back1(l , r) == 减法，还剩多少 l 和 r ，且在 l <= r 时才可以继续递归生成
     * back2(l , r) == 加法，用了多少 l 和 r ，且在 l >= r 时才可以继续递归生成
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs1(n , n);
        // dfs2(0 , 0);
        return res;
    }
    private void dfs1(int l , int r) {
        // 递归边界一，已经填完 n 个 '(' 和 n 个 ')' ，即得到一种有效的括号表达式了
        if (l == 0 && r == 0) {
            res.add(path.toString());
            return;
        }
        // 递归边界二，上层填错了，')' 比 '(' 填多了
        if (l > r) {
            return;
        }

        // 当前层可填入 '(' 或 ')'
        if (l > 0) {
            path.append('(');
            dfs1(l - 1 , r);
            path.deleteCharAt(path.length() - 1);
        }
        if (r > 0) {
            path.append(')');
            dfs1(l , r - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
    private void dfs2(int l , int r) {
        // 递归边界一，已经填完 n 个 '(' 和 n 个 ')' ，即得到一种有效的括号表达式了
        if (l == n && r == n) {
            res.add(path.toString());
            return;
        }
        // 递归边界二，上层填错了，'(' 比 ')' 填少了
        if (l < r) {
            return;
        }

        // 当前层可填入 '(' 或 ')'
        if (l < n) {
            path.append('(');
            dfs2(l + 1 , r);
            path.deleteCharAt(path.length() - 1);
        }
        if (r < n) {
            path.append(')');
            dfs2(l , r + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
