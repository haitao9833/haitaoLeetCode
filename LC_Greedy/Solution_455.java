package leetcode.LC_Greedy;

import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);   // 胃口从小到大排序
        Arrays.sort(s);   // 饼干从小到大排序
        int count = 0;
        for (int i = 0 , j = 0; i < s.length && j < g.length; i++) {
            if (g[j] <= s[i]) {  // 贪心，小饼干先喂饱小胃口，大饼干喂饱大胃口
                j++;
                count++;
            }
        }
        return count;
    }
}
