package leetcode.LC_DBFS;

import java.util.*;

public class Solution_207 {

    /**
     * 共享信息<p>
     * vis[i] <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;==  0  该课程节点还未访问过<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;==  1  该课程节点已经访问过，visited 功能，遇到访问过的课程节点，即为有环<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;== -1  从该课程节点出发无环，memo 功能，避免重复递归搜素
     */
    int numCourses;
    int[] vis;
    int[] inDegrees;
    List<List<Integer>> graph;

    /**
     * 广搜 bfs() == 逻辑删除所有入度为 0 的节点及其所有出边，重复如是<p>
     * 深搜 dfs(c) == 从课程 c 节点出发有环无环，无环返回 true ，有环返回 false<p>
     * 课程 [0 , ... , numCourses-1] 也即下标
     * @see Solution_210
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        this.numCourses = numCourses;
        graph = new ArrayList<>();
        inDegrees = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++) {
            graph.add(new ArrayList<>());
        }

        // edge[0] <-- edge[1]
        for (int[] edge : prerequisites) {
            // 邻接表
            graph.get(edge[1]).add(edge[0]);
            // 入度表
            inDegrees[edge[0]]++;
        }

        // return bfs();

        // 从每个节点出发
        // dfs 中
        vis = new int[numCourses];
        for (int c = 0 ; c < numCourses ; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs() {
        // 无需 inQ[]
        // 因为入队的都为入度为 0 的节点，没有边指向它，不会重复入队
        Deque<Integer> queue = new ArrayDeque<>();

        // 入度为 0 的节点入队
        for (int c = 0 ; c < numCourses ; c++) {
            if(inDegrees[c] == 0) {
                queue.add(c);
            }
        }

        while(!queue.isEmpty()) {
            // 出队访问
            int zeroInDegreesC = queue.pollFirst();

            // 逻辑删除入度为 0 的节点
            numCourses--;

            // 逻辑删除其所有出边
            for (int nextC : graph.get(zeroInDegreesC)) {
                // 删除边时，产生新的入度为 0 的节点，入队
                if(--inDegrees[nextC] == 0) {
                    queue.add(nextC);
                }
            }
        }

        // 看是否能全部删除完
        return numCourses == 0;
    }
    private boolean dfs(int curC) {
        // visited 功能
        if (vis[curC] == 1) {
            return false;
        }
        // memo 功能
        if (vis[curC] == -1) {
            return true;
        }

        // 标记已经访问过了
        vis[curC] = 1;

        // 递归访问从 curC 出发的所有路径
        for (int nextC : graph.get(curC)) {
            // 一旦有环，立马返回 false ，无需再判断其他路径了
            if (!dfs(nextC)) {
                return false;
            }
        }

        // 从课程 curC 节点出发的所有路径都无环，则标记为 -1 且返回 true
        vis[curC] = -1;
        return true;
    }
}
