package leetcode.LC_Array;

public class Solution_240 {

    /**
     * 搜索起点 ∈ {左下角 , 右上角}<p>
     * 确保每次比较后可以<strong>排除掉一行或一列</strong>
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int i = row - 1;
        int j = 0;

        while (0 <= i && j < col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                // 排除一行
                i--;
            } else {
                // 排除一列
                j++;
            }
        }

        // 越界则是不存在
        return false;
    }
}
