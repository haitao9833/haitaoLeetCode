package leetcode.LC_Array;


public class Solution_204 {

    /**
     * 埃氏筛
     * <P> 最小的质数是 2
     * <P> 给定范围 [2 , n] ，从已知的质数 2 开始，将 2 的倍数 4 、 6 、8 、... 皆标记为非质数
     * <P> 然后继续从 2 向后遍历，遍历遇到未标记的则必为质数，然后同上再将该质数的倍数标记为非质数
     * <P> 小优化：
     * <P> 标记一个质数 x 的倍数 2x 、3x 、4x 、5x 、... 、 (x-1)*x 、x*x 、... 从 x*x 开始即可
     * <P> 因为前面的倍数 kx （2 <= k <= x-1）必然已经被标记过了，证明如下：
     * <P> 若 k 为质数，则 kx 必然已经在标记 k 的倍数过程中标记过了
     * <P> 若 k 为合数，则 kx 必然已经在标记 k 的质因子的倍数过程中标记过了
     */
    public int countPrimes(int n) {
        // res[i] == false 即 i 为质数（数组的默认值为 false）
        // res[i] == true  即 i 非质数
        boolean[] res = new boolean[n];

        int cnt = 0;
        for (int i = 2 ; i < n ; i++) {
            if (!res[i]) {
                // 遇到 false 即为质数
                cnt++;

                // 避免数组越界：判断 x * x < n
                // 避免乘法越界：使用 (long) x * x
                if ((long) i * i < n) {
                    for (int j = i * i ; j < n ; j += i) {
                        res[j] = true;
                    }
                }
            }
        }
        return cnt;
    }
}
