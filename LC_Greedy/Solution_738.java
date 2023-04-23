package leetcode.LC_Greedy;

/**
 * 贪心核心：
 *       只要高位 - 1 ，则其后皆可为 9
 * 策略一，从后往前遍历
 *        [flag , length-1] 位都需要变成 9
 * 策略二：从前往后遍历
 *        此时的中间高位 - 1，其后依旧皆可为 9
 *        但是有可能导致 [前面高位] > [中间高位 - 1] ，此时则需要递归地向前处理
 *        本质和策略一一样，但是实现起来没有策略一明白清晰，略
 */
public class Solution_738 {
    public int monotoneIncreasingDigits(int n) {
        char[] ch = Integer.toString(n).toCharArray(); // 比用 (n + "") 化为字符串要快得多
        int flag = ch.length; // 防止没有数字需要改动时，第二个 for 执行
        for (int i = ch.length - 1 ; i >= 1 ; i--) {
            if (ch[i - 1] > ch[i]) { // [大][小] -> 高位-1
                flag = i;
                ch[i - 1]--;
            }
        }
        for (int i = flag ; i < ch.length ; i++) { // 全局贪心
            ch[i] = '9';
        }
        return Integer.parseInt(new String(ch));
    }
}
