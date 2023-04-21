package leetcode.LC_DBFS;

import java.util.*;

public class Solution_1345 {

    /**
     * 定义目标层即 arr[n-1] 为<strong>第 0 层</strong><p>
     * 对于左 i-1 、右 i+1 及同值 arr[j] 累加 1 层
     * @see Solution_1306
     */
    public int minJumps(int[] arr) {

        int n = arr.length;

        // minStep[i] 记录从下标 i 跳到下标 n-1 的最少跳数，也即下标 i 元素的层数
        int[] minStep = new int[n];

        // 同值处理 {值 : {下标 、下标 、...}}
        Map<Integer , List<Integer>> valPos = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            // 初始化为 -1 表示还没遍历计算过层，即也担当了 inQ[] 的作用
            minStep[i] = -1;

            List<Integer> pos = valPos.getOrDefault(arr[i] , new ArrayList<>());
            pos.add(i);
            valPos.put(arr[i] , pos);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        // 目标层最先入队
        // 更新完层数就入队
        minStep[n - 1] = 0;
        queue.offerLast(n - 1);

        while (!queue.isEmpty()) {
            // 出队后用其层数更新其下一层的层数，且将下一层都入队
            int curIdx = queue.pollFirst();

            // 向左跳
            int l = curIdx - 1;
            if (0 <= l  && minStep[l] == -1) {
                minStep[l] = minStep[curIdx] + 1;
                queue.offerLast(l);
            }

            // 向右跳
            int r = curIdx + 1;
            if (r < n && minStep[r] == -1) {
                minStep[r] = minStep[curIdx] + 1;
                queue.offerLast(r);
            }

            // 同值跳
            if (valPos.containsKey(arr[curIdx])) {
                for (int pos : valPos.get(arr[curIdx])) {
                    // 还要判断一下是否为 -1
                    // 因为可能同值恰好为左右，上面已经更新过了
                    if (minStep[pos] == -1) {
                        minStep[pos] = minStep[curIdx] + 1;
                        queue.offerLast(pos);
                    }
                }
                // 同值更新层后就删除，避免重复判断，会非常耗时
                valPos.remove(arr[curIdx]);
            }

            // 提前返回
            if (minStep[0] != -1) {
                return minStep[0];
            }
        }
        return minStep[0];
    }
}
