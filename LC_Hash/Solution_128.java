package leetcode.LC_Hash;

import java.util.HashSet;
import java.util.Set;

public class Solution_128 {

    /**
     * Set 的本质 == 一个去重的、可快速搜索的空间<p>
     * 题目要求时间复杂度为 O(n)<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外层 for 内层 while 并不是 O(n^2)<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间复杂度 0(for) + O(while) = O(n) + O(n) = O(n)<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用一个数组自己模拟一遍就知道了
     */
    public int longestConsecutive(int[] nums) {
        // 由 nums[] 创建一个可快速搜索的空间 Set
        Set<Integer> space = new HashSet<>();
        for (int num : nums) {
            space.add(num);
        }

        int res = 0;
        for (int start : space) {
            // 对于一个数值连续的序列 {x , x+1 , x+2 , ... , x+j}
            // 遇到其中的某个数 XXX
            // 判断 XXX-1 是否存在
            // 若存在 ==> 则之后肯定会遇到 XXX-1 或者之前已经遇到过 XXX-1 了，则不应该从该 XXX 开始计算最长序列长度（因为肯定不是最长），遇到 XXX-1 再判断
            // 若不存在 ==> 则此 XXX 即为 x ，可以从该 x 开始计算最长序列长度
            // 即应该从每一个数值连续序列的最小值开始搜索起，从中间搜索起肯定不是最长的序列
            if (!space.contains(start - 1)) {
                int end = start;
                while(space.contains(end + 1)) {
                    end++;
                }
                res = Math.max(res , end - start + 1);
            }
        }
        return res;
    }
}
