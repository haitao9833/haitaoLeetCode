package leetcode.LC_Offer_1;

/**
 * 在 Python 和 Java 等语言中，String 被设计成「不可变」的类型
 *           即无法直接修改 String 的某一位字符，必须要新建一个字符串实现
 * 在 C++ 语言中， string 被设计成「可变」的类型，因此可以在不新建字符串的情况下实现原地修改 O(1)
 */
public class Solution_5 {
    public String replaceSpace(String s) {
        if (s == null) return null;
        StringBuilder res = new StringBuilder();  //选用 StringBuilder 单线程使用，比较快
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
