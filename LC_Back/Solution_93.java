package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_93 {

    /**
     * 共享信息
     */
    int n;
    char[] ch;
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    /**
     * back(startIndex) == 在 s[startIndex , ... , n-1] 中分割出一个 IP 地址的一个整数<p>
     * isValid(start , end) == 判断 s[start , end] 是否能作为有效的 IP 地址的一个整数
     */
    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        if (n < 4 || 12 < n) {
            return res;
        }
        this.ch = s.toCharArray();
        back(0);
        return res;
    }
    void back(int startIndex) {
        // 递归边界
        if (path.size() == 3) {
            // 判断最后一部分 [startIndex , n-1] 是否有效
            if (startIndex != n && isValid(startIndex , n - 1)) {
                path.add(String.valueOf(ch , startIndex , n - 1 - startIndex + 1));
                res.add(String.join("." , path));
                path.removeLast();
            }
            return;
        }

        // 遍历本层：s[startIndex , ... , n-1]
        // 剪枝优化一：只需要切割 s[startIndex ~ startIndex + 2] 范围即可，超出该范围则必然为 4 位数 > 255
        for (int i = startIndex ; i <= Math.min(startIndex + 2 , n - 1) ; i++) {
            if (isValid(startIndex , i)) {
                path.add(String.valueOf(ch , startIndex , i - startIndex + 1));
                back(i + 1);
                path.removeLast();
            } else {
                // 剪枝优化二：若 s[startIndex , i] 无法作为有效 IP 地址的一个整数
                // 则后续的 s[startIndex , i+1] 、s[startIndex , i+2] 也不可能为有效的整数
                break;
            }
        }
    }
    boolean isValid(int start , int end) {
        // 单字符
        if (start == end) {
            return true;
        }
        // 有前导 0 存在
        if (ch[start] == '0') {
            return false;
        }
        // 超出 [0 , 255] 范围
        return Integer.parseInt(String.valueOf(ch , start , end - start + 1)) <= 255;
    }
}
