package leetcode.LC_Greedy;

/**
 * 用桶排序记录动态数组的最小值
 *         count[i] 为数字 i 出现的次数
 * 将 -100 <= A[i] <= 100 加 100 映射到 0 ~ 200
 *         -100 ~ -1 ——> 0 ~ 99
 *         0 ——> 100
 *         1 ~ 100 ——> 101 ~ 200
 * 相反数的下标之和为 200
 *        -10 ——> -10 + 100 ——> 90
 *        2 ——> 10 + 100 ——> 110
 */

public class Solution_1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] count = new int[201];
        for (int num : A) { count[num + 100]++; }
        int i = 0;
        while (K > 0) {
            while (count[i] == 0) i++; // 找最小的数字 i
            count[i]--;
            count[200 - i]++;
            if (i > 100) { i = 200 - i; } // 正数变负数，最小值又跳到了负数区域找最小数字 i
            K--;
        }
        int sum = 0;
        for (int j = i ; j < count.length ; j++) { // i 始终指向最小值，j 从 i 开始加起就可以了
            sum += (j-100) * count[j]; // 还原数字 j-100 ——> A[num]
        }
        return sum;
    }
}
