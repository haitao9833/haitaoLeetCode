package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_216 {

    /**
     * 共享信息
     */
    int k;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back(startIndex , sum) == 在 [startIndex , ... , 9] 中选择一个凑 sum
     */
    public List<List<Integer>> combinationSum3(int k , int n) {
        this.k = k;
        back(1 , n);
        return res;
    }
    void back(int startIndex , int sum) {
        // 递归边界
        if (path.size() == k) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 遍历本层：[startIndex , ... , 9]
        // 剪枝优化一：同 77 ，至少还要有 k-path.size() 个数选
        // 剪枝优化二：同 39 ，保证 i <= sum 即不会溢出 sum
        for (int i = startIndex ; i <= 9 + 1 - k + path.size() && i <= sum ; i++) {
            sum -= i;
            path.add(i);

            // 同 40 每个数只能选取一次
            back(i + 1 , sum);

            sum += i;
            path.removeLast();
        }
    }
}
