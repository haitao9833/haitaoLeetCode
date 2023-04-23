package leetcode.LC_Greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] edge = new int[26];                 // a ~ z = 97 ~ 122
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            edge[chars[i] - 'a'] = i;             // 记录字符最远的边界
        }
        int left = 0;
        int right = 0;
        for (int i = 0 ; i < chars.length ; i++) {
            right = Math.max(right , edge[chars[i] - 'a']); // i 遍历的这段单词片段中，最远的边界
            if (i == right) {                               // i == right 则说明 [left , right] 可以作为一个单词片段了
                res.add(right - left + 1);                  // 因为 [left , right] 内所有的字母的最远边界都不超过 right
                left = i + 1;
            }
        }
        return res;
    }
}
