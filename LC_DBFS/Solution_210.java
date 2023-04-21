package leetcode.LC_DBFS;

import java.util.*;

public class Solution_210 {

    /**
     * 207 bfs() 代码的基础上，<strong>记录一下出队序列即可</strong>
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int c = 0 ; c < numCourses ; c++) {
            if(inDegrees[c] == 0) {
                queue.add(c);
            }
        }

        // 比 207 多了一行记录出队序列
        int[] res = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()) {
            int zeroInDegreesC = queue.pollFirst();

            // 比 207 多了一行记录出队序列
            res[index++] = zeroInDegreesC;

            for (int nextC : graph.get(zeroInDegreesC)) {
                if(--inDegrees[nextC] == 0) {
                    queue.add(nextC);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
