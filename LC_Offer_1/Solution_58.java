package leetcode.LC_Offer_1;

/**
 * Offer-58-Ⅰ 见 LC.LC_String 151
 * API 调用方法：return s.substring(n , s.length()) + s.substring(0 , n);
 */
public class Solution_58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n ; i < n + s.length() ; i++) res.append(s.charAt(i % s.length()));
        /**
         * 取余，很酷，很骚，先把 s[n , len-1] 后段添加了，再添加 s[0 , n-1] 前段
         */
        return res.toString();
    }
}

/**
 * 同 LC.LC_Array 189
 * 局部反转 + 整体反转
 *       <-<——
 *       ->——>
 *       <——<-
 * 反转小部分块和大部分块前后顺序的解题套路
 */
class Solution_58_02 {
    public String reverseLeftWords(String s , int n) {
        char[] ch = s.toCharArray();
        reverse(ch ,0 , n - 1);
        reverse(ch , n , ch.length - 1);
        reverse(ch ,0 ,ch.length - 1);
        return new String(ch);
    }
    private void reverse(char[] ch , int l , int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
    }
}