package leetcode.LC_Offer_1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈中所有数字均不相等 —— 有唯一的出栈位置
 *                      栈顶与出栈序列首元素相同，直接出栈
 * 栈中数字有相同的如：
 *                pushed：10 1 2 10 3
 *                popped：10 2 3 1 10
 *                第一个 10 不能因为与出栈序列首元素相同而先出栈
 */
public class Solution_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0; // 出栈序列的有效指针、
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) { // 栈顶与出栈序列首元素相同，直接出栈
                stack.poll();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
