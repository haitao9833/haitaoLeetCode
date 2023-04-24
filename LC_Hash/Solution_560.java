package leetcode.LC_Hash;

import leetcode.LC_Tree.Solution_437;

import java.util.HashMap;
import java.util.Map;

public class Solution_560 {

    /**
     * 题型二：{前缀和 , 个数} <p>
     * 求和为 k 的连续子区间的个数
     * @see Solution_437
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;

        // {prefixSum , cnt}
        // 预先加入 {0 , 1}
        Map<Integer , Integer> map = new HashMap<>(){{put(0 , 1);}};

        for (int num : nums) {
            // 计算前缀和
            sum += num;

            // 先累加
            res += map.getOrDefault(sum - k , 0);

            // 再更新 + 1
            map.put(sum , map.getOrDefault(sum , 0 ) + 1);
        }
        return res;
    }
}
