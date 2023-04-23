package leetcode.LC_Greedy;

/**
 * gas[i] - cost[i] = everyday_rest[i]
 * 只有当 total_rest_Sum = Sum([0 , length-1]) >= 0 才可以走完一圈
 * 关键要理解：
 *     一旦 cur_rest_Sum  = Sum([startIndex , i]) < 0
 *     说明 [startIndex , i] 内都不可能有出发点，必须从 startIndex = i + 1 开始重新出发
 *     因为 [startIndex , i-1] 内的每一个点的 cur_test_Sum 都是 + 的
 *     从其中任意一点 j 出发，都是抛弃前面 [startIndex  , j-1] 的正值和，不可能加到 i 的时候还更大
 *     计算到最后，只要 total_rest_Sum >= 0 则从此时记录的 startIndex 出发一定可以走完全程
 */
public class Solution_134 {
    public int canCompleteCircuit(int[] gas , int[] cost) {
        int cur_rest_Sum = 0;
        int all_rest_Sum = 0;
        int startIndex = 0;
        for (int i = 0 ; i < gas.length ; i++) {
            all_rest_Sum += gas[i] - cost[i];
            cur_rest_Sum += gas[i] - cost[i];
            if (cur_rest_Sum < 0) {
                startIndex = (i + 1) % gas.length ;
                cur_rest_Sum = 0;
            }
        }
        return all_rest_Sum < 0 ? -1 : startIndex;
    }
}
