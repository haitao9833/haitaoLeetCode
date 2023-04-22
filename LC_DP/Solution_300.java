package leetcode.LC_DP;

import java.util.Arrays;

public class Solution_300 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示以 nums[i] 为结尾的最长递增子序列的长度
     * 状态转移：
     *      dp[i] = max{1 , dp[j]+1}   其中 j ∈ [0 , i-1] 且 nums[j] < nums[i]
     *      【即用 j 遍历 [0 ~ i-1] 找到所有的 nums[j] < nums[i]】
     *      【且取其中最长的 dp[j]+1 为以 nums[i] 结尾的最长递增子序列】
     * 遍历顺序：
     *      【对每一个 i 需要用一个 j 遍历 [0 ~ i-1] ，则 i 不可能为 0】
     *      【所以 i 必须正序遍历 [1 -> len(nums)-1] 且配合初始化 dp[0] = 1】
     * 初始化：
     *      【同上述分析 i 必须从 1 开始遍历，则需要初始化 i=0 时的情况】
     *      dp[0] = 1     表示以 nums[0] 为结尾的最长递增子序列即为 nums[0] 自身，长度为 1
     */
    public static int lengthOfLIS1(int[] nums) {
        // preliminary
        int n = nums.length;

        // 初始化
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;

        for (int i = 1 ; i < n ; i++) {
            // 每个 dp[] 值至少是 1
            dp[i] = 1;

            // 用 j 遍历 [0 ~ i-1] 找到所有的 nums[j] < nums[i]
            for (int j = 0 ; j <= i - 1 ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }

            // 每更新计算一个 dp[i] 则用 res 比较、记录 dp[] 中的最大值
            res = Math.max(res , dp[i]);
        }
        return res;
    }

    /**
     * 进阶：贪心 + 二分
     * 贪心性：要使递增子序列尽可能的长 == 需要让子序列递增得尽可能慢 == 每次在递增子序列的最后加上的那个数尽可能小
     * 维护一个 tail[] 数组，tail[len] 表示长度为 len 的递增子序列的末尾元素的最小值，初始化 tail[1] = nums[0]
     * 重点 ———— 可证 tail[] 为严格递增数组，即递增子序列的长度越长，则其末尾元素值越大（详见官方题解） ———— 即可配合二分
     * 则依次遍历 nums[] ：
     *      若 nums[i]  > tail[len]   说明 nums[i] 可以作为末尾元素加到长度为 len 的递增子序列的最后
     *                                则更新 tail[len + 1] = nums[i]
     *                                【此处的意义在于让 len 越来越长，即递增子序列越来越长】
     *      若 nums[i] == tail[len]   跳过
     *      若 nums[i]  < tail[len]   则在 tail[1 ~ len] 中寻找第一个 >= nums[i] 的 tail[j]
     *                                表明长度为 j 的递增子序列的末尾元素 tail[j] 可以替换为更小（或相等）的 nums[i]
     *                                使用 704 二分法模板二
     *                                【此处的意义在于让递增子序列递增地越慢，即后续继续增长的可能性越大】
     *                                【例如在 nums[] = {1 , 8 , 2 , 3} 遍历到 8 时，最长递增子序列目前为 {1 , 8}】
     *                                【继续遍历到 2 时，将 {1 , 8} 改为 {1 , 2} ，则后续的 3 才能加进来成为 {1 , 2 , 3}】
     * 配合上述分析举例如 nums[] = {0 , 8 , 4 , 12 , 4 , 2} ，依次遍历 nums[i] 的过程中 tail[] 变化如下
     *      nums[i] = 0      tail[] = [0  0]
     *      nums[i] = 8      tail[] = [0  0  8]
     *      nums[i] = 4      tail[] = [0  0  4]
     *      nums[i] = 12     tail[] = [0  0  4  12]
     *      nums[i] = 4      tail[] = [0  0  4  12]
     *      nums[i] = 2      tail[] = [0  0  2  12]
     *      注意最前面的 tail[0] = 0 无意义
     */
    public static int lengthOfLIS2(int[] nums) {
        // preliminary
        int n = nums.length;

        // 初始化
        int[] tail = new int[n + 1];
        int len = 1;
        tail[len] = nums[0];

        // 可从 nums[] 的下标 1 开始遍历
        for (int i = 1 ; i < n ; i++) {

            if (tail[len] < nums[i]) {
                tail[++len] = nums[i];
            } else if (nums[i] < tail[len]) {
                // 在 tail[1 , len-1] 中找第一个 >= nums[i] 的 tail[j]
                // 因为至少有 tail[len] > nums[i] 所以 r 初始化为 len 即可覆盖所有可能返回的结果
                int l = 1;
                int r = len;

                while (l < r) {
                    int mid = l + ((r - l) >> 1);
                    if (nums[i] <= tail[mid]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                tail[l] = nums[i];
            } // else tail[len] == nums[i] continue 可省略
        }
        System.out.println(Arrays.toString(tail));
        return len;
    }

    public static void main(String...args) {
        int[] nums = new int[]{0 , 8 , 4 , 12 , 4 , 2};
        lengthOfLIS2(nums);
    }
}


