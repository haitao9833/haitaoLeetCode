package leetcode.LC_Array;

public class Solution_59 {

    /**
     * 每轮 while 填充最外面一圈的元素
     */
    public int[][] generateMatrix(int n) {
        // preliminary
        int[][] res = new int[n][n];

        // 待填充的子数组的左右边界列下标范围 [l , r]
        int l = 0;
        int r = n - 1;

        // 待填充的子数组的上下边界行下标范围 [t , b]
        int t = 0;
        int b = n - 1;

        // res[][] 共 total 个元素，填入 num == [1 , ... , n*n == total]
        int num = 1;
        int total = n * n;

        // 无需时刻检查 num <= total
        // 因为 res[][] 填充完一圈后内部剩下的待填充子数组必然依旧是正方形
        // 不会出现待填充子数组边界范围无效 (l > r) || (t > b) 后还继续填充的情况
        while (num <= total) {
            for (int i = l ; i <= r ; i++) {
                res[t][i] = num++;
            }
            t++;

            for (int i = t ; i <= b ; i++) {
                res[i][r] = num++;
            }
            r--;

            for (int i = r ; i >= l ; i--) {
                res[b][i] = num++;
            }
            b--;

            for (int i = b ; i >= t ; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }
}
