package leetcode.LC_DP;

/**
 * 二叉搜索树：左子树 < 根节点 < 右子树，即中序遍历结果为有序表
 */

public class Solution_96 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示由 i 个节点 [1 , 2 , ... ,i] 能组成的互不相同的二叉搜索树有多少种
     * 状态转移：
     *      【划分一：根节点占 1 个节点，左子树有 j 个节点，右子树有 i-j-1 个节点】
     *      dp[i] += dp[j] * dp[i-j-1]    即累加左右子树的各自可能
     *      【项分析：dp[j] 和 dp[i-j-1] 都是正左方，即 i 必须正序遍历】
     *      【左右子树可以没有节点，即 j 遍历 [0 ~ i-1] ，则 i-j-1 即遍历 [i-1 ~ 0]】
     *      【因为 j 需要遍历 [0 ~ i-1] 则 i 至少从 1 开始遍历】
     * 遍历顺序：【综上，i 正序遍历 [1 -> n] ，内层 j 正序逆序 [0 ~ i-1] 都可以】
     * 初始化：
     *      【谨记一：不放入背包也是一种放法】
     *      【谨记二：空树也是一棵树】
     *      dp[0] = 1
     * 本质：可以想象为一条长 n 个节点的长链，按顺序依次拎起长链的一个节点 [1 -> n] 作为根节点，两边的链（可以为空链）作为子树
     */
    public int numTrees1(int n) {
        // 初始化
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1 ; i <= n ; i++){
            for (int j = 0 ; j <= i - 1 ; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 数学：
     *      卡特兰数：
     *             C(0) = 1 且 C(1) = 1
     *             C(n) = C(0)*C(n-1) + C(1)*C(n-2) + ... + C(n-2)*C(1) + C(n-1)*C(0)
     *             【同上 dp[] 的初始化和状态转移方程】
     *      卡特兰数通项公式：
     *             C(n) = 1/(n+1) * C_{2n}^{n}  等式左边的 C 为组合
     * 求组和的通用遍历公式，详见 62
     */
    public int numTrees2(int n) {
        // preliminary
        long C = 1;

        // 分母   up [n+1 -> 2n]
        // 分子 down [  1 -> n]
        for (int up = n + 1 , down = 1 ; down <= n ; up++ , down++){
            C = C * up / down;
        }
        return (int)(C / (n + 1));
    }
}