package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.List;

class Solution_17 {

    /**
     * 共享信息<p>
     * 递归过程中涉及大量的字符串拼接，所以 path 使用 StringBuilder<p>
     * 电话簿 num2String 前面多扩展两个空字符，其每个下标则可对应于相应的数字，即 "abc" 对应于下标 2 也对应于数字按键 2
     */
    char[] ch;
    String[] num2String = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    /**
     * back(i) == 在 nums2String[ ch[i] ] 中选择一个字母<p>
     * <strong>需要 startIndex</strong>：在一个集合里面求组合，用 startIndex 标记本层递归从哪里开始取元素，避免往前取<p>
     * <strong>无需 startIndex</strong>：在多个集合里面求组合，每个集合占一层递归，每个集合在每层递归中从头到尾遍历一遍
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        ch = digits.toCharArray();
        back(0);
        return res;
    }
    public void back(int i) {
        // 递归边界
        if (i == ch.length) {
            res.add(path.toString());
            return;
        }

        // 遍历本层：nums2String[ ch[i] ] 中的所有字母
        char[] letters = num2String[ch[i] - '0'].toCharArray();
        for (char letter : letters) {
            path.append(letter);
            back(i + 1);

            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}
