package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_46 {

    /**
     * 共享信息<p>
     * used[i] == true 表示下标 i 处的元素 nums[i] 之前被选过了
     */
    int n;
    int[] nums;
    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back() == 在 nums[0 , ... , n-1] 中随便选一个<strong>没选过</strong>的元素
     */
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.used = new boolean[n];
        back();
        return res;
    }
    void back() {
        // 递归边界
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 每层都需从头到尾遍历 [0 -> n-1]
        // 之前未被取过的 nums[i] 都可以选择
        for (int i = 0 ; i < n ; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);

            back();

            path.removeLast();
            used[i] = false;
        }
    }
}
