package leetcode.LC_DBFS;

import java.util.*;


/**
 * 位压缩，字符 == [0-6] == 位数：
 *      6 5 4 3 2 1 0（二进制从第 0 位起）
 *      G F E D C B A
 */

public class Solution_756 {

    /**
     * 共享信息
     * tower[i][j] 表示金字塔下标 i 行 j 列的字符，金字塔顶层为下标 0 行
     *             金字塔第 k 层有 k 个砖块，即表明第下标 i 行的下标 j 列的范围为 [0 ~ i]
     * triple[i][j] 表示以 i 、j 字符为基底的三元组的尖尖字符可选哪些字符
     *              位压缩，压缩的就是每层递归，有哪些可选元素
     * memo 记录已经构建过的行模式
     *      假设当前层为 i 层，构建完了，加入 memo ，然后继续向上构建 i-1 层，假设构建不到塔尖
     *      则要回溯到 i 层，重新构建 i 层，说明当前 i 层模式无法使得后续构建完金字塔
     *      甚至可能回溯到下面的 i+1 层，重新构建 i+1 层，且由于三元组 allowed[] 的不定性
     *      在重新构建的 i+1 层基础上再重新构建 i 层时，仍有可能会构建出以前出现过的 i 层模式，此时直接返回 false 即可
     */
    int[][] tower;
    int[][] triple;
    Set<Long> memo;

    /**
     * dfs(i , j , pattern) == 构建 tower[i][j] ，后续是否能构建完金字塔
     */
    public boolean pyramidTransition(String bottom , List<String> allowed) {
        // preliminary
        this.memo = new HashSet<>();

        // allowed[] 三元组 --> triple[] 位压缩
        this.triple = new int[7][7];
        for (String tri : allowed) {
            triple[tri.charAt(0) - 'A'][tri.charAt(1) - 'A'] |= (1 << (tri.charAt(2) - 'A'));
        }

        // bottom 为第 level-1 行，列范围为 [0 ~ level-1]
        int level = bottom.length();
        this.tower = new int[level][level];
        int idx = 0;
        for (char c : bottom.toCharArray()) {
            tower[level - 1][idx++] = c - 'A';
        }

        return dfs(level - 2 , 0 , 0);
    }
    private boolean dfs(int i , int j , long pattern) {
        // 递归边界，金字塔最顶层已经构建完，返回 true
        if (i == 0 && j == 1) {
            return true;
        }

        // 当前 i 行已经构建完了，将当前 i 行模式加入 memo ，构建上一行 i-1 行
        if (j == i + 1) {
            if (memo.contains(pattern)) {
                return false;
            }
            memo.add(pattern);
            return dfs(i - 1 , 0 , 0);
        }

        // tower[i][j] 可选字符依赖于基底字符 tower[i+1][j] 和 tower[i+1][j+1]
        int topValid = triple[tower[i + 1][j]][tower[i + 1][j + 1]];
        for (int bit = 0 ; bit < 7 ; bit++) {
            if (((topValid >> bit) & 1) == 1) {
                tower[i][j] = bit;
                if (dfs(i , j + 1 , pattern * 8 + (bit + 1))) {
                    // 字符串 hash ，[A-G] 视为 [1-7] 即 8 进制，详见 Note.java
                    return true;
                }
                // 无需显式回溯，因为每层递归处理一个固定位置 tower[i][j]
                // 且三元组 triple 可以重复使用
                //tower[level][index] = 0;
            }
        }
        return false;
    }
}