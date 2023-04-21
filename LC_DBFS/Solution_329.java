package leetcode.LC_DBFS;

public class Solution_329 {

    /**
     * 共享信息
     */
    int row;
    int col;
    int[][] matrix;
    int[][] memo;
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    /**
     * dfs(i , j) == 计算从 matrix[i][j] 出发的最长递增路径的长度<p>
     * memo[i][j] == 记忆从 matrix[i][j] 出发的最长递增路径的长度<p>
     * 每层确定一个：memo[i][j] = max(上、下、左、右) + 1
     */
    public int longestIncreasingPath(int[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = matrix;
        this.memo = new int[row][col];

        // 遍历整个二维矩阵，计算每个出发点的最长递增路径的长度，取其中最大值
        int res = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                res = Math.max(res , dfs(i , j));
            }
        }
        return res;
    }
    private int dfs(int x , int y) {
        // 已经计算过了，记忆化，直接返回
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // 长度至少是 1 ，即自身
        memo[x][y] = 1;

        // 遍历上下左右
        for (int i = 0 ; i < 4 ; i++) {
            int aroundX = x + dir_x[i];
            int aroundY = y + dir_y[i];
            if (inArea(aroundX , aroundY) && matrix[x][y] < matrix[aroundX][aroundY]) {
                // 遍历完上下左右即可确定一个 memo
                memo[x][y] = Math.max(memo[x][y] , dfs(aroundX , aroundY) + 1);
            }
        }

        return memo[x][y];
    }
    private boolean inArea(int x , int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }
}
