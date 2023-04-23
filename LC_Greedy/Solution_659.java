package leetcode.LC_Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 要求每个子序列长度至少为 3，且数字必须连续递增
 * 重点是 tail ：
 *       key —— num
 *       value —— 以 num 为结尾的且符合题意的连续子序列个数
 * 贪心策略：
 *       按从小到大的顺序处理 nums 中的每一个 num （nums 已经是题目递增排序好的）
 *       若当前处理的 num 个数已经为 0 则无所谓了
 *       总是将当前处理的 num 优先接到已有的序列 tail[num-1] 后面
 *       若无法接的情况下再考虑 num 与 num+1 与 num+2 一起开新序列
 *       否则当前处理的 num 无法进行上述任何处理则 return false
 * 其实就是扑克牌中的出 "顺子"
 */
@SuppressWarnings("all")
public class Solution_659 {
    public static boolean isPossible(int[] nums) {
        Map<Integer , Integer> num2cnt = new HashMap<>();
        for (int num : nums) num2cnt.put(num , num2cnt.getOrDefault(num , 0)  + 1);
        Map<Integer , Integer> tail = new HashMap<>();
        for (int num : nums) {
            int count = num2cnt.get(num);
            if (count == 0) {
                continue;
            }
            else if (tail.getOrDefault(num - 1 , 0) != 0) {
                num2cnt.put(num , count - 1);
                tail.put(num - 1 , tail.get(num - 1) - 1);
                tail.put(num , tail.getOrDefault(num , 0) + 1);
            }
            else if (num2cnt.getOrDefault(num + 1 , 0) != 0 && num2cnt.getOrDefault(num + 2 , 0) != 0) {
                num2cnt.put(num , count - 1);
                num2cnt.put(num + 1 , num2cnt.get(num + 1) - 1);
                num2cnt.put(num + 2 , num2cnt.get(num + 2) - 1);
                tail.put(num + 2 , tail.getOrDefault(num + 2 , 0) + 1);
            }
            else return false;
        }
        return true;
    }
    public static void main(String...args) {
        int[] test = new int[]{1,2,2,2,3,3,3,4,4,4};
        System.out.println(isPossible(test));
    }
}

/**
 * 另一种思路 + 空间优化 O(1)
 * 每次处理一种数值 cur：
 *        计算该种数值的个数
 *        填充其前面小 1 的数值的 len1 、len2 、len3
 */
class Solution_659_02 {
    public boolean isPossible(int[] nums) {
        int len1 = 0;  // 以 preNum 为结尾的长度为 1 的子序列
        int len2 = 0;  // 以 preNum 为结尾的长度为 2 的子序列
        int len3 = 0;  // 以 preNum 为结尾的长度 >= 3 的子序列
        int index = 0;
        while (index < nums.length) {
            int curStart = index;
            int cur = nums[index];
            while (index < nums.length && nums[index] == cur) index++;
            int curCount = index - curStart;
            /**
             * 找后序第一个不等于 cur 的 nextCur ，下一次遍历从该 nextCur 种数值开始
             * 计算该种数值 cur 的个数
             */

            if (curStart > 0 && nums[curStart - 1] + 1 != cur) { // cur 无法连接到 preNum 后面
                if (len1 + len2 > 0) return false;
                len1 = curCount;
                len2 = 0;
                len3 = 0;
            } else {
                if (len1 + len2 > curCount) return false;  // cur 无法连接满 preNum 的 len1 与 len2
                int leave = curCount - len1 - len2;        // cur 先连接满 preNum 的 len1 与 len2
                int toLen3 = Math.min(leave , len3);       // cur 尽量连接满 preNum 的 len3
                int newSeq = leave - toLen3;               // 剩下的开 cur 开头的新序列

                len3 = len2 + toLen3;  // 更新为 cur 的 len3 用于下一个 nextCur
                len2 = len1;           // 更新为 cur 的 len2 用于下一个 nextCur
                len1 = newSeq;         // 更新为 cur 的 len1 用于下一个 nextCur
            }
        }
        return len1 == 0 && len2 == 0;
    }
}