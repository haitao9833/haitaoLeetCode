package leetcode.LC_DBFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * dfs 懒得写了
 */

public class Solution_130 {

    /**
     * 共享信息
     */
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    /**
     * 逆向思维：从边界的 'O' 出发，<strong>找所有非包围的 'O'</strong>，则剩下的 'O' 即为被包围的
     */
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        Deque<int[]> queue = new LinkedList<>();

        // 四边边界的 'O' 最先入队
        // 且入队过的 'O' 都标记为了 'A' 则不需要显式使用 inQ[] 了
        for (int i = 0 ; i < row ; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                queue.push(new int[]{i , 0});
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = 'A';
                queue.push(new int[]{i , col - 1});
            }
        }
        for (int i = 0 ; i < col ; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                queue.push(new int[]{0 , i});
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = 'A';
                queue.push(new int[]{row - 1 , i});
            }
        }

        while (!queue.isEmpty()) {
            // 出队访问，加入其下一层
            int[] curPos = queue.pollFirst();
            int curX = curPos[0];
            int curY = curPos[1];
            for (int i = 0 ; i < 4 ; i++) {
                int aroundX = curX + dir_x[i];
                int aroundY = curY + dir_y[i];
                if (0 <= aroundX && aroundX < row && 0 <= aroundY && aroundY < col && board[aroundX][aroundY] == 'O') {
                    board[aroundX][aroundY] = 'A';
                    queue.offerLast(new int[]{aroundX , aroundY});
                }
            }
        }

        // 标记为 'A' 的即为非包围的 'O' ，复原为 'O'
        // 未标记为 'A' 的 'O' 即为被包围的的 'O' ，填充为 'X'
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
