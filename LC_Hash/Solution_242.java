package leetcode.LC_Hash;

public class Solution_242 {

    /**
     * 进阶问题<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;若 s 和 t 中含有 Unicode 字符<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;把数组 pattern[] 改为 HashMap&lt;Character, Integer&gt; 即可
     */
    public boolean isAnagram(String s, String t) {
        // 特判
        if (s.length()  != t.length()) {
            return false;
        }

        // 记录 s 的字符模式 pattern
        int[] pattern = new int[26];
        for (char c : s.toCharArray()) {
            pattern[c - 'a']++;
        }

        // 判断 t 的字符模式是否与 pattern 完全相同
        for (char c : t.toCharArray()) {
            if (--pattern[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
