package leetcode.LC_Offer_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * DFS 见 k神
 * 关键点：
 *      sumI 、sumJ 数位和算法
 *      可仅通过向右和向下遍历到所有连通可达解
 */
public class Solution_13 {
    int row;
    int col;
    int k;
    boolean[][] vis;
    private int dfs(int i , int j , int sumI , int sumJ) {
        if (i >= row || j >= col || vis[i][j] || k < sumI + sumJ) return 0;
        vis[i][j] = true;
        int down = dfs(i + 1 , j , (i + 1) % 10 != 0 ? sumI + 1 : sumI - 8 , sumJ);
        int right = dfs(i , j + 1 , sumI , (j + 1) % 10 != 0 ? sumJ + 1 : sumJ - 8);
        return 1 + down + right;
    }
    public int movingCount(int m, int n, int k) {
        this.row = m;
        this.col = n;
        this.k = k;
        vis = new boolean[row][col];
        return dfs(0 , 0 , 0 , 0);
    }
}

/**
 * BFS 见 k神
 */
class Solution_13_02 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> queue= new LinkedList<int[]>(); // {i , j , sumI , sumJ}
        queue.add(new int[] { 0, 0, 0, 0 });
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int sumI = cur[2];
            int sumJ = cur[3];
            if(i >= m || j >= n || vis[i][j] || k < sumI + sumJ) continue;
            vis[i][j] = true;
            res++;
            queue.add(new int[] {i + 1 , j , (i + 1) % 10 != 0 ? sumI + 1 : sumI - 8 , sumJ});
            queue.add(new int[] {i , j + 1 , sumI , (j + 1) % 10 != 0 ? sumJ + 1 : sumJ - 8});
        }
        return res;
    }
}
