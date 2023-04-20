package leetcode.LC_Back;

public class Solution_52 {

    /**
     * 画出递归多叉树，计算所有能从第 0 层到第 n-1 层的路径条数，根节点为 -1 层：
     *      第 n-1 层的叶子节点返回 1
     *      非 n-1 层的叶子节点返回 0
     *      分支节点则累加所有分支返回
     *      即每个 n-1 层的叶子节点返回的 1 都会累加到根节点处
     */
    static int n;
    static char[][] chessBoard;
    public static int totalNQueens(int n) {
        Solution_52.n = n;
        return back(0 , 0 , 0 , 0);
    }
    public static int back(int row , int rota45 , int rota90 , int rota135) {
        // 递归边界，叶子节点返回 1
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        int unValidPos = rota45 | rota90 | rota135;
        int validPos = (~unValidPos) & ((1 << n) - 1);
        while (validPos != 0) {
            int col = Integer.bitCount((validPos & (-validPos)) - 1);
            // 累加所有分支节点返回的值
            cnt += back(row + 1 ,
                    (rota45 | (1 << col)) << 1 ,
                    (rota90 | (1 << col)) ,
                    (rota135 | (1 << col)) >> 1);
            validPos &= (validPos - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(Solution_52.totalNQueens(6));
    }
}
