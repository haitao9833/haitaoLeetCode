package leetcode.LC_Array;

public class Solution_202 {

    /**
     * <strong>必有环</strong>
     * @see leetcode.LC_Linked.Solution_141
     * @see Solution_287
     */
    public boolean isHappy(int n) {

        // 初始化同 141 ，因为不需要找环入口
        int slow = n;
        int fast = nextNumber(n);

        while (slow != fast) {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
        }

        // 必有环
        // 判断相遇点是不是 1
        // 且若产生 1 了，则 fast 一定会在 1 原地等 slow 来
        return slow == 1;
    }

    /**
     * 题目确保 1 <= n <= Integer.MAX_VALUE <P>
     * 计算下一个数，即下一个节点 <P>
     * <strong>计算后不会越来越大，会在一个 [0 , 729] 的范围内，总会遇到 1 或者重复的数</strong>
     */
    private int nextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_202().nextNumber(999_999_999));
    }
}
