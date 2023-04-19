package leetcode.LC_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_229 {

    /**
     * 摩尔投票的扩展，严格证明见宫水三叶题解
     * <P> 出现次数 > n/k （向下取整）的元素最多只有 k-1 个，但也可能一个都没有，因为题意并不保证
     * <P> 但若存在，一定会出现在算法中的 candidate 变量中，但 candidate 变量中的也不一定全是，还需验证
     */
    public List<Integer> majorityElement(int[] nums) {
        // vote == cnt
        int candidate1 = 0;
        int candidate2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        // vote == 0 时的 candidate 所指是无效的
        for (int num : nums) {
            // 比 169 的 if...else 顺序上更加严格
            // 必须先在有效的 candidate 中找是否有 == num 的
            // 如果没有，才找是否还有无效的 candidate 坑待填入
            if (vote1 > 0 && num == candidate1) {
                vote1++;
            } else if (vote2 > 0 && num == candidate2) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1 = 1;
            } else if (vote2 == 0) {
                candidate2 = num;
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }

        // vote == 0 的 candidate 必定无意义
        // vote != 0 的 candidate 却也不一定有意义，因为题意不保证
        // 例如 [3 3 2] 中找出现次数 > n/3 == 1 的元素，元素 2 占 candidate 坑但无效
        // 所以需要再遍历一遍，看 candidate 坑内元素是否真的有效
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == candidate1) {
                cnt1++;
            }
            if (vote2 > 0 && num == candidate2) {
                cnt2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (cnt2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
