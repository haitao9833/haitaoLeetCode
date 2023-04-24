package leetcode.LC_Hash;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_49 {

    /**
     * 流<p>
     * 所有字母异位词按字符<strong>字典序排序</strong>后都是相同的字符串<p>
     * 例如 {abc 、acb 、bac...} -> abc
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 流分组后返回 Map<String , List<String>>
        // 用 map.values() 提取所有的值的集合
        return new ArrayList<List<String>>(Arrays.stream(strs).collect(
                Collectors.groupingBy(str -> {
                    char[] ch = str.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);})
                ).values()
        );
    }
}
