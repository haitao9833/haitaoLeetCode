package leetcode.LC_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {

    /**
     * 每轮 while 读取掉最外面一圈的元素
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // preliminary
        int m = matrix.length;
        int n = matrix[0].length;

        // 待读取的子数组的左右边界列下标范围 [l , r]
        int l = 0;
        int r = n - 1;

        // 待读取的子数组的上下边界行下标范围 [t , b]
        int t = 0;
        int b = m - 1;

        // matrix[][] 共 total 个元素，读取入 res 中
        int total = m * n;
        List<Integer> res = new ArrayList<>();

        // 必须时刻检查 res.size() < total
        // 因为 matrix[][] 的 n 和 m 大小不定，则读取完最外面一圈后，内部剩下的待读取子数组形状不定
        // 例如若内部待读取的子数组形状为一行或一列，读取完一行 t++ 后则无需再读取
        // 即此时剩下的待读取子数组边界范围已经无效了 (l > r) || (t > b)
        while (res.size() < total) {
            for (int i = l ; i <= r && res.size() < total ; i++) {
                res.add(matrix[t][i]);
            }
            t++;

            for (int i = t ; i <= b && res.size() < total ; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            for (int i = r ; i >= l && res.size() < total ; i--) {
                res.add(matrix[b][i]);
            }
            b--;

            for (int i = b ; i >= t && res.size() < total ; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
