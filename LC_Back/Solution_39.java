package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_39 {

    /**
     * 共享信息
     */
    int n;
    int[] candidates;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back(startIndex , sum) == 在 candidates[startIndex , ... , n-1] 中选择一个凑 sum<p>
     * 注意：candidate[i] 可以<font style="color:red">重复选取</font> ==> 下一层应该 back(i) 而不是 back(i+1)
     */
    public List<List<Integer>> combinationSum(int[] candidates , int target) {
        this.n = candidates.length;
        this.candidates = candidates;

        // 预先排序，方便优化剪枝
        Arrays.sort(candidates);

        back(0 , target);
        return res;
    }
    void back(int startIndex , int sum) {
        // 递归边界
        if (sum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历本层：candidates[startIndex , ... , n-1]
        // 剪枝优化：若 sum < candidate[i] 则后续都有 sum < candidate[i+1 , ... , n-1] ，可以剪枝了
        for (int i = startIndex ; i < n && candidates[i] <= sum ; i++) {
            sum -= candidates[i];
            path.add(candidates[i]);

            // candidate[i] 可以重复选取
            back(i , sum);

            // 回溯
            sum += candidates[i];
            path.removeLast();
        }
    }
}
