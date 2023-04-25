package leetcode.LC_LCP;

import java.util.PriorityQueue;

public class Solution_LCP_33 {

    /**
     * <P> 将<strong>需要蓄水次数最多</strong>的水缸放在堆顶
     * <P> 因为只要满足这个次数，堆内其余的水缸都能被蓄满
     */
    public int storeWater(int[] bucket, int[] vat) {
        // op 表示升级小水桶的操作次数
        int op = 0;

        // 依据至少需要的蓄水次数建立大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (b1 , b2) -> b2[0] - b1[0]
        );

        for (int i = 0 ; i < bucket.length ; i++) {
            if (vat[i] == 0) {
                continue;
            }
            if (bucket[i] == 0) {
                // 必须先把所有小水桶 bucket[] 升级为 > 0
                op++;
                bucket[i]++;
            }

            // 入队 {至少需要的蓄水次数（向上取整） , 水缸水桶标号}
            queue.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i] , i});
        }

        int minOp = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            // 取出堆顶
            int[] top = queue.poll();

            // 如果 op 已经超过 minOp 了，则后续无需再去升级小水桶 op++ 了，后续不可能存在更少的操作次数了
            if (op >= minOp) {
                break;
            }

            // 核心语句
            minOp = Math.min(minOp , op + top[0]);

            // 核心思路：升级小水桶 ==> 看是否能减小堆顶的操作次数
            op++;
            bucket[top[1]]++;
            queue.offer(new int[]{(vat[top[1]] + bucket[top[1]] - 1) / bucket[top[1]] , top[1]});
        }

        // 最少次数可以是 0 次，即 vat[] 全为 0
        return minOp == Integer.MAX_VALUE ? 0 : minOp;
    }
}