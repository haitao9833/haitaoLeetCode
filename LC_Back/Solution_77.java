package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_77 {

    /**
     * 共享信息<p>
     * path 用 LinkedList 方便尾部追加删除
     */
    int n;
    int k;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back(startIndex) == 在 [startIndex , ... , n] 中选择一个
     */
    public List<List<Integer>> combine(int n , int k) {
        this.n = n;
        this.k = k;
        back(1);
        return res;
    }
    void back(int startIndex) {
        // 递归边界
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历本层：[startIndex , ... , n]
        // 剪枝优化：至少还要有 k-path.size() 个数选，即 k-path.size() <= n-i+1 ，即 i <= n+1-k+path.size()
        for (int i = startIndex ; i <= n + 1 - k + path.size() ; i++) {
            path.add(i);
            back(i+1);

            // 这才是回溯，回溯到本层重新选一个
            // 不要被 back() 函数名误导了，该函数是递归
            path.removeLast();
        }
    }
}
