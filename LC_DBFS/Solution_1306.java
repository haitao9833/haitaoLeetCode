package leetcode.LC_DBFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1306 {

    /**
     * 共享信息 <P>
     * dfs 的 vis[i] 表示下标 i 是否访问过 <P>
     * bfs 的 inQ[i] 表示下标 i 是否已入队列
     */
    int n;
    int[] arr;
    boolean[] vis;
    boolean[] inQ;


    public boolean canReach(int[] arr , int start) {
        if (arr[start] == 0) {
            return true;
        }
        this.n = arr.length;
        this.arr = arr;
        this.vis = new boolean[n];

        return dfs(start);

        //return bfs(start);
    }
    private boolean dfs(int curIdx) {
        // 递归边界一，越界 or 已经访问过
        if (curIdx < 0 || n <= curIdx || vis[curIdx]) {
            return false;
        }

        // 递归边界二，已经跳到了 arr[i] == 0 处
        if (arr[curIdx] == 0) {
            return true;
        }

        // 标记已经跳过
        vis[curIdx] = true;

        return dfs(curIdx - arr[curIdx]) || dfs(curIdx + arr[curIdx]);
    }
    private boolean bfs(int start) {

        Deque<Integer> queue = new ArrayDeque<>();
        inQ = new boolean[arr.length];

        // 起始节点入队
        queue.offerLast(start);
        inQ[start] = true;

        while (!queue.isEmpty()) {

            int curIdx = queue.pollFirst();

            // 向左跳
            int l = curIdx - arr[curIdx];
            if (0 <= l  && !inQ[l]) {
                if(arr[l] == 0) {
                    return true;
                }
                queue.push(l);
                inQ[l] = true;
            }

            // 向右跳
            int r = curIdx + arr[curIdx];
            if (r < n && !inQ[r]) {
                if(arr[r] == 0) {
                    return true;
                }
                queue.push(r);
                inQ[r] = true;
            }
        }
        return false;
    }
}
