package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_554 {

    /**
     * {gap , cnt}<p>
     * <strong>逆向思维，正难则反</strong>：穿过的砖块数 == 行数 - 穿过的间隙数
     */
    public int leastBricks(List<List<Integer>> wall) {

        // 一共几行砖
        int n = wall.size();

        // {gap , cnt}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            int gap = 0;
            for (int len : wall.get(i)) {
                gap += len;
                map.put(gap , map.getOrDefault(gap , 0) + 1);
            }
            // 不可能穿过墙的两边，将墙的最右边间隙移除
            map.remove(gap);
        }


        int maxGap = 0;
        for (int gapLen : map.keySet()) {
            maxGap = Math.max(maxGap , map.get(gapLen));
        }
        return n - maxGap;
    }
}
