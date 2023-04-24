package leetcode.LC_Hash;

public class Solution_621 {

    /**
     * <strong>见图解</strong>：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建 m 个大小为 n+1 的桶子，其中 m 为数量最多的任务的数量<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他任务优先填满前 m-1 个桶子，只有存在多个数量为 m 的任务时，才会填入最后一个桶子<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;填满了则前 m-1 个桶子则可扩充<p>
     * 桶空间满了 == 则最短时间为任务数量<p>
     * 桶空间没满 == 则最短时间为桶空间大小
     */
    public int leastInterval(char[] tasks, int n) {

        int bucketCnt = 0;
        int bucketSize = n + 1;
        int bucketLast = 0;

        // {任务 , cnt}
        // 求需要创建的桶的个数为 max(cnt)
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
            bucketCnt = Math.max(bucketCnt , map[task - 'A']);
        }

        // 最后一桶 bucketLast == 任务数量为 bucketCnt 的任务数量
        for (int cnt : map) {
            if (bucketCnt == cnt) {
                bucketLast++;
            }
        }

        return Math.max(tasks.length , (bucketCnt - 1) * bucketSize + bucketLast);
    }
}
