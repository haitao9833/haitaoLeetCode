package leetcode.LC_DBFS;


public class Solution_289 {

    /**
     * 共享信息
     */
    private final int[] dir_x = {0 , 0 , 1 ,-1 , 1 , 1 ,-1 ,-1};
    private final int[] dir_y = {1 ,-1 , 0 , 0 , 1 ,-1 , 1 ,-1};

    /**
     * 规则：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;活细胞 --> 八方含 [2 , 3] 个活细胞 --> 活细胞 --> 否则为死细胞<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;死细胞 --> 八方含 3 个活细胞 --> 复活为活细胞 --> 否则为死细胞<p>
     * <strong>难点在于同步更新</strong>：每个细胞必须依赖其原始的八方的影响<p>
     * 逆向思维：求 board[i][j] <strong>如何影响八方，而不是如何被八分影响</strong><p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;若 board[i][j] == 1 ，给八方 +10<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;低位保持原始 == 个位数 == 原始为活细胞 1 还是死细胞 0<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高位记录更新 == 十位数 == 原始八方有几个活细胞 1
     * @see leetcode.LC_Array.Solution_73
     * @see leetcode.LC_Array.Solution_448
     */
    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;

        // 遍历每一个 board[i][j] ，计算其对八方的影响
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (board[i][j] % 10 == 1) {
                    for (int pos = 0 ; pos < 8 ; pos++) {
                        int x = i + dir_x[pos];
                        int y = j + dir_y[pos];
                        if (0<= x && x < row && 0 <= y && y < col) {
                            board[x][y] += 10;
                        }
                    }
                }
            }
        }

        // 遍历每一个 board[i][j] ，根据高位的十位数（八方影响），判断下一状态
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (board[i][j] == 21 || board[i][j] == 31 || board[i][j] == 30) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
