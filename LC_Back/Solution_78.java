package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_78 {

    /**
     * 共享信息
     */
    int n;
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back(startIndex) == 在 nums[startIndex , ... , n-1] 中选择一个<p>
     * 注意：无条件收集所有子集<p>
     * 子集个数：2^n<p>
     * 真子集个数：2^n - 1
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        back(0);
        return res;
    }
    void back(int startIndex) {
        // 无条件收集所有子集结果
        // 第一次调用 back(0) 时会添加一个空集
        res.add(new ArrayList<>(path));

        // 遍历本层：nums[startIndex , ... , n-1]
        for (int i = startIndex ; i < n ; i++) {
            path.add(nums[i]);
            back(i + 1);

            // 回溯到本层重新选一个
            path.removeLast();
        }
    }
}
