package leetcode.LC_Greedy;

/**
 * 按左边界升序排序，然后从左到右遍历
 *               必须用 Integer.compare，因为有个测试用例用了最大值和最小
 *               comparingInt 底层用了 Integer.compare
 *               从 o 中提取出 o[0] 进行 Integer.compare
 *               最大值 + 1 = 最小值
 *               最小值 - 1 = 最大值
 */

import java.util.Arrays;
import java.util.Comparator;

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points , Comparator.comparingInt(o -> o[0]));
        int count = 1;  // points 不为空至少需要一支箭
        for (int i = 1 ; i < points.length ; i++) {
            if (points[i - 1][1] < points[i][0]) { // 气球 i-1 与气球 i 不重叠、不挨着
                count++;
            } else {
                points[i][1] = Math.min(points[i - 1][1] , points[i][1]);
                // 更新重叠气球组的最小右边界
            }
        }
        return count;
    }
}
