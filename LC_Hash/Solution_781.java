package leetcode.LC_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution_781 {

    /**
     * 要求兔子数量最少：<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1 ~ x + 1] 只回答了 x 的兔子算 x + 1 只<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回答 x 的兔子和回答 y 的兔子颜色必然不相同（x != y）
     */
    public int numRabbits(int[] answers) {
        // {X , cnt}
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers) {
            map.put(x , map.getOrDefault(x , 0) + 1);
        }

        int res = 0;
        for (var entry : map.entrySet()) {
            int x = entry.getKey();
            int cnt = entry.getValue();
            // 求 cnt / (x+1) 的向上取整
            res += (cnt + x) / (x + 1) * (x + 1);
        }
        return res;
    }

    /**
     * 预先排序，遇到回答 x 的兔子，则可跳过其后连续回答 x 的 x 只兔子
     */
    public int numRabbits2(int[] answers) {

        int n = answers.length;

        Arrays.sort(answers);

        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            res += answers[i] + 1;
            int x = answers[i];

            // 跳过其后连续回答 x 的 x 只兔子
            while (i + 1 < n && answers[i] == answers[i + 1] && x-- != 0) {
                i++;
            }
        }
        return res;
    }
}
