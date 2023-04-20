package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_47 {

    /**
     * 共享信息
     */
    int n;
    int[] nums;
    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 仅比 46 多了两行代码：预先排序 & 同层去重（注意：比组合多了一个 !used[i-1]）
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.used = new boolean[n];
        // 比 46 多了一行预先排序
        Arrays.sort(this.nums);
        back();
        return res;
    }
    void back() {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            // 比 46 多了一行预先排序后同层去重（比组合 Solution_90 多了一个 !used[i-1]）
            // 意思是在 nums[i-1] 与 nums[i] 值重复的情况下，判断 nums[i-1] 是否已经被上层选过了
            // 若 !use[i-1] == true 即 use[i-1] == false 即 nums[i-1] 没被上层选过，那么当前层必然在第 i-1 轮循环选取过了，就在这里去重
            // 若 !use[i-1] == false 即 use[i-1] == true 即 nums[i-1] 已经上层选过了，那么本层是可以选取这个值相同但位置不同的重复元素 nums[i] 的
            // 因为已经压根不是同一层了呀，只有同一层的重复选取才需要去重
            // 而对于组合问题来说，上层是必然选不到 nums[i-1] 的，因为有 startIndex 保证了每层能选的范围，上层必然选不了，所以无需此额外判断
            if (i != 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
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
