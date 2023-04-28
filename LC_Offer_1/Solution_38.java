package leetcode.LC_Offer_1;

import java.util.*;

/**
 * 全排列，回溯
 */
public class Solution_38 {
    private ArrayList<String> res;
    private char[] chS;
    private int n;
    private void swap(int i , int j) {
        char temp = chS[i];
        chS[i] = chS[j];
        chS[j] = temp;
    }
    private void backTracking(int index) { // 每层确定好 chS[index] 位的字符，最后一个字符无需处理
        if (index == n - 1) {
            res.add(String.valueOf(chS));
            return;
        }
        Set<Character> st = new HashSet<>();  // 同层去重，无法用 chS[i] == chS[i - 1] ，相同的不一定连续紧挨着
        for (int i = index ; i < n ; i++) {
            if (st.contains(chS[i])) continue;
            st.add(chS[i]);

            swap(index , i);
            backTracking(index + 1);
            swap(index , i);
        }
    }
    public String[] permutation(String s) {
        n = s.length();
        chS = s.toCharArray();
        res = new ArrayList<>();
        backTracking(0);
        return res.toArray(new String[0]);
    }
}

/**
 * 得到字典序中下一个排列
 *           无需去重
 *           无需递归回溯
 *           更快
 * nextPermutation 分析见 LC.LC_Array 31
 */
class Solution_38_02 {
    private void swap(char[] ch , int i , int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    private void reverse(char[] ch , int l , int r) {
        while (l < r) {
            swap(ch , l , r);
            l++;
            r--;
        }
    } // 降序序列进行递增排序只需要交换即可
    private boolean nextPermutation(char[] ch) {
        int i = ch.length - 2;
        while (i >= 0 && ch[i] >= ch[i + 1]) i--;
        if (i == -1) return false;  // 已是字典序最大了

        int k = ch.length - 1;
        while (k > i && ch[i] >= ch[k]) k--;
        swap(ch , i , k);
        reverse(ch, i + 1 , ch.length - 1);
        return true;  // chS[] 已经是下一个排列了
    }
    public String[] permutation(String s) {
        int n = s.length();
        char[] chS = s.toCharArray();
        List<String> res = new ArrayList<>();

        Arrays.sort(chS); // 字典序最小
        do {
            res.add(String.valueOf(chS));
        } while (nextPermutation(chS));

        return res.toArray(new String[0]);
    }
}