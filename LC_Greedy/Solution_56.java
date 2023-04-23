package leetcode.LC_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 类似 435、452 重叠区间问题
 * 这类题的难点都在于：
 *           是按左边界排序，还是按右边界排序？
 *           排序后是从左到右遍历，还是从右到左遍历？
 * 本题同 452 射爆气球，找重叠气球
 *           按左边界排序
 *           然后从左到右遍历
 *
 */
public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals , Comparator.comparingInt(o -> o[0])); // 把函数调用改为 Lambda 会快一些些
        int start = intervals[0][0];
        for (int i = 1 ; i < intervals.length ; i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {  // 区间 i-1 与区间 i 不重叠（注意，挨着算重叠）
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i - 1][1] , intervals[i][1]);
                // 重叠，或者挨着，但是不着急加入，因为后续可能要合并多个重叠区间
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]}); // 注意加上最后一个
        return res.toArray(new int[res.size()][]);
    }
}
