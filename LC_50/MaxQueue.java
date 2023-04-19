package leetcode.LC_50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC_Office_1 59Ⅱ
 * 辅助单调队列（空间换时间）
 * 非严格的，相等的也要放进去
 *         queue = 1 2 4 1 3 3 2
 *         deque = 4 3 3 2
 */
public class MaxQueue {
    Queue<Integer> queue;   // 元素队列
    Deque<Integer> deque;   // 单调递减队列

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) deque.pollLast();
        deque.offerLast(value);   // 相同的值要一起保存在单调队列中
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (deque.peekFirst().equals(queue.peek())) deque.pollFirst();
        return queue.poll();
    }
}
