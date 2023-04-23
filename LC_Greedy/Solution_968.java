package leetcode.LC_Greedy;

/**
 * 打家劫舍三 —— 树形 DP
 * 监控二叉树 —— 树形 Greedy
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
} // Definition for a binary tree node.

/**
 * 贪心策略分析：
 *         摄像头覆盖范围：上、中、下三层 ——> 摄像头尽量不要放在边界处，如叶子节点，或者根节点，非则就浪费了一层的覆盖
 *         遍历策略：
 *                从上到下，先从根节点的子节点放起，不保证叶子节点不放摄像头
 *                从下到上，先从叶子节点的父节点放起，不保证根节点不放摄像头
 *                用 4 层的树模拟一下就可以知道：
 *                在第三层放摄像头覆盖的结点数 >= 在第二层放摄像头覆盖的结点数
 *                从第三层开始放摄像头所需的摄像头数 <= 从第二层开始放摄像头所需的摄像头数
 *                即头节点放不放摄像头也就省下 1 个摄像头，而叶⼦节点放不放摄像头省下的是指数级别的数量
 *         得出结论：后序遍历更优、更贪心
 * 状态标签
 *        该节点是摄像头 1
 *        该节点不是摄像头
 *             该节点无覆盖 0
 *             该节点有覆盖 2
 * 空结点状态标签
 *        不能是 0 无覆盖，不然叶子节点就要装摄像头了
 *        不能是 1 摄像头，不然叶子节点的父节点就不需要装摄像头了
 *        所以只能是有覆盖的 2
 * 情况分析
 *
 */
public class Solution_968 {
    private int count = 0;
    public int travel(TreeNode cur) {
        if (cur == null) return 2;       // 空结点

        int left = travel(cur.left);     // 需要取左右孩子的状态标签
        int right = travel(cur.right);

        if (left == 0 || right == 0) {
            count++;
            return 1;
            /**
             * [left , right] = [00 , 01 , 10 , 02 , 20]
             * 左右孩子中有未被被覆盖的情况，则本节点 cur 必须安装摄像头，不管其中是否有孩子是摄像头，例如 01 与 10
             */
        }

        if (left == 1 || right == 1) return 2;
        /**
         * [left , right] = [11 , 12 , 21]
         * 左右孩子中有是摄像头的情况，本节点 cur 肯定已经覆盖
         * 关键点：特殊情况 10 与 01 已经在上面处理了，且必须先处理
         */

        return 0; // 最后一种情况，[22]，左右孩子都有覆盖，且非摄像头，由后序遍历可知，本节点 cur 肯定无覆盖
    }
    public int minCameraCover(TreeNode root) {
        return travel(root) == 0 ? count + 1 : count;
        // 最后还需要处理一下根节点，因为从叶子节点的父节点后序遍历放起，不保证根节点不放摄像头
    }
}
