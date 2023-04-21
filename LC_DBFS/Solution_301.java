package leetcode.LC_DBFS;

import java.util.ArrayList;
import java.util.List;

public class Solution_301 {

    /**
     * 共享信息
     */
    char[] chS;
    StringBuilder path = new StringBuilder();;
    List<String> res = new ArrayList<>();;

    /**
     * dfs(idx , diff , lExtra , rExtra , status) ==
     *           要还是不要 s[idx] ，即加入 path 还是不加入 path
     *           diff 为当前 path 中的 l - r ，即 '(' 比 ')' 多的个数
     *           lExtra 和 rExtra 为还需要删除多少 '(' 和 ')'
     *           status 最为精妙，为 path 的去重，即 LC_Back 中的技巧，例如对于 (() 来说：
     *                  path 在当前递归层中选择了第一个 '(' ，则下一递归层中还可以继续选择第二个 '(' ，也可以不选择
     *                  反正最后会递归出一个有效方案，即第一个 '(' 搭配第三个 ')'
     *                  然后回溯到 path 在当前层未选第一个 '(' ，则下一递归层中也不能选择第二个 '(' ，
     *                  因为若选了，则最后也会递归出一个有效但重复的方案，即第二个 '(' 搭配第三个 ')'
     *                  见 LC_Back.Note.java 去重的本质 == 对于 path 的某个 idx 位不能选择重复的元素
     *                  非连续的 '()(' 则不会受影响，但不知道如何严格证明
     */
    public List<String> removeInvalidParentheses(String s) {
        // 双指针遍历计算多余的 '(' 和 ')'
        int lExtra = 0;
        int rExtra = 0;
        this.chS = s.toCharArray();
        for (char c : chS) {
            if (c == '(') {
                // 多余的 '('
                lExtra++;
            } else if (c == ')') {
                if (lExtra == 0) {
                    // 多余的 ')'
                    rExtra++;
                } else {
                    // 一个 '(' 和一个 ')' 配对
                    lExtra--;
                }
            }
        }
        if (lExtra == 0 && rExtra == 0) {
            return List.of(s);
        }

        dfs(0 , 0 , 0 , lExtra , rExtra);
        return res;
    }
    private void dfs (int idx , int diff , int status , int lExtra , int rExtra) {
        // 递归边界，处理完整个 s 了，看 path 是否合法
        if (idx == chS.length) {
            if (diff == 0 && lExtra == 0 && rExtra == 0) {
                res.add(path.toString());
            }
            return;
        }

        char c = chS[idx];

        if (c == '(') {
            // status !=1 就能选，说明前面的 '(' 选了，或者前面是 ')' 或字母
            if (status != 1) {
                path.append(c);
                dfs(idx + 1 , diff + 1 , 0 , lExtra , rExtra);
                path.deleteCharAt(path.length() - 1);
            }
            // 不选，设置 status = 1
            if (lExtra > 0) {
                dfs(idx + 1 , diff ,1 , lExtra - 1 , rExtra);
            }
        } else if (c == ')') {
            //  status !=2 就能选，说明前面的 ')' 选了，或者前面是 '(' 或字母
            if (diff > 0 && status != 2) {
                path.append(c);
                dfs(idx + 1, diff - 1 , 0 , lExtra , rExtra);
                path.deleteCharAt(path.length() - 1);
            }
            // 不选，设置 status = 2
            if (rExtra > 0) {
                dfs(idx + 1, diff , 2 , lExtra , rExtra-1);
            }
        } else {
            // 字母都可以直接选择
            path.append(c);
            dfs(idx + 1 , diff , 0 , lExtra , rExtra);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> list = new Solution_301().removeInvalidParentheses("()())(");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
