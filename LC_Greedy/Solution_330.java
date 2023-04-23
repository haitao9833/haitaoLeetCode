package leetcode.LC_Greedy;

/**
 * [] 覆盖范围为 [0 , 0] 下一个需要加入 1
 * [1] 覆盖范围为 [0 , 1] 下一个需要加入 2
 * [1 2] 覆盖范围为 [0 , 3] 下一个需要加入 4
 * [1 2 4] 覆盖范围为 [0 , 7] 下一个需要加入 8
 * [1 2 4 8] 覆盖范围为 [0 , 15]下一个需要加入 16
 * 即从空集合 [] 开始，我们要连续添加入 1 , 2 , 4 , 8 , 16 , ...
 *
 * 从空集 [] 开始考虑，假设当前已经能覆盖 [1 , nextNum-1] 了，下一个应该加入 nextNum 了
 *      但给我们的 nums 并非空集 []
 *      若存在 preNum < nums[i] <= nextNum 则，此时覆盖范围并非 [1 , nextNum-1] 而是 [1 , nextNum-1+nums[i]]
 *            例如 [1 2 4 5] 下一个要加入的是 8+5 = 13 而不是 8 因为 8~12 已经被 [1 2 4] + 5 覆盖了
 *            即下一个应该加入的是 nextNum = nextNum + nums[i]
 *      若 nextNum < nums[i] 是不影响的，此处需要理解 —— 要分清楚覆盖范围和要加入的数
 *            例如 [1 9] 下一个要加入的是 1*2 = 2 而不是 1+9 = 10 因为 2~8 内还未被覆盖
 *            则加入 nextNum 然后继续下一个要加入的数 nextNum = nextNum*2
 */
public class Solution_330 {
    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        int index = 0;// 需要提前记录 nums 的原始长度 len

        int res = 0;
        long nextNum = 1;

        while (nextNum - 1 < n) { // 此时覆盖范围为 [0 , nextNum-1]，还未覆盖到 n 就循环，下一个加入 nextNum
            if (index == len || nextNum < nums[index]) {
                res++;
                nextNum *= 2;
            } else {
                nextNum += nums[index];
                index++;
            }
        }
        return res;
    }
}
