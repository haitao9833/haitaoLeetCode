package leetcode.LC_Bit;

public class Solution_318 {

    /**
     * String -> 二进制 <P>
     * word1 & word2 != 0 即表明 word1 和 word2 有相同的字母 <P>
     * 优化：用 Map 记录 &lt;bits 模式 , len 最大长度&gt; <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;即对每一种 bits 模式仅记录其最大长度 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如对于 "ab" 和 "aaabbb" 两个单词 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;转化为二进制 bits 模式相同，只需记录一个最大长度 6
     */
    public int maxProduct(String[] words) {

        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0 ; i <  n ; i++) {
            nums[i] = convert(words[i]);
        }

        // 遍历每一对单词 word1 和 word2
        int res = 0;
        for (int i = 0 ; i < n - 1 ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res , words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
    private int convert(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            res |= 1 << (c - 'a');
        }
        return res;
    }
}
