package leetcode.LC_DBFS;

import java.util.Arrays;

public class Solution_698 {

    /**
     * 共享信息
     */
    int k;
    int target;
    int[] nums;

    /**
     * dfs(idx , buckets[]) == 将 nums[idx] 放入某个桶中，后续是否能放满 k 个桶 buckets[k]
     * 最重要的是理解排序贪心优化和两个剪枝优化
     */
    public boolean canPartitionKSubsets(int[] nums , int k) {
        // preliminary
        this.k = k;
        this.nums = nums;
        int n = nums.length;

        // 判断 sum(nums) % k == 0
        // 计算每个子集的大小 target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        this.target = sum / k;

        // 预先排序 + 优先放大的数（贪心优化）
        Arrays.sort(nums);
        if (nums[n - 1] > target) {
            return false;
        }

        return dfs(n - 1 , new int[k]);
    }
    private boolean dfs(int idx , int[] buckets) {
        // 递归边界，已将 nums[] 全部放完，必然已放满 k 个桶，返回 true
        if (idx == -1) {
            return true;
        }

        // 将 nums[idx] 放入 buckets[k] 的某一个桶中
        for (int i = 0 ; i < k ; i++) {
            // 放不下该桶，放下一个桶
            if (nums[idx] + buckets[i] > target) {
                continue;
            }

            // 重要的剪枝优化一
            // 前一桶 buckets[i-1] 和当前桶 buckets[i] 容量相同
            // 既然遍历到此，说明将 nums[idx] 放入前一桶后，后续无法形成有效的放满方案
            // 则将 nums[idx] 放入当前桶后，后续也无法形成有效方案
            if (i != 0 && buckets[i - 1] == buckets[i]) {
                continue;
            }

            buckets[i] += nums[idx];
            if (dfs(idx - 1 , buckets)) {
                // 找到一种有效放满的方案就返回，不再遍历下一种可能放满的方案了
                return true;
            }
            buckets[i] -= nums[idx];

            // 重要的剪枝优化二，本质同上剪枝优化一
            // nums[idx] 取出来后 buckets[i] 为空桶了
            // 说明 nums[idx] 是第一个放入 buckets[i] 中的，放入时后面的桶 buckets[i+1~k] 必然也是空桶
            // 当回溯至将 nums[idx] 从 buckets[i] 中取出，即表明将 nums[idx] 放入空桶 buckets[i] 后，后续无法放满
            // 则将 nums[idx] 继续遍历放入后面的空桶 buckets[i+1~k] 后续也无法放满
            if (buckets[i] == 0) {
                return false;
            }
        }
        return false;
    }
}
