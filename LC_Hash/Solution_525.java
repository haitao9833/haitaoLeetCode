package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.Map;

public class Solution_525 {

    /**
     * 遇到 0 --> 前缀和 - 1 <p>
     * 遇到 1 --> 前缀和 + 1 <p>
     * 题型一：{前缀和 , 下标} <p>
     * 求最长连续区间段长度
     */
    public int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;

        // {prefixSum , i}
        // 预先加入 {0 , -1}
        Map<Integer , Integer> map = new HashMap<>(){{this.put(0 , -1);}};

        for (int i = 0 ; i < nums.length ; i++) {
            // 先计算前缀和
            sum += nums[i] == 0 ? -1 : 1;

            // 若之前存在相同的前缀和
            if (map.containsKey(sum)) {
                res = Math.max(res , i - map.get(sum));
            } else {
                map.put(sum , i);
            }
        }
        return res;
    }
}