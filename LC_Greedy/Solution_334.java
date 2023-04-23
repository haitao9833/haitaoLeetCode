package leetcode.LC_Greedy;

/**
 * index = (min , mid , max)
 * 不需要连续
 *
 * 例如 3 5 1 7 ：
 *     min 开始为 3
 *     mid 开始为 5
 *     然后 min 为 1 了，这时候下标位置 mid < min
 *     但不影响 mid 的有效性，即 min 虽然换到了 mid 前面
 *     但是我们知道，换之前的位置总有个数 < mid
 *     即 mid 的本质 —— 总是有个小的数在其前面，但不一定由 min 指向，只要找到一个 mid < x 就可以直接返回 true
 *                     mid 一旦被赋值，不管是第一次还是中间更新，一定说明 mid 之前有个比其小的数
 * 还有一点：
 *         8 9 8 7 6 5 6 4 3 2 1 7
 *         ___       ___
 *         min == 8 && mid == 9 （min 和 mid 总是会在相邻的上升数据依次赋值）
 *         然后 min == 8 7 6 5   （且不管 min 怎么跳动，mid 前面总是有一个有效的 < mid 的数，等待一个 mid < 的数）
 *         min == 5 && mid == 6 （min 和 mid 总是会在相邻的上升数据依次赋值）
 *         再然后 min == 4 3 2 1 （且不管 min 怎么跳动，mid 前面总是有一个有效的 < mid 的数，等待一个 mid < 的数）
 *         当遇到 7 的时候，此时有效的 (min , mid , max) = (5 6 7)
 *
 */
public class Solution_334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x <= min) { // 总是贪心第选择最小的 min
                min = x;
            } else if (x <= mid) { // 总是贪心第选择最小的 mid
                mid = x;
            } else return true;
        }
        return false;
    }
}
