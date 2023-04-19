package leetcode.LC_Array;

public class Solution_74 {

    /**
     * 坐标 Hash <p>
     * 将二维数组视为一维有序数组
     */
    public boolean searchMatrix1(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int l = 0;
        int r = row * col - 1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);

            // 坐标 Hash
            int x = matrix[mid / col][mid % col];

            if (x == target) {
                return true;
            } else if (x < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
