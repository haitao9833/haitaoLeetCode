package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_40 {

    /**
     * 共享信息
     */
    int n;
    int[] candidates;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 与 39 的区别：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有重复元素 ==> 同层去重<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每个元素只能取一次 ==> 下一层 back(i+1)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.n = candidates.length;
        this.candidates = candidates;

        // 预先排序 ==> 方便同层去重 & 方便优化剪枝
        Arrays.sort(candidates);

        back(0 , target);
        return res;
    }
    void back(int startIndex , int sum) {
        if (sum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex ; i < n && candidates[i] <= sum ; i++) {
            // 比 39 多了一行同层去重
            if (i != startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }

            sum -= candidates[i];
            path.add(candidates[i]);

            // 与 39 的区别 candidate[i] 只能取一次
            back(i + 1 , sum);

            sum += candidates[i];
            path.removeLast();
        }
    }
}
