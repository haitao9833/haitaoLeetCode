package leetcode.LC_Back;

public class Solution_36 {

    /**
     * 将 9×9 的二维数独看成 3×3 的二维小格：
     *      [0 1 2 , 3 4 5 , 6 7 8] --> [0 , 1 , 2]
     *      box (i/3 , j/3) ==  00 01 02
     *                          10 11 12
     *                          20 21 22
     * 坐标类避免碰撞的 Hash 函数的设计：
     *      1、HashFunc(x , y) = x * rangeY + y   （0 <= y < rangeY）
     *      2、HashFunc(x , y) = x + y * rangeX   （0 <= x < rangeX）
     *      证明 1（2 的证明同理）：
     *          若有任意的两点 (xi , yi) 和 (xj , yj) 映射到同一个 Hash 值，即有：
     *               xi * rangeY + yi == xj * rangeY + yj
     *              (xi - xj) * rangeY == yj - yi
     *          若 xi != xj --> 矛盾，因为任意 -rangeY < yj - yi < rangeY 而不可能 == k * rangeY
     *          若 xi == xj --> 必有 yj == y1 ，即该两点必然为同一点
     */
    public boolean isValidSudoku1(char[][] board) {
        // boolean[i][j] == 第 i 行、列、格，数字 j 是否已经存在
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int boxIdx = i / 3 + (j / 3) * 3;
                    if (row[i][num] || col[j][num] || box[boxIdx][num]) {
                        return false;
                    }
                    row[i][num] = col[j][num] = box[boxIdx][num] = true;
                }
            }
        }
        return true;
    }

    /**
     * 位压缩
     *      方法一：row[i] == col[i] == box[i] == boolean[10]
     *      方法二：row[i] == col[i] == box[i] == 000_000_000_0 ~ 111_111_111_0
     */
    public boolean isValidSudoku2(char[][] board) {
        // int[i] == 第 i 行、列、格，数字 [1-9] 的填入情况
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int boxIdx = i / 3 + (j / 3) * 3;

                    // 拼接第 i 行、列、格的数字 [1-9] 的填入情况
                    // 只有第 i 行、列、格都没有填入过 num 时，二进制 unValidPos 的第 num 位才为 0
                    int unValidPos = row[i] | col[j] | box[boxIdx];
                    if ((unValidPos & (1 << num)) != 0) {
                        return false;
                    }

                    // 设置第 i 行、列、格已经填入了 num
                    row[i] |= (1 << num);
                    col[j] |= (1 << num);
                    box[boxIdx] |= (1 << num);
                }
            }
        }
        return true;
    }
}
