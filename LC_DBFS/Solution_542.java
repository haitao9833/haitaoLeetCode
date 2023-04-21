package leetcode.LC_DBFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_542 {

    /**
     * 共享信息
     */
    private final int[] dir_x = new int[]{0, 1, 0, -1};
    private final int[] dir_y = new int[]{1, 0, -1, 0};

    /**
     * 定义目标层即所有的 0 元素算<strong>第 0 层</strong><p>
     * 对于其上下左右的 1 累加 1 层
     */
    public int[][] updateMatrix1(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        // step[i][j] == mat[i][j] 处于第几层，所有的 0 保持数组默认值 0 层即可
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] inQ = new boolean[row][col];
        int[][] res = new int[row][col];

        // 目标层（所有的 0）入队
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (matrix[i][j] == 0) {
                    queue.offerLast(new int[]{i , j});
                    inQ[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            // 出队访问 & 更新其下一层的层数且加入队列
            int[] curPos = queue.pollFirst();
            int curX = curPos[0];
            int curY = curPos[1];

            for (int i = 0 ; i < 4 ; i++) {
                int aroundX = curX + dir_x[i];
                int aroundY = curY + dir_y[i];
                if (0 <= aroundX && aroundX < row && 0 <= aroundY && aroundY < col && !inQ[aroundX][aroundY]) {
                    // 上下左右的层 == 当前层 + 1
                    res[aroundX][aroundY] = res[curX][curY] + 1;
                    queue.offerLast(new int[]{aroundX , aroundY});
                    inQ[aroundX][aroundY] = true;
                }
            }
        }
        return res;
    }

    /**
     * dp 动态规划
     * 含义：dp[i][j] 表示 mat[i][j] 到最近的 0 的距离
     * 状态转移：
     *      【划分：mat[i][j] 是 0 还是 1】
     *      dp[i][j] = 0                                                             在 mat[i][j] == 0 的情况下
     *      dp[i][j] = min(dp[i-1][j] , dp[i+1][j] , dp[i][j-1] , dp[i][j+1]) + 1    在 mat[i][j] == 1 的情况下
     *      【项分析一：i 基于 i-1 和 i+1 ，正序逆序都不好弄，即无法从一个方向递推完】
     *      【项分析二：j 基于 j-1 和 j+1 ，正序逆序都不好弄，即无法从一个方向递推完】
     *      【分组递推：】
     *          【 i 基于 i-1 和 j 基于 j-1 一组，即基于上、左，即 i 、j 正序 [0 -> row-1 & col-1]】
     *          【 i 基于 i+1 和 j 基于 j+1 一组，即基于下、右，即 i 、j 逆序 [row-1 & col-1 -> 0]】
     *          【为什么不从 1 或 row-2 开始，见下初始化部分】
     * 遍历顺序：【综上】
     * 初始化：
     *      【第一行 i=0 虽然没有上，且第一个元素和最后一个元素分别没有左右，但其状态也不需要这些不存在的方向递推出来】
     *      【即状态转移方程的本质为 dp[i][j] = min(存在的上、下、左、右) + 1 ，具体实现见下述代码】
     */
    public int[][] updateMatrix2(int[][] matrix) {
        // preliminary
        int row = matrix.length;
        int col = matrix[0].length;

        // 初始化，把 mat[i][j] == 1 的初始化足够大
        // 不能取 Integer.MAX_VALUE ，因为容易 +1 溢出变为 Integer.MIN_VALUE
        // 考虑第一行的 [1 0] 对于该 0 来说，其状态转移会变为 min(0 ， Integer.MAV_VALUE + 1) 溢出变为 Integer.MIN_VALUE
        // 所以以后千万千万别用 Integer.MAX_VALUE ，只用 0x3f3f3f3f
        int[][] dp = new int[row][col];
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 0x3f3f3f3f;
            }
        }

        // 分组递推一，基于上、左
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                // 有上的，才依据上递推
                if (1 <= i) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i - 1][j] + 1);
                }
                // 有左的，才依据左递推
                if (1 <= j) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i][j - 1] + 1);
                }
            }
        }

        // 分组递推二，基于下、右
        for (int i = row - 1 ; i >= 0 ; i--) {
            for (int j = col - 1 ; j >= 0 ; j--) {
                // 有下的，才依据下递推
                if (i <= row - 2) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i + 1][j] + 1);
                }
                // 有右的，才依据右递推
                if (j <= col - 2) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}