package leetcode.LC_Array;

import java.util.Arrays;

public class Solution_73 {

    /**
     * 类似于 289 的生命游戏，同步更新，新状态不能覆盖旧状态
     * 标记法设计：<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;若 matrix[i][j] 为 0<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;则标记其所在行的行首 matrix[i][0] 为 0 表明该行需要全置为 0<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;且标记其所在列的列头 matrix[0][j] 为 0 表明该列需要全置为 0<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由上可知，所有元素的标记都在第一行、第一列，所以还要预先对第一行、第一列保存旧状态
     * @see leetcode.LC_DBFS.Solution_289
     */
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        // 预先保存第一行、第一列的旧状态
        // 即第一行、第一列是否有 0 是否需要全置为 0
        // 只需用两个 boolean 即可
        boolean headRow = false;
        boolean headCol = false;
        for (int j = 0 ; j < col ; j++) {
            if (matrix[0][j] == 0) {
                headRow = true;
                break;
            }
        }
        for (int i = 0 ; i < row ; i++) {
            if (matrix[i][0] == 0) {
                headCol = true;
                break;
            }
        }

        // 处理其他元素，并标记到第一行、第一列中
        for (int i = 1 ; i < row ; i++) {
            for (int j = 1 ; j < col ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 依据标记处理
        // 但先不要处理第一行、第一列
        for (int j = 1 ; j < col ; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1 ; i < row ; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1 ; i < row ; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i] , 0);
            }
        }

        // 最后处理第一行、第一列
        if (headRow) {
            Arrays.fill(matrix[0] , 0);
        }
        if (headCol) {
            for (int i = 0 ; i < row ; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
