package leetcode.LC_Linked;

import java.util.HashMap;
import java.util.Map;

public class Solution_138 {

    /**
     * val + next + random
     */
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 遍历三遍
     */
    public Node copyRandomList2(Node head) {
        // 每个新节点直接生成在原节点之后，方便下述复制 random 指针
        for (Node pre = head ; pre != null ; pre = pre.next.next) {
            Node copy = new Node(pre.val);
            copy.next = pre.next;
            pre.next = copy;
        }

        // 复制随机指针 random
        for (Node pre = head ; pre != null ; pre = pre.next.next) {
            if (pre.random != null) {
                // 核心语句
                pre.next.random = pre.random.next;
            }
        }

        // 取下新节点连接起来
        Node dummpy = new Node(-1);
        Node tail = dummpy;
        for (Node pre = head ; pre != null ; pre = pre.next) {
            Node newNode = pre.next;
            pre.next = newNode.next;
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = null;
        return dummpy.next;
    }

    /**
     * 看图解 <P>
     * Hash + dfs 递归生成二叉树
     * <p> map == {旧节点 , 新节点}
     */
    private final Map<Node , Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return dfs(head);
    }
    private Node dfs(Node cur) {
        // 递归创建的边界
        if (cur == null) {
            return null;
        }

        // 指针 random 的不定性，有可能把后续节点已经复制好了
        if (map.containsKey(cur)) {
            return map.get(cur);
        }

        // 把 copy 看作创建根节点 root
        Node copy = new Node(cur.val);
        map.put(cur , copy);

        // 把 next 指针看作递归创建 root.left
        // 把 random 指针看作递归创建 root.right
        copy.next = dfs(cur.next);
        copy.random = dfs(cur.random);

        // 返回上一层连接起来
        return copy;
    }
}
