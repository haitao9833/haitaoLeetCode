package leetcode.LC_LCP;

import java.util.*;

public class Solution_LCP_7 {

    /**
     * 共享信息
     */
    int res;
    int lastPlayer;
    Map<Integer , Set<Integer>> graph;

    /**
     * 邻接表 <P>
     * 暴力深搜所有的可能结果
     * @see leetcode.LC_DBFS.Solution_207
     * @see leetcode.LC_DBFS.Solution_210
     * @see leetcode.LC_DBFS.Note
     * @see leetcode.LC_Back.Note
     */
    public int numWays(int n, int[][] relation, int k) {
        this.res = 0;
        this.lastPlayer = n - 1;
        this.graph = new HashMap<>();

        // 邻接表
        for (int[] edge : relation) {
            Set<Integer> nexts = graph.getOrDefault(edge[0] , new HashSet<>());
            nexts.add(edge[1]);
            graph.put(edge[0] , nexts);
        }

        dfs(k , 0);
        return res;
    }
    private void dfs(int step , int curplayer) {
        // 深搜边界
        // step 表示还有多少轮次可以传递
        if (step == 0) {
            if (curplayer == lastPlayer) {
                res++;
            }
            return;
        }

        // 有些玩家可能没有可以传递的下一个玩家
        Set<Integer> nexts = graph.get(curplayer);
        if (nexts == null) {
            return;
        }

        // 遍历本层：所有可以传递的下一玩家
        for (int nextPlayer : nexts) {
            dfs(step - 1 , nextPlayer);
            // 无需回溯，因为无需收集 path 结果
        }
    }

    /**
     * <P> 动态规划
     * <P> 含义：dp[i][j] 表示传了 i 轮次，到达了 j 玩家的方案数
     * <P> 递推公式：
     * <P> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dp[i][j] = Σ dp[i-1][preJ]
     * <P> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其中 preJ 为那些可以直接传递给 j 玩家的玩家
     * <P> 遍历顺序：[i] 依赖 [i-1] ，只需保证 i 正序遍历 [1 -> k] 即可，且要初始化 i=0 的情况
     */
    public int numWays2(int n, int[][] relation, int k) {

        int[][] dp = new int[k + 1][n-1 + 1];

        // 初始化解释
        // 从编号 0 玩家开始传递
        // 其他 dp[0][i] = 0
        dp[0][0] = 1;

        for (int i = 1 ; i <= k ; i++) {
            for (int[] r : relation) {
                int preJ = r[0];
                int j = r[1];
                dp[i][j] += dp[i - 1][preJ];
            }
        }
        return dp[k][n - 1];
    }
}


