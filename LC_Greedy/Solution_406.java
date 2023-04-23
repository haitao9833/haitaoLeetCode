package leetcode.LC_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类似 135 分发糖果
 *           遇到两个维度的权衡问题
 *           要先确定一个维度，再确定另一个维度
 *           两个维度同时考虑大概率可能会顾此失彼
 * 这里
 *    我们先按身高 h 从 高->低 排序
 *    然后再按前面应该有几个比我高或者同等身高的人数 k 来插入
 *    且依旧按照高个子先插入矮个子后插入
 *    因为后序矮个子的插入，是不会影响到前面高个子已经插好的情况的
 *    一句话解释：高个子的人是看不到低个子人的
 */
public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1 , p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            return p2[0] - p1[0];
            /**
             * 身高从大到小排序，身高相同的，k 小的排前面
             * Comparator 默认是从小到大排序，我们只需定义什么是小于、等于、大于
             * 小于 —— 返回负数 —— 排前面
             * 大于 —— 返回正数 —— 排后面
             */
        });
        List<int[]> res = new ArrayList<int[]>();
        for (int[] p : people) {
            res.add(p[1] , p);                      // 在指定下标位置插入指定元素，直接按 k 为下标插入
        }
        return res.toArray(new int[res.size()][]);  // 集合 ---> 数组，此处可以无需指定第二维的大小
    }
}
