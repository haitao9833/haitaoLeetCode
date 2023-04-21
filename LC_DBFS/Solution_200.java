package leetcode.LC_DBFS;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_200 {

    /**
     * 共享信息
     */
    int row;
    int col;
    char[][] grid;
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    /**
     * 深搜：dfs(i , j) == 从 grid[i][j] == '1' 出发，<strong>递归访问</strong>其所在的岛屿<p>
     * 广搜：bfs(i , j) == 从 grid[i][j] == '1' 出发，<strong>层序访问</strong>其所在的岛屿
     */
    public int numIslands(char[][] grid) {

        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;

        // 遍历整个 grid[][]
        // 遇到 '1' 则递归 & 层序访问其上下左右的所有相连的 '1'
        int res = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (grid[i][j] == '1') {
                    dfs(i , j);
                    // bfs(i , j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int i , int j) {
        // 递归边界，越界 or 非未访问陆地
        if (!inArea(i, j) || grid[i][j] != '1') {
            return;
        }

        // 标记为已访问
        grid[i][j] = '2';

        // 递归访问上下左右
        dfs(i , j - 1);
        dfs(i , j + 1);
        dfs(i - 1 , j);
        dfs(i + 1 , j);
    }
    private void bfs(int i , int j) {
        Deque<int[]> queue = new LinkedList<>();

        // 标记为 '2' 入队
        this.grid[i][j] = '2';
        queue.offerLast(new int[]{i , j});

        while (!queue.isEmpty()) {
            // 出队访问
            int[] curPos = queue.pollFirst();
            int curX = curPos[0];
            int curY = curPos[1];

            // 入队其上下左右的 '1' 为下一层
            for (int k = 0 ; k < 4 ; k++) {
                int aroundX = curX + dir_x[k];
                int aroundY = curY + dir_y[k];
                if (inArea(aroundX , aroundY) && this.grid[aroundX][aroundY] == '1') {
                    this.grid[aroundX][aroundY] = '2';
                    queue.offerLast(new int[]{aroundX , aroundY});
                }
            }
        }
    }
    private boolean inArea(int i , int j) {
        return 0 <= i && i < row && 0 <= j && j < col;
    }
}
