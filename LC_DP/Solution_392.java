package leetcode.LC_DP;

public class Solution_392 {

    /**
     * 贪心双指针：
     *      指针 i 遍历 s
     *      指针 j 遍历 t
     *      若 s[i] == t[j] 则指针 i 、j 后移
     *      若 s[i] != t[j] 则指针 j 后移
     *      判断最后 i 能否遍历完整个 s
     * 理解贪心性：
     *      每次需要匹配字符 s[i] 时，假设该字符在 t 中的下标 x1 、x2 都出现，且下标 0 <= x1 < x2 < len(t)
     *      那么贪心取更靠前的 t[x1] 匹配 s[i] 是最优解，因为下标 x2 之后能取到的字符，下标 x1 之后也都能取到
     *      但下标 x1 之后到 x2 之前范围内的字符，下标 x2 之后取不到了
     *      若由 t[x2] 去匹配 s[i] 则相当于减小了匹配成功 s 的可能性
     */
    public boolean isSubsequence1(String s, String t) {
        // preliminary
        int n = s.length();
        int m = t.length();
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        // 保证两个指针 i 、j 不越界
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (chS[i] == chT[j++]) {
                i++;
            }
        }
        return i == n;
    }

    /**
     * dp 动态规划
     * 进阶问法：
     *      上述贪心双指针是无记忆性的算法
     *      如果有大量的 s1 、s2 、... 、sn 需要依次检查是否为 t 的子序列
     *      则对每个 si ，都要用一个指针 j 从头到尾、逐个字符地遍历整个 t
     *      花费大量时间于在 t 中找到最靠前匹配 si[i] 的字符
     *      若能进行恰当的预处理，则 j 的依次遍历寻找 --> 可以转变成 --> 直接精准跳跃到需要的最靠前的字符下标处
     * 含义：
     *      dp[i][j] 表示字符串 t 从下标 i 开始往后的 t[i ~ m-1] 范围内，字符 j 第一次出现（最靠前）的下标位置
     *      【令字符串 t 的长度为 m == len(t) 】
     *      【且依据题意，字符串 s 和 t 仅由小写字母 [a-z] 组成，小写字母 [a-z] 可以通过 - 'a' 操作转换为 [0-25]】
     * 状态转移：
     *      【划分：开始字符 t[i] 是不是正好为字符 j 】
     *      dp[i][j] = i              在 t[i] == j 的情况下
     *      dp[i][j] = dp[i+1][j]     在 t[i] != j 的情况下
     *      【项分析：dp[i+1][j] 正下方】
     * 遍历顺序：
     *      【需要保证正下方已经更新计算过了】
     *      【第一维度 i 必须逆序遍历，且 i=m-1 最后一行无正下方行，必须手动初始化，即 i 逆序遍历 [m-2 -> 0]】
     *      【第二维度 j 在正下方 i+1 行更新计算后，正序逆序无所谓，范围从 [a ~ z] == [0 ~ 25]】
     *      策略一：先 i 逆序遍历，再 j 正序或逆序遍历
     *      策略二：先 j 正序或逆序遍历，再 i 逆序遍历
     * 初始化：
     *      【手动初始化无下方行的最后一行 i=m-1 的各种情况】
     *      dp[m-1][j] = m-1  当 t[m-1] == j 时
     *      dp[m-1][j] = m    当 t[m-1] != j 时
     *      【此时 t[m-1] 已经是 t 的最后一个字符，若 t[m-1] != j ，则后续也不可能出现字符 j 了，因为没后续了】
     *      【所以初始化为一个无效值 m ，表示无效的 t 下标范围，也表示字符串 t 从下标 m-1 开始往后不存在 j 字符了】
     *      【功效等同于背包问题中求背包必须装满的情况下价值最大最小问题，初始化一个 ±∞ 表示装不满的无效状态】
     *      【该无效值会一直通过状态转移方程向上层的行传递，直到遇到有 t[i] = j 的情况下才将 dp[i][j] 更新为 i】
     *      【即理解语义 dp[i][j] == m 可以判断出字符串 t 从下标 i 开始往后，不存在 j 字符了】
     * 进阶性：
     *      对于大量的 s ，可以利用 dp[][] 数组，每次在 t 中 O(1) 地跳跃到需要的最靠前的 s[i] 处
     */
    public boolean isSubsequence2(String s, String t) {
        // preliminary ，依题意，字符串 s 和 t 有可能为空字符串，需要特殊化处理
        // 避免后续 dp[][] 数组初始化出现维度长为 0 的情况
        int n = s.length();
        if (n == 0) {
            return true;
        }
        int m = t.length();
        if (m == 0 ) {
            return false;
        }
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        // 预处理字符串 t
        int[][] dp = new int[m][26];
        for (int j = 0 ; j < 26 ; j++) {
            if (chT[m - 1] == j + 'a') {
                dp[m - 1][j] = m - 1;
            } else {
                dp[m - 1][j] = m;
            }
        }
        for (int i = m - 2 ; i >= 0 ; i--) {
            for (int j = 0 ; j < 26 ; j++) {
                if (chT[i] == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        // 字符串 t 的指针可以依据 dp[][] 精准跳跃
        // 字符串 s 的指针 i 则需要逐个字符依次遍历
        int p = 0;
        for (int i = 0 ; i < n ; i++) {
            // t[p , m-1] 无 s[i] 字符，直接返回 false ，即 s 肯定不是 t 的子序列
            if (dp[p][chS[i] - 'a'] == m) {
                return false;
            }

            // 指针 p 跳到 dp[p][chS[i] - 'a'] 处匹配到 s[i]
            // 则从其 +1 下标处开始准备匹配下一轮循环的 s[i+1] 字符
            p = dp[p][chS[i] - 'a'] + 1;

            // 已经跳跃完整个 t 了，但 s 还未遍历完，则返回 false ，即 s 肯定不是 t 的子序列
            if (p == m && i != n - 1) {
                return false;
            }
        }
        return true;
    }
}
