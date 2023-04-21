package leetcode.LC_DBFS;

import java.util.Arrays;

public class Solution_576 {

    /**
     * 共享信息
     */
    int m;
    int n;
    int[][][] memo;
    private final int MOD = 1000000007;
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;

        // 从 (x , y) 出发且最多移动 maxMove 次，可以将球移出边界的路径数量
        this.memo = new int[m][n][maxMove + 1];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                Arrays.fill(memo[i][j] , -1);
            }
        }

        return dfs(startRow , startColumn , maxMove);
    }
    private int dfs(int x , int y , int move) {
        // 越界即找到 1 条路径
        if (x < 0 || m <= x || y < 0 || n <= y) {
            return 1;
        }
        // 走不下去了
        if (move == 0) {
            return 0;
        }
        // 记忆化
        if (memo[x][y][move] != -1) {
            return memo[x][y][move];
        }

        // 剪枝，从当前 (x , y) 怎么走都走不出界
        if (x - move >= 0 && x + move < m && y - move >= 0 && y + move < n) {
            return 0;
        }

        int paths = 0;
        for (int i = 0 ; i < 4 ; i++) {
            int aroundX = x + dir_x[i];
            int aroundY = y + dir_y[i];
            paths = (paths + dfs(aroundX , aroundY , move - 1)) % MOD;
        }
        memo[x][y][move] = paths;

        return paths;
    }
}
