package leetcode.LC_Offer_1;

import leetcode.LC_50.TreeNode;

/**
 * 双重递归：
 *        一重先序找根节点
 *        一重先序比较子树
 */
public class Solution_26 {
    private boolean check(TreeNode A , TreeNode B) { // 匹配子树
        if (B == null) return true;
        else if (A == null) return false;
        else return A.val == B.val && check(A.left , B.left) && check(A.right , B.right);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) { // 找根节点
        if (A == null || B == null) return false;
        return check(A , B) || isSubStructure(A.left , B) || isSubStructure(A.right , B);
    }
}
