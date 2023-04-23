package leetcode.LC_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类似 452 射爆气球
 * 策略一：按右区间升序排序
 *        则要从左向右遍历
 *        因为要每次贪心地选择最小右边界
 *        留给后一个区间的空间就越大
 * 策略二：按左区间升序排序
 *        则要从右向左遍历
 *        因为要每次贪心地选择最大左边界
 *        留给前一个区间的空间就越大
 */
public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals , Comparator.comparingInt(o -> o[1]));
        int count = 1;                       // 记录不重叠的区间的个数
        int minEnd = intervals[0][1];
        for (int i = 1 ; i < intervals.length ; i++) {
            if (minEnd <= intervals[i][0]) { // 区间 i 与前面一个区间不相交、或者挨着，即没有重叠
                minEnd = intervals[i][1];
                count++;
            } // 重叠的时候，intervals[i] 是要移除的，minEnd 记录的仍是 intervals[i-1][1] （ < intervals[i][1]）
        }
        return intervals.length - count;
    }
}
