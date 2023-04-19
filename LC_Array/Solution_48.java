package leetcode.LC_Array;

public class Solution_48 {

    /**
     * matrix[][] == . . . . . . .
     *               . . . . . . .
     *               . . . . . . .
     *               = = = = A . .
     *               . . . . ~ . .
     *               . . . . ~ . .
     * 元素 A 顺时针旋转 90° 后：
     *      ==== 部分的长度成为其的行下标
     *      ~~~~ 部分的长度成为其的列下标
     * 即旋转的本质为 matrix[i][j] --> matrix[j][n - 1 - i] 分两步走：
     *      [i][j] --> [n - 1 - i][j]   这一步即将矩阵倒置
     *      [n-1-i][j] --> [j][n-1-i]   这一步即将矩阵转置
     * 为什么要分两步走 ?
     *      若不分两步走，直接把 [i][j] 放到 [j][n-1-i] 处
     *      则该位置的 [j][n-1-i] 应该放到其的 [j][n-1-i] == [n-1-i][n-1-j] 处，与 [i][j] 没什么关系，继续递归下去不好处理
     *      但对于分开后的两步，第一步将 [i][j] 放到 [n-1-i][j] 后
     *      该位置的 [n-1-i][j] 也应该放到其的 [n-1-i][j] == [i][j] 处，则恰好与 [i][j] 交换一下即可
     *      对于第二步同理，交换一下即可
     */
    public void rotate(int[][] matrix) {
        // preliminary
        int n = matrix.length;

        // 只需倒置上半行即可，则下半行也被倒置了
        for (int i = 0 ; i < n / 2 ; ++i) {
            for (int j = 0 ; j < n ; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // 矩阵转置
        for (int i = 0 ; i < n ; ++i) {
            for (int j = 0 ; j < i ; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}