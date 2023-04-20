package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_51 {

    /**
     * 共享信息
     * 使用 36 、37 的位压缩技巧，区别在于每层递归遍历一行放置一个皇后
     * 则仅需判断当前行之上的同列、两条斜线的位置是否重复放置过皇后，具体实现：
     *      1、仅需用三个递归、局部变量表示当前的递归行中不能放置皇后的列位置
     *         由于是局部变量，可以直接在递归参数列表中进行位运算，且无需回溯该位运算
     *      2、若当前递归行在列 col 放置了一个皇后后，传给下一递归行的三个变量运算略有不同
     *         表示列的 rota90 直接设置第 col 位为 1 即可
     *         表示左下斜线的 rota45 在设置第 col 位为 1 后，左移一位
     *         表示右下斜线的 rota135 在设置第 col 位为 1 后，右移一位
     */
    int n;
    char[][] chessBoard;
    List<List<String>> res = new ArrayList<>();

    /**
     * back(row) == 在第 row 行的某个有效列位置放入一个皇后
     * 递归深度 == n == 行数
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.chessBoard = new char[n][n];
        for (char[] ch : chessBoard) {
            Arrays.fill(ch , '.');
        }
        back(0 , 0 , 0 , 0);
        return res;
    }
    void back(int row , int rota45 , int rota90 , int rota135) {
        // 递归边界，所有的行都已经放置了皇后，即已经放置出了一种方案
        if (row == n) {
            res.add(Array2List());
            return;
        }

        // & ((1 << n) - 1) == 取最低位的 [0 ~ n-1] 位
        int unValidPos = rota45 | rota90 | rota135;
        int validPos = (~unValidPos) & ((1 << n) - 1);

        // 遍历所有当前 row 行可以放置皇后的列位置 col
        while (validPos != 0) {
            int col = Integer.bitCount((validPos & (-validPos)) - 1);

            chessBoard[row][col] = 'Q';

            // 直接在递归参数列表中进行位运算传给下一层
            // 则本层的三个 rota 参数的位运算无需回溯，可以重复使用
            back(row + 1 ,
                    (rota45 | (1 << col)) << 1 ,
                    (rota90 | (1 << col)) ,
                    (rota135 | (1 << col)) >> 1);

            chessBoard[row][col] = '.';

            validPos &= (validPos - 1);
        }
    }
    public List<String> Array2List() {
        // 每一行作为一个 String
        // 整个棋盘，作为一个 List<String>
        List<String> list = new ArrayList<>();
        for (char[] c : chessBoard) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}