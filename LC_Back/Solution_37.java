package leetcode.LC_Back;

import java.util.ArrayList;
import java.util.List;

public class Solution_37 {

    /**
     * 共享信息
     * space 用于记录所有的需要填入数字的空位 '.'
     * 且使用 36 的位压缩技巧 + lowBit 技巧
     */
    char[][] board;
    int[] row = new int[9];
    int[] col = new int[9];
    int[] box = new int[9];
    List<int[]> space = new ArrayList<>();

    /**
     * boolean back(i) == 在空位 space.get(i) 处尝试填入数字 [1-9] 后，其后续所有空格 '.' 能否有效填满
     * 递归深度 == 原始数独的空位 '.' 个数 == space.size()
     * flipBit(i , j , num) == 将对应行、列、格的数字 num 的填入情况进行翻转：还未填过 0 <-- 翻转 --> 已经填有 1
     */
    public void solveSudoku(char[][] board) {
        // preliminary
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    flipBit(i , j , num);
                } else {
                    space.add(new int[]{i , j});
                }
            }
        }
        this.board = board;
        back(0);
    }
    boolean back(int index) {
        // 递归边界，所有的空位 '.' 都已经填满
        if (index == space.size()) {
            return true;
        }

        // 确定本层需要填入的空位 board[i][j] == '.'
        int[] pos = space.get(index);
        int i = pos[0];
        int j = pos[1];

        // lowBit 技巧
        int unValidPos = row[i] | col[j] | box[i / 3 + (j / 3) * 3];
        int validPos = (~unValidPos) & 0x3fe;
        while (validPos != 0) {
            int num = Integer.bitCount((validPos & (-validPos)) - 1);

            board[i][j] = (char) (num + '0');
            flipBit(i , j , num);

            // 如果返回 true 则表明后续所有的空位 '.' 都填满了
            // 即已经递归到了最深处了，即已经找到了一种填满的方式了
            // 则一路向上返回 true ，不再尝试填入下一个数字看是否还有其他解了
            if (back(index + 1)) {
                return true;
            }

            board[i][j] = '.';
            flipBit(i , j , num);

            validPos &= (validPos - 1);
        }

        // 当前层空位 board[i][j] 填入 [1-9] 都不行，直接返回 false
        // 说明上层填错了，回到上层的 for each num 处尝试填入下一个数字
        // 若当前层为第一次调用 back(0) 说明原始数独的第一个空位处填入 [1-9] 都不行，即表明原始数独无解
        return false;
    }
    public void flipBit(int i , int j , int num) {
        row[i] ^= (1 << num);
        col[j] ^= (1 << num);
        box[i / 3 + (j / 3) * 3] ^= (1 << num);
    }
}
