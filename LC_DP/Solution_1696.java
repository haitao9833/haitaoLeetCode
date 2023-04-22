package leetcode.LC_DP;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 一维转常量后，常量范围为一个窗口，可以对该窗口进行某些优化
 */

public class Solution_1696 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示从下标 0 跳到下标 i 的最大得分
     * 状态转移：
     *      dp[i] == max(dp[j]) + nums[i]  其中 j 需遍历 [max(0,i-k) ~ i-1]
     *      【项分析：i 基于 j == [max(0,i-k) ~ i-1] ，所以 i 必须正序遍历】
     *      【且仅需保证至少 [0 ~ i-1] 有效即可，所以 i 正序遍历 [1 -> n-1]】
     *      【且配合初始化 i=0 的情况，且内部 j 正序逆序无所谓】
     * 遍历顺序：【综上】
     * 初始化：dp[0] = nums[0]
     *
     * 但由于题目条件 1 <= n 、k <= 10^5 ，则外层 i [1 -> n-1] 内层 j [max(0,i-k) ~ i-1] 容易造成 10^10 超时 TLE
     * 所以需要直接使用一维化常量的空间优化算法，对每一个 dp[i] 仅需保存其左方 dp[max(0,i-k) ~ i-1] 的值
     * dp[max(0,i-k) ~ i-1] 即为常量窗口
     * 且由于每次仅需从 dp[max(0,i-k) ~ i-1] 中取出最大值，则可用大顶堆保存 dp[max(0,i-k) ~ i-1] 的值
     * 而非用 downdowndown 、downdown 、down 等变量记录
     *
     * 大顶堆保存 dp[max(0,i-k) ~ i-1]
     *
     * 优先队列 PriorityQueue 默认是小顶堆，可以在构造函数中传入 Lambda 形式的 Comparator 声明为大顶堆
     */
    public int maxResult1(int[] nums , int k) {
        // preliminary
        int n = nums.length;

        // 初始化
        int[] dp = new int[n];
        dp[0] = nums[0];

        // 优先队列 --> 大顶堆 --> 依据 dp[i] 排序
        // 元素 == {dp[i] , i}
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a , b) -> b[0] - a[0]
        );
        queue.offer(new int[]{dp[0] , 0});

        for (int i = 1 ; i < n ; i++) {
            // queue.peek()[0] == max(dp[j])
            // queue.peek()[1] == j
            // queue 中存的 j 无效，不在 [i-k , i-1] 范围内了，移除之
            while (queue.peek()[1] < i - k) {
                queue.poll();
            }

            // 更新计算 dp[i] 并推入大顶堆中作为下一轮 dp[i+1] 的 dp[max(0,i-k) ~ i-1]
            dp[i] = queue.peek()[0] + nums[i];
            queue.offer(new int[]{dp[i] , i});
        }
        return dp[n - 1];
    }

    /**
     * 单调队列维护 dp[max(0,i-k) ~ i-1] 的一个严格单调递减子部分
     *      对于 j1 < j2 && dp[j1] <= dp[j2]
     *      则可以直接删除 dp[j1] ，因为 dp[j1] 不可能再作为 max(dp[j]) 使用到了
     * 例如 dp[max(0,i-k) ~ i-1] == [1  3  4  5  2] 对于当前 dp[i] 来说
     *      上述大顶堆保存所有
     *      此处单调队列仅维护 [5 2]
     */
    public int maxResult2(int[] nums , int k) {
        // preliminary
        int n = nums.length;

        // 初始化
        int[] dp = new int[n];
        dp[0] = nums[0];

        // 严格单调递减队列
        // 元素 == {dp[i] , i}
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{dp[0] , 0});

        for (int i = 1 ; i < n ; i++) {
            // queue.peekFirst()[0] == max(dp[j])
            // queue.peekFirst()[1] == j
            // queue 中存的 j 无效，不在 [i-k , i-1] 范围内了，移除之
            while (queue.peekFirst()[1] < i - k) {
                queue.pollFirst();
            }

            // 更新计算 dp[i]
            dp[i] = queue.peekFirst()[0] + nums[i];

            // 在推入单调队列中作为下一轮 dp[i+1] 的 dp[max(0,i-k) ~ i-1] 之前
            // 需维护单调队列的严格单调递减性质
            while (!queue.isEmpty() && queue.peekLast()[0] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(new int[]{dp[i] , i});
        }
        return dp[n - 1];
    }

    /**
     * 逆向思考：dp[i] 依赖前面的 dp[max(0,i-k) ~ i-1]
     * 正向思考：dp[i] 影响后面的 dp[i+1 , min(i+k,n-1)]
     */
    public int maxResult3(int[] nums , int k) {
        // preliminary
        int n = nums.length;

        // 初始化 dp[i] 为 Integer.MIN_VALUE
        int[] dp = new int[n];
        Arrays.fill(dp , Integer.MIN_VALUE);
        dp[0] = nums[0];

        for (int i = 0 ; i < n ; i++) {
            // 对每一个 dp[i] 计算其对后面的影响
            for (int j = i + 1 ; j <= Math.min(i + k , n - 1) ; j++) {
                dp[j] = Math.max(dp[j] , dp[i] + nums[j]);

                // 出现 i < j && dp[i] <= dp[j] 则后面的 dp[] 由 dp[j] 影响
                // 即此 dp[i] 的影响范围到此为止，遍历下一个 dp[i+1] 对后面的影响
                // 本质同上面的单调队列，不过省去了队列 Deque 及其各种增删操作
                // 没有这句话，则转化为外层 i 全遍历内层 j 全遍历的原始动态规划，会导致超时
                if (dp[i] <= dp[j]) {
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}