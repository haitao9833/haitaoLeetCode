package leetcode.LC_DBFS;

public class Solution_79 {

    /**
     * 共享信息 <P>
     * vis[i][j] 避免重复使用同一个字符 board[i][j]
     */
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};
    private int row;
    private int col;
    private char[][] board;
    private boolean[][] vis;
    private int n;
    private char[] word;

    /**
     * 找到了就返回 true ，不再尝试下一个可能的方案 <P>
     * 没找到，则返回上层前需要回溯 vis[][] == false <P>
     * dfs(i , j , idx) == 从 board[i][j] 开始搜索 word[idx , n-1] ，能够找全则返回 true
     * @see leetcode.LC_Back.Note
     */
    public boolean exist(char[][] board, String word) {

        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        this.n = word.length();
        this.word = word.toCharArray();
        this.vis = new boolean[row][col];

        // 顶级优化 == 正难则反，逆序思维 == 选择搜索入口更少的顺序搜索
        // 没有这一段，时间复杂度会高 140 ~ 160 多倍
        int positive = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (board[i][j] == this.word[0]) {
                    positive++;
                } else if (board[i][j] == this.word[n - 1]) {
                    positive--;
                }
            }
        }
        if (positive > 0) {
            char[] temp = new char[n];
            for (int i = 0 ; i < n ; i++) {
                temp[i] = this.word[n - 1 - i];
            }
            this.word = temp;
        }

        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (dfs(i , j , 0)) {
                    // 找到了就返回 true ，不再尝试下一个可能的方案
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int x , int y , int index) {
        // 递归边界，最后一个字符
        if (index == n - 1) {
            return board[x][y] == word[index];
        }

        // 当前层 board[i][j] 找到了 word[idx]
        if (board[x][y] == word[index]) {

            vis[x][y] = true;

            // 遍历上、下、左、右找下一个字符 word[idx+1]
            for (int i = 0 ; i < 4 ; i++) {
                int aroundX = x + dir_x[i];
                int aroundY = y + dir_y[i];
                if (inArea(aroundX , aroundY) && !vis[aroundX][aroundY]) {
                    if (dfs(aroundX , aroundY, index + 1)) {
                        // 找到了就返回 true ，不再尝试下一个可能的方案
                        return true;
                    }
                }
            }

            // 回溯
            vis[x][y] = false;
        }

        return false;
    }
    private boolean inArea(int x , int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }
}
