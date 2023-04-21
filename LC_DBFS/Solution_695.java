package leetcode.LC_DBFS;

public class Solution_695 {

    /**
     * 共享信息
     */
    int row;
    int col;
    int[][] grid;

    /**
     * dfs(i , j) == 从 grid[i][j] == 1 出发，<strong>递归计算</strong>其所在的岛屿的面积
     */
    public int maxAreaOfIsland(int[][] grid) {

        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;

        int res = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res , dfs(i , j));
                }
            }
        }
        return res;
    }
    private int dfs(int i , int j) {
        // 递归边界，越界 or 非未访问陆地
        if (!inArea(i, j) || grid[i][j] != 1) {
            return 0;
        }

        // 标记为已访问
        grid[i][j] = 2;

        // 累加上下左右的面积
        return 1 + dfs(i , j - 1) + dfs(i , j + 1) + dfs(i - 1 , j) + dfs(i + 1 , j);
    }
    private boolean inArea(int i , int j) {
        return 0 <= i && i < row && 0 <= j && j < col;
    }
}
