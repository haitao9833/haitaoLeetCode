package leetcode.LC_DP;

import leetcode.LC_50.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 什么时候需要 memo 记忆化：
 *      假设树木共 5 层，计算 1 层为根节点的二叉树所能偷到的最大金额总数
 *      算法一：【同时需要孩子层和孙子层，递归过程会形成一颗递归树】
 *             即计算 rob(1) 的时候 --> 需要递归计算孩子 rob(2) 和孙子 rob(3)
 *             而计算 rob(2) 的时候 --> 需要递归计算其孩子 rob(3) 和其孙子 rob(4)
 *             即某些 rob(root) 可能会重复计算，所以每计算一次，就用 memo 记录下来，避免重复计算，此 memo == dp[]
 *      算法二：【仅需要孩子层，递归过程会形成一条递归链】
 *             计算 rob(1) --> 递归计算 rob(2) --> 递归计算 rob(3) --> 递归计算 rob(4) --> 递归边界 rob(5) 原路返回
 *             即每个 rob(root) 确保只需计算一次，返回给父节点后再无需调用，所以无需用 memo 记录
 */

public class Solution_337 {

    /**
     * 递归型动态规划 + 记忆化
     *      dp[root] ==  rob(root) == 以 root 为根节点的二叉树所能偷到的最大金额总数
     *          1、偷当前 root ，则累加偷 4 个孙子子树，即 dp[4 个孙子] == rob(4 个孙子)
     *          2、不偷当前 root ，则累加偷 2 个孩子子树，即 dp[2 个孩子] == rob(2 个孩子)
     *          3、取二者中的最大值
     * 后序遍历：需要计算完 2 个孩子、4 个孙子后才能决定当前的 root
     * @see leetcode.LC_DBFS.Note
     */
    public static Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        // 递归边界：空结点 + 叶子节点（值的来源）
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        // 已经计算过了，记忆化，直接返回
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 偷当前 root
        int steal_root = root.val;
        if (root.left != null) {
            steal_root += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            steal_root += rob(root.right.left) + rob(root.right.right);
        }

        // 不偷当前 root
        int none_steal_root = rob(root.left) + rob(root.right);

        // 取二者中的最大值，并记录下来
        int rootMax = Math.max(steal_root , none_steal_root);

        // 每层确定一个 memo
        memo.put(root , rootMax);
        return rootMax;
    }

    /**
     * 递归型动态规划 + 对返回值结构进行扩展优化（偷 root 和不偷 root 的情况下各自所能偷到的最大金额总数）
     *      1、偷当前 root ，则累加 2 个孩子子树不偷的情况
     *      2、不偷当前 root ，则累加 2 个孩子子树偷或者不偷之间最大的情况
     *      3、两者的结果都需要返回
     * 后序遍历：需要计算完 2 个孩子后才能决定当前的 root
     */
    public int rob2(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0] , res[1]);
    }
    public int[] robTree(TreeNode root) {
        // 递归边界 == 空结点 + 叶子节点
        if (root == null) {
            return new int[]{0 , 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val , 0};
        }

        // 后序遍历
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        // 偷当前 root 还是不偷当前 root
        int      steal_root = root.val + left[1] + right[1];
        int none_steal_root = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);

        // 两种状态都返回给上一层
        return new int[]{steal_root , none_steal_root};
    }
}
