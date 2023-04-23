package leetcode.LC_Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 贪心策略：优先移除数量少的
 */
public class Solution_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer , Integer> num2cnt = new HashMap<>();
        for (int num : arr) num2cnt.put(num , num2cnt.getOrDefault(num , 0)  + 1);

        int res = num2cnt.size();
        int[] cnt = new int[res];
        int index = 0;
        for (Integer key : num2cnt.keySet()) cnt[index++] = num2cnt.get(key);
        Arrays.sort(cnt); // 对次数排序，并不关心对应的 num

        for (int c : cnt) {
            if (k >= c) {
                k -= c;
                res--;
            } else break;
        }
        return res;
    }
}
