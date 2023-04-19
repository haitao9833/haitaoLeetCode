package leetcode.LC_50;

import java.util.*;

/**
 * 380
 * 插入 O(1) ：
 *           List 、Map 自带的
 * 删除 O(1) ：
 *           Map O(1) 查找欲删除的值的下标
 *           用 List 的最后一个元素覆盖之
 *           然后再删除最后一个元素，后面的元素则不需要向前拷贝
 * 随机获取 O(1) ：
 *           List + Random
 * 本质：用 Map 弥补 List 无法 O(1) 查找和 O(1) 删除的缺陷
 *      用 List 弥补 Map 无法 O(1) 随机访问的缺陷
 */
public class RandomizedSet {
    private Random random;
    private List<Integer> list;
    private Map<Integer , Integer> dict;  // value - index

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;

        dict.put(val , list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;

        int index = dict.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index , lastElement);
        dict.put(lastElement , index);

        dict.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() { // O(1) 随机获取
        return list.get(random.nextInt(list.size()));  // 生成 [0 , list.size()) 范围内的随机 int
    }
}
