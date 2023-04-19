package leetcode.LC_50;

/**
 * LC_Tree 的二叉树节点
 * @author man11
 */

public class TreeNode {

    /**
     * 节点值
     */
    public int val;

    /**
     * 左右孩子
     */
    public TreeNode left;
    public TreeNode right;

    /**
     * 构造函数
     */
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
