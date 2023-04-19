package leetcode.LC_50;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295 ：数据流中的中位数，见《剑指 Offer》的 41 的 k 神图解
 * <p> 应用和进阶见 480 滑动窗口的中位数，涉及到要移除数据流中的元素
 */

public class MedianFinder {

    /**
     * 大根堆 == 堆顶最大
     * <p> 保存数据流 nums[] 中前半部分 (n+1)/2 个较小的元素
     */
    PriorityQueue<Integer> l;

    /**
     * 小根堆 == 堆顶最小
     * <p> 保存数据流 nums[] 中后半部分 n/2 个较大的元素
     */
    PriorityQueue<Integer> r;

    /**
     * 构造函数
     */
    public MedianFinder() {
        l = new PriorityQueue<>(Comparator.reverseOrder());
        r = new PriorityQueue<>(Comparator.naturalOrder());
    }

    /**
     * 插入时维护：
     * <p> l.size() == r.size()
     * <p> l.size() == r.size() + 1
     */
    public void addNum(int num) {
        if (l.size() == r.size()) {
            // 先推入 r 中，换取一个最小的，再推入 l 中
            r.offer(num);
            l.offer(r.poll());
        } else {
            // 先推入 l 中，换取一个最大的，再推入 r 中
            l.offer(num);
            r.offer(l.poll());
        }
    }

    /**
     * 求中位数，取堆顶即可
     */
    public double findMedian() {
        return l.size() == r.size() ? (l.peek() + r.peek()) / 2.0 : l.peek();
    }
}
