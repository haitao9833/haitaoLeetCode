package leetcode.LC_DBFS;

/**
 * 核心思路：每当从一个陆地 1 走向越界、海洋，就周长 + 1
 */

public class Solution_463 {

    /**
     * 共享信息
     */
    int row;
    int col;
    int[][] grid;

    /**
     * dfs(i , j) == 从 grid[i][j] == 1 出发，<strong>递归计算</strong>其所在的岛屿的周长<p>
     * 核心思想：每当从一个 '1' 走向越界或海洋，就周长 + 1<p>
     * 深搜更加简洁
     */
    public int islandPerimeter(int[][] grid) {

        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 1) {
                    // 题目保证仅有一个岛屿
                    // 即从任意一个 1 出发都能递归访问完整个岛屿
                    return dfs(i , j);
                }
            }
        }
        return 0;
    }
    private int dfs(int i , int j) {
        // 递归边界一，每当从一个 1 走向越界、海洋，就周长 + 1
        if (!inArea(i, j) || grid[i][j] == 0) {
            return 1;
        }
        // 递归边界二，不重复访问，即不重复计算周长
        if (grid[i][j] == 2) {
            return 0;
        }

        // 标记为已访问
        grid[i][j] = 2;

        // 累加上下左右的周长
        return dfs(i , j - 1) + dfs(i , j + 1) + dfs(i - 1 , j) + dfs(i + 1 , j);
    }
    private boolean inArea(int i , int j) {
        return 0 <= i && i < row && 0 <= j && j < col;
    }
}
