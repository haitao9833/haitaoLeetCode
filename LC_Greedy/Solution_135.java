package leetcode.LC_Greedy;

/**
 * 先从左向右遍历一遍，只看是否比左边大
 *           只要比左边大，就在左边的糖果基础上 + 1
 *           相等或小于左边，糖果数就是 1
 *           因为题目要求是只有评分更高才需要更多糖果数，相同的可以只拿 1 个糖果
 * 再从右向左遍历一遍，只看是否比右边大
 *           当比右边大的时候，看是否已经有 candy[i] > candy[i + 1] 了
 *           已经比右边多拿了，则无需再多拿，非则才在右边的糖果基础上 + 1
 *           用 sum 收集 candy 总数
 */
public class Solution_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            candy[i] = ratings[i - 1] < ratings[i] ? candy[i - 1] + 1 : 1;
        }
        int sum = candy[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) { // 判断是否已经有 candy[i] > candy[i + 1] 了
                candy[i] = candy[i + 1] + 1;
            }
            sum += candy[i];
        }
        return sum;
    }
}
