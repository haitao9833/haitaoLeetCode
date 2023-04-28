package leetcode.LC_Offer_1;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Solution_36 {
    Node head = null;
    Node pre = null;
    private void dfs(Node cur) {
        if (cur == null) return;

        dfs(cur.left);

        if (pre == null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }
}
