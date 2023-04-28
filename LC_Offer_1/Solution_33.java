package leetcode.LC_Offer_1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 方法一：递归
 *      '左右中'
 *      由尾部的 '中' 遍历区分 '左' 和 '右'
 *      判断当前树是不是二叉搜索树
 *      递归判断 '左' 和 '右' 是不是二叉搜索树
 * 方法二：单调栈
 *      '左右中' --> 逆序 --> '中右左'
 *                          '中' < '右' —— 维护单调递增栈
 *                          '中' < '右' > '左' —— 出栈找中，即 root ，且必须满足此后元素都 < root
 *                          '右' 和 '左' 中也都有微型的类似的子结构
 *                          模拟下 1 2 3 4 5 6 7 这样的树即可知了
 */
public class Solution_33 {
    private boolean recur(int[] postorder , int l , int r) {
        if (l >= r) return true;
        int i = l;
        while (postorder[i] < postorder[r]) i++;
        int m = i;
        while (postorder[i] > postorder[r]) i++;
        return i == r && recur(postorder , l , m - 1) && recur(postorder , m , r - 1);
    }
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder , 0 , postorder.length - 1);
    }
}

class Solution_33_02 {
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> queue = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1 ; i >= 0 ; i--) {
            if (root < postorder[i]) return false;
            while (!queue.isEmpty() && queue.peek() > postorder[i]) root = queue.pop();
            queue.push(postorder[i]);
        }
        return true;
    }
}