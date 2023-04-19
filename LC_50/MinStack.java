package leetcode.LC_50;

import java.util.ArrayDeque;

/**
 * 155
 * 辅助单调栈（空间换时间）
 *          最小值入栈，才同步入栈
 *          最小值出栈，才同步出栈
 * 相等的也要放进去
 *         stack = 1 -3  5 -3  1 -2(top)
 *         minS =  1 -3 -3(top)
 * 看 LeetCode 的 windliang 的 4 种方法的图解（BOSS直聘第一面挂了）
 */

class MinStack {
    private final ArrayDeque<Integer> stack;
    private final ArrayDeque<Integer> minSt;
    public MinStack() {
        stack = new ArrayDeque<>();
        minSt = new ArrayDeque<>();
    }
    public void push(int val) {
        stack.push(val);
        // 相等也入栈
        if (minSt.isEmpty() || minSt.peek() >= val) {
            minSt.push(val);
        }
    }
    public void pop() {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            if(top == minSt.peek()){
                minSt.pop();
            }
        }
    }
    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return stack.peek();
    }
    public int getMin() {
        if (minSt.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return minSt.peek();
    }
}