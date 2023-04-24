package leetcode.LC_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_438 {

    /**
     * 在 s 中滑动<strong>固定长度</strong>的窗口 windows<p>
     * 每滑动一次就比较一次 Arrays.equals(pattern , windows)
     */
    public List<Integer> findAnagrams1(String s , String p) {

        int n = s.length();
        int m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }

        // pattern 为 p 的字符组成模式
        // windows 为 s 中固定大小的滑动区间，先取 s[0 , m-1]
        // 比较两个数组是否完全相等
        int[] pattern = new int[26];
        int[] windows = new int[26];
        for (int i = 0 ; i < m ; i++) {
            pattern[p.charAt(i) - 'a']++;
            windows[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pattern , windows)) {
            res.add(0);
        }

        // 在 s 中滑动 windows
        for (int i = m ; i < n ; i++) {
            windows[s.charAt(i) - 'a']++;
            windows[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(pattern , windows)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }

    /**
     * 在 s 中滑动<strong>非固定长度</strong>的窗口 [l , r]（但还是需要一个 windows[] 记录 [l , r] 区间的模式）<p>
     * 需保证 [l , r] 为 p 的<strong>严格子集</strong><p>
     * 若长度刚好 len([l , r]) == len(p) 则得到一个结果
     */
    public List<Integer> findAnagrams2(String s, String p) {

        int n = s.length();
        int m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }

        int[] pattern = new int[26];
        int[] windows = new int[26];
        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        int l = 0;
        for (int r = 0 ; r < n ; r++) {
            // 计入 s[r] 的 ch
            int ch = s.charAt(r) - 'a';
            windows[ch]++;

            // 若 [l , r] 非 p 的子集，则不断收缩 l
            // 最坏情况 l == r + 1 此时 [l , r] 代表无效空串
            while (windows[ch] > pattern[ch]) {
                windows[s.charAt(l) - 'a']--;
                l++;
            }

            // 若长度刚好为 p 的长度
            if (r - l + 1 == m) {
                res.add(l);
            }
        }
        return res;
    }
}