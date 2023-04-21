package leetcode.LC_DBFS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 规则：
 *     click 前：
 *               M == 未挖的地雷（点击的范围）
 *               E == 未挖的方块（点击的范围）
 *               X == 已挖的地雷
 *               B == 已挖的方块（且八方无雷）
 *           [1-8] == 已挖的方块（且八方有雷）
 *
 *     click 后：
 *          board[x][y] == M  修改为 X ，且游戏结束
 *          board[x][y] == E  八方有雷，修改为 [1-8]
 *                            八方无雷，修改为 B 且继续揭露八方
 */

public class Solution_529 {

    /**
     * 共享信息
     */
    int row;
    int col;
    char[][] board;
    private final int[] dir_x = {0 , 0 , 1 ,-1 , 1 , 1 ,-1 ,-1};
    private final int[] dir_y = {1 ,-1 , 0 , 0 , 1 ,-1 , 1 ,-1};

    public char[][] updateBoard(char[][] board , int[] click) {
        // preliminary
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        int x = click[0];
        int y = click[1];

        // 点击到 M 还是 E
        if (this.board[x][y] == 'M') {
            this.board[x][y] = 'X';
        } else {
            click(x , y);
        }
        return this.board;
    }
    void click(int x , int y) {

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] inQ = new boolean[row][col];

        // 待访问节点入队
        queue.offerLast(new int[]{x , y});
        inQ[x][y] = true;

        while (!queue.isEmpty()) {

            int[] curPos = queue.pollFirst();
            int curX = curPos[0];
            int curY = curPos[1];

            // 统计八方雷
            int bombCnt = 0;
            for (int i = 0 ; i < 8 ; i++) {
                int aroundX = curX + dir_x[i];
                int aroundY = curY + dir_y[i];
                if (inArea(aroundX , aroundY)) {
                    bombCnt += board[aroundX][aroundY] == 'M' ? 1 : 0;
                }
            }

            if (bombCnt != 0) {
                // 八方有雷
                board[curX][curY] = (char)(bombCnt + '0');
            } else {
                // 八方无雷，则八方是 E 、B 、[1-8] ，将所有的 E 入队待揭露，且该 E 揭露后也只会是 B 或 [1-8]
                board[curX][curY] = 'B';
                for (int i = 0 ; i < 8 ; i++) {
                    int aroundX = curX + dir_x[i];
                    int aroundY = curY + dir_y[i];
                    if (inArea(aroundX , aroundY) && !inQ[aroundX][aroundY] && board[aroundX][aroundY] == 'E') {
                        queue.offerLast(new int[]{aroundX , aroundY});
                        inQ[aroundX][aroundY] = true;
                    }
                }
            }
        }
    }
    public boolean inArea(int aroundX , int aroundY) {
        return 0 <= aroundX && aroundX < row && 0 <= aroundY && aroundY < col;
    }
}
