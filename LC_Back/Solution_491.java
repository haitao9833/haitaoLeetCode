package leetcode.LC_Back;

import java.util.*;

public class Solution_491 {

    /**
     * 共享信息
     */
    int n;
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * back1(startIndex) == 从 nums[startIndex , ... , n-1] 中选择一个 num 加入到 path 中形成递增子序列<p>
     * 不可预先排序的同层去重：每层定义一个 Set 避免同层重复<p>
     * 注意：无条件收集所有递增子序列
     */
    public List<List<Integer>> findSubsequences1(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        back1(0);
        return res;
    }
    void back1(int startIndex) {
        // 无条件收集长度 > 1 的递增子序列
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        // 每层定义一个 Set 判断本层（也仅需要判断本层）是否重复选取了
        Set<Integer> used = new HashSet<>();

        // 遍历本层：nums[startIndex , ... , n-1]
        for (int i = startIndex ; i < n ; i++) {

            // 保证递增性
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }

            // 同层去重
            // 例如 nums[] == [4 , 7 , 1 , 7 , 9]
            // 当前选了 path == {4} ，则本层选了 {4 , 7 , , , } 后不可再选 {4 , , , 7 , }
            // 但在不同层还是可以选 {4 , 7 , , 7 , }
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);

            path.add(nums[i]);
            back1(i + 1);

            path.removeLast();
        }
    }

    /**
     * 1 <= n <= 15
     */
    int[] lastPos = new int[15];

    /**
     * 预处理去重：
     *      back2(i) == back1(i)
     * 分析上述 set 去重可以理解，同层去重的本质是：
     *      在 nums[startIndex , n-1] 中遍历到某个 nums[i] 时
     *      保证前面 nums[startIndex , i-1] 未出现过 nums[i] 同值
     *      如果出现了，则该 nums[i] 不能选择，去重跳过，继续遍历后面的 nums[i+1 , n-1]
     * 则可以预先处理 nums[] 数组，对每个 nums[i] 记录其前面同值出现的下标位置
     *      如果没出现过，则标记为 -1
     *      如果多次出现，则仅需记录离当前 nums[i] 最近的前面一个
     *      因为最近的一个若出现在 [startIndex , i-1] 范围内，则其他的在不在，都需要去重处理
     *      若最近的一个都没出现在 [startIndex , i-1] 范围内，则其他的肯定不在，也不需要去重
     */
    public List<List<Integer>> findSubsequences2(int[] nums) {
        // preliminary
        this.n = nums.length;
        this.nums = nums;

        // 预处理 nums[] 数组
        for (int i = 0 ; i < n ; i++) {
            // 初始化为 -1
            lastPos[i] = -1;
            // 用 j 逆序遍历 [i-1 -> 0] 找 nums[i] 最近的前面一个同值出现的下标位置
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (nums[j] == nums[i]) {
                    lastPos[i] = j;
                    break;
                }
            }
        }
        // 即 lastPos[i] 记录了 nums[i] 最近的前面一个同值出现的下标位置

        back2(0);
        return res;
    }
    void back2(int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex ; i < n ; i++) {
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }
            // back1(i) 和 back2(i) 的唯一区别
            if (i != startIndex && startIndex <= lastPos[i]) {
                continue;
            }
            path.add(nums[i]);
            back2(i + 1);
            path.removeLast();
        }
    }
}
