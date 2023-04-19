package leetcode.LC_Array;

import leetcode.LC_50.ListNode;
import leetcode.LC_Linked.Solution_23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_378 {

    /**
     * <strong>优先队列 + 多路归并：出堆一个元素，就入堆其相邻的元素</strong>
     * @see Solution_23#mergeKLists4(ListNode[])
     */
    public int kthSmallest1(int[][] matrix , int k) {

        int row = matrix.length;
        int col = matrix[0].length;

        // 小根堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(pos -> matrix[pos[0]][pos[1]])
        );

        // 第一列元素入堆
        // 第一列元素为每行中最小的元素
        for (int i = 0 ; i < row ; i++) {
            minHeap.offer(new int[]{i , 0});
        }

        // 出堆 k-1 次 ==> 堆顶就为第 k 小的了
        for (int i = 0 ; i <= k - 2 ; i++) {
            // 出堆当前最小
            int[] min = minHeap.poll();
            // 入堆其右边的元素
            if (min[1] != col - 1) {
                minHeap.offer(new int[]{min[0] , min[1] + 1});
            }
        }

        return matrix[minHeap.peek()[0]][minHeap.peek()[1]];
    }

    /**
     * 二分模板二，找第一个 k <= cnt 的元素 <p>
     * 见官方图：count(matrix[][] , mid) == 统计 matrix[][] 中有多少个 <= mid 的元素 <p>
     * 可以理解为假想将 matrix[][] 有序一维化为 arr[] ，找第一个前面元素个数（包括自身） >= k 的元素
     */
    public int kthSmallest2(int[][] matrix, int k) {

        int row = matrix.length;

        // 第 k 小的数一定存在
        int l = matrix[0][0];
        int r = matrix[row - 1][row - 1];

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (k <= count(matrix , mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private int count(int[][] matrix , int mid) {

        int row = matrix.length;
        int col = matrix.length;

        // 从左下角开始，同 240
        int i = row - 1;
        int j = 0;

        int cnt = 0;
        while (0 <= i && j < col) {
            if (matrix[i][j] <= mid) {
                // 累加当前 matrix[i][j] 的上方的一列
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }
}