package leetcode.LC_50;

import java.util.*;

/**
 * LC_Office_1 37 == LC_Office_2 48 == 297
 */

public class Codec {

    /**
     * <strong>递归的思想真是很<font style="color:red">简洁</font>啊<p>
     * 每个叶子节点带着两个 NULL 空节点一起序列化，反序列化的时候就能知道啥时候停止继续往下生成节点了<p>
     * 照着官方题解的图画一画就知道了</strong>
     */
    public static String serialize(TreeNode root) {

        // 每个叶子节点带着两个 NULL 空节点一起序列化
        if (root == null) {
            return "NULL";
        }

        // 分别序列化左子树 & 右子树
        String left = serialize(root.left);
        String right = serialize(root.right);

        // 先序拼接
        // 反序列化的时候按同样的顺序生成节点
        return root.val + "," + left + "," + right;
    }
    public static TreeNode deserialize(String data) {
        // 按分隔符分隔成队列
        String[] temp = data.split(",");
        Deque<String> queue = new LinkedList<>(Arrays.asList(temp));
        return buildTree(queue);
    }
    private static TreeNode buildTree(Deque<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        // 取出根节点
        String s = queue.poll();
        if ("NULL".equals(s)) {
            // 停止继续往下生成节点
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));

        // 先反序列化左子树
        // 再反序列化右子树
        root.left = buildTree(queue);
        root.right = buildTree(queue);

        // 返回根节点
        return root;
    }
}


/**
 * 迭代 —— 序列化和反序列化二叉树
 */
class Codec_02 {
    public static String serialize(TreeNode root) { // Tree --> String
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("X,");
            } else {
                sb.append(node.val + ",");   // 类似 BinaryTree 中的 create
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }
    public static TreeNode deserialize(String data) { // String --> Tree
        if (data.equals("")) return null;
        Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(","))); // 节点值队列
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Queue<TreeNode> queue = new ArrayDeque<>();  // 节点队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();     // 类似 BinaryTree 中的 create ，无需作判断，直接去左右孩子
            if (!left.equals("X")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left); // 每创建好一个节点，都要将该节点入队，以便创造它的左右孩子
            }
            if (!right.equals("X")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.add(node.right);
            }
        }
        return root;
    }
}