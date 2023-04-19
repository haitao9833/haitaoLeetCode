package leetcode.LC_50;

import java.util.*;

/**
 * 341
 */
class NestedInteger {
    private Integer integer;             // 每个 NestedInteger 对象维护一个 integer 属性
    private List<NestedInteger> list;    // 每个 NestedInteger 对象维护一个 list 属性

    public NestedInteger() {
        this.list = new ArrayList<NestedInteger>();
    }
    public NestedInteger(Integer integer){
        this.integer = integer;
        this.list = new ArrayList<NestedInteger>();
    }
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public Integer getInteger() {
        return integer;
    }
    public List<NestedInteger> getList() {
        return list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList<NestedInteger>();
            this.list.add(nestedInteger);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        if(this.isInteger()) { // 先打印 integer
            res.append(this.integer);
        }
        if (this.list.size() != 0) { // 再递归遍历 list
            res.append("[");
            for(NestedInteger n : this.list){
                res.append(n.toString());
                res.append(" ");
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
        }
        return res.toString();
    }

    // [1 , [2 , 3] , [[4 , 5] , 6 , [7 , 8]]]
    public static void main(String...args) {
        NestedInteger x1 = new NestedInteger(1);
        NestedInteger x2 = new NestedInteger();
        x2.add(new NestedInteger(2));
        x2.add(new NestedInteger(3));
        NestedInteger x3 = new NestedInteger();
        NestedInteger y1 = new NestedInteger();
        y1.add(new NestedInteger(4));
        y1.add(new NestedInteger(5));
        NestedInteger y2 = new NestedInteger(6);
        NestedInteger y3 = new NestedInteger();
        y3.add(new NestedInteger(7));
        y3.add(new NestedInteger(8));
        x3.add(y1);
        x3.add(y2);
        x3.add(y3);

        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("x3 = " + x3);
        List<NestedInteger> list = new ArrayList<>();
        list.add(x1);
        list.add(x2);
        list.add(x3);
        System.out.println("list = " + list);

        Iterator it = new NestedIterator(list);
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println();
        Iterator It = new NestedIterator_02(list);
        while (It.hasNext()) {
            System.out.print(It.next());
            System.out.print(" ");
        }
    }
}

/**
 * 实现 Iterator<Integer> 接口：
 *             重写 next() 、hasNext() 抽象方法
 *             表明该类是一个迭代器，用于迭代 <Integer> 集合
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> queue = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) { // 初始化时，就把 list 扁平化到队列中去
        dfs(nestedList);
    }

    @Override
    public Integer next() { // 健壮性，即使程序不显示调用 hasNext ，next 内也主动调用 hasNext 再决定返回
        return hasNext() ? queue.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void dfs(List<NestedInteger> list) {
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                queue.addLast(item.getInteger());
            } else {
                dfs(item.getList()); // 深度扁平化
            }
        }
    }
}

class NestedIterator_02 implements Iterator<Integer> {
    Deque<NestedInteger> queue = new ArrayDeque<>();  // 注意，上述实现的 queue 中存的是扁平化之后的 Integer

    public NestedIterator_02(List<NestedInteger> list) {
        for (int i = list.size() - 1 ; i >= 0 ; i--) { // 倒序入栈
            queue.addLast(list.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.pollLast().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (queue.isEmpty()) {
            return false;
        } else {
            NestedInteger item = queue.peekLast();
            if (item.isInteger()) { // 栈顶为 NestedInteger.integer
                return true;
            } else { // 栈顶为 NestedInteger.list
                item = queue.pollLast();
                List<NestedInteger> list = item.getList();
                for (int i = list.size() - 1; i >= 0; i--) { // 将该 list 倒序入栈
                    queue.addLast(list.get(i));
                }
                return hasNext(); // 直到栈顶为 NestedInteger.integer
            }
        }
    }
}