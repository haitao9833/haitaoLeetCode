package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution_90 {

    /**
     * 共享信息
     */
    int n;
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 仅比 78 多了两行代码：预先排序 & 同层去重
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        // 比 78 多了一行预先排序
        Arrays.sort(this.nums);
        back(0);
        return res;
    }
    void back(int startIndex){

        res.add(new ArrayList<>(path));

        for (int i = startIndex ; i < n ; i++) {
            // 比 78 多了一行预先排序后同层去重
            if (i != startIndex && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            back(i + 1);

            path.removeLast();
        }
    }
}
