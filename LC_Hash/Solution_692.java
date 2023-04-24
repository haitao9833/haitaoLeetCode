package leetcode.LC_Hash;

import java.util.*;

public class Solution_692 {

    /**
     * 堆排序：将 {X , cnt} 依次放入大小为 k 的<strong>小根堆</strong>
     * @see leetcode.LC_Array.Solution_215
     */
    public List<String> topKFrequent(String[] words, int k) {
        // {X , cnt}
        Map<String , Integer> mp = new HashMap<>();
        for (var word : words) {
            mp.put(word , mp.getOrDefault(word , 0) + 1);
        }

        // {X , cnt} 入 cnt 小根堆
        // 当 cnt 相同时字符串 X 按字典序逆序排列
        // 因为最后 res 需逆序添加小根堆的堆顶元素，且 cnt 相同的字符串在 res 中必须按字典序升序
        Set<Map.Entry<String , Integer>> entries = mp.entrySet();
        PriorityQueue<Map.Entry<String , Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> (!o1.getValue().equals(o2.getValue())) ? o1.getValue() - o2.getValue() : o2.getKey().compareTo(o1.getKey()) );
        for (var entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                // 堆顶最小的滚
                queue.poll();
            }
        }

        // res 内按 cnt 降序，按 X 升序
        List<String> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(0 , queue.poll().getKey());
        }
        return res;
    }
}