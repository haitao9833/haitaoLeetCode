package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.Map;

public class Solution_594 {

    /**
     * cnt(X-1) + cnt(X) == 以 X 为最大值的最长和谐子序列的长度
     */
    public int findLHS1(int[] nums) {
        // {X , cnt}
        Map< Integer, Integer > map = new HashMap <>();
        for (int num : nums) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        // max(cnt(X-1) + cnt(X))
        int res = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res , map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

    /**
     * 只需一遍遍历的写法，且需要同时考虑 cnt(X-1) 和 cnt(X+1)
     */
    public int findLHS2(int[] nums) {
        Map< Integer, Integer > map = new HashMap <>();
        int res = 0;
        for (int num : nums) {
            map.put(num , map.getOrDefault(num, 0) + 1);
            res = Math.max(res , map.get(num) + map.getOrDefault(num - 1 , -map.get(num)));
            res = Math.max(res , map.get(num) + map.getOrDefault(num + 1 , -map.get(num)));
        }
        return res;
    }
}
