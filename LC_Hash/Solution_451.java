package leetcode.LC_Hash;

import java.util.*;

public class Solution_451 {

    /**
     * 桶排序<p>
     * {X , cnt} 倒置为 {cnt , {X1 , X2 , ...}}
     */
    public String frequencySort1(String s) {
        // 记录最大的 cnt 用于建桶
        int maxFreq = 0;

        // {X , cnt}
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch , map.getOrDefault(ch , 0) + 1);
            maxFreq = Math.max(maxFreq , map.get(ch));
        }

        // 倒置为 {cnt , {X1 , X2 , ...}}
        // 其中 {X1 , X2 , ...} 用 StringBuffer 存
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (var entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new StringBuffer();
            }
            buckets[entry.getValue()].append(entry.getKey());
        }

        // 倒序拼接桶 {cnt , {X1 , X2 , ...}}
        StringBuffer res = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            if (bucket != null) {
                for (int j = 0; j < bucket.length(); j++) {
                    res.append(String.valueOf(bucket.charAt(j)).repeat(i));
                }
            }
        }
        return res.toString();
    }

    /**
     * 直接排序 {X , cnt}
     */
    public String frequencySort2(String s) {
        // 建 ASCII 码值数组
        int[][] buckets = new int[128][2];
        for (int i = 0; i < 128; i++) {
            buckets[i][0] = i;
        }
        for (char c : s.toCharArray()) {
            buckets[c][1]++;
        }

        // 排序 {X , cnt}
        Arrays.sort(buckets, (a, b)-> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            res.append(String.valueOf((char)buckets[i][0]).repeat(buckets[i][1]));
        }
        return res.toString();
    }
}