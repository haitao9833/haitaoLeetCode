package leetcode.LC_Array;

/**
 * 好玩的证明：
 *      candidate 为擂台，count 为擂台上的人数，擂台上没有人的时候，直接上台
 *      如果有人并且是一伙的则上台，即同时站在台上
 *      如果发现擂台上有人但不是一伙的，则不上台，同时拉下去一个
 *      由于非 maj 的人数比 maj 的人数少并且还会自相残杀，所以非 maj 们无法把 maj 们全拉下来
 */

public class Solution_169 {

    /**
     * 题意保证一定存在该多数元素，且该多数元素的个数 - 其他元素的个数 > 0
     * <P>则用多数元素和其他元素两两相消之后，最后必定还剩余 >= 1 个多数元素
     * <P>注意其他元素之间也有可能会相互抵消
     */
    public int majorityElement(int[] nums) {
        // preliminary
        int candidate = 0;
        int cnt = 0;

        // cnt == 0 时的 candidate 所指是无效的
        for (var num : nums) {
            if (cnt == 0) {
                candidate = num;
                cnt = 1;
            } else if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return candidate;
    }
}