package leetcode.LC_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * A 、B 、C 三点共线
 *      A[y] - B[y]      B[y] - C[y]
 * k == ———————————  ==  ———————————   ---->   (A[y] - B[y]) * (B[x] - C[x]) == (B[y] - C[y]) * (A[x] - B[x])
 *      A[x] - B[x]      B[x] - C[x]
 */

public class Solution_149 {

    /**
     * 对每一个点 point[i] 枚举计算 {point[i] , point[i+1 , n-1]} 的斜率存储到 HashTable == {k , k 出现的次数}
     * <P> 至于 point[i] 与 point[0 , i-1] 点之间的斜率，已经在对 point[0 , i-1] 枚举时计算过了
     * <P> 设计斜率 k == (yj - yi) / (xj - xi) == up / down 的 Hash 函数，即 Hash(up , down)
     * <P> 若分子为 0 则令分母为 1 表示与 point[i] 在同一条水平线 y == yi 上的点对应的斜率都为 Hash(1 , 0)
     * <P> 若分母为 0 则令分子为 1 表示与 point[i] 在同一条垂直线 x == xi 上的点对应的斜率都为 Hash(0 , 1)
     * <P> 否则简化为最简分数，并将负号统一移至 down 处
     * <P> 题意有  -10^4 <= xi , yi <= 10^4
     * <P> 则处理后有 0 <= up <= 2 * 10^4 , -2 * 10^4 <= down <= 2 * 10^4
     * <P> 然后可使用 36 的坐标 Hash 函数 (up , down) == up + down * rangeUp
     * <P> 优化一：当找到一条直线经过 > n/2 个点时，该直线即为经过点数最多的直线，可用反证法证明
     * <P> 优化二：从当前点 point[i] 的直线出发最多只能找 n - i 个点共线
     */
    public int maxPoints(int[][] points) {
        // preliminary
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        // 初始化
        int res = 1;

        for (int i = 0 ; i < n ; i++) {
            // 两个优化
            if (res > n / 2 || res >= n - i) {
                return res;
            }

            // 枚举计算 {point[i] , point[i+1 , n-1]} 连线的斜率并记录其中的最大值
            // 即为从 point[i] 出发的直线最多能经过多少个点
            int maxK = 0;
            Map<Integer , Integer> map = new HashMap<>();

            for (int j = i + 1 ; j < n ; j++) {

                int up = points[j][1] - points[i][1];
                int down = points[j][0] - points[i][0];

                // 预处理 Hash(up , down) 的参数
                if (up == 0) {
                    down = 1;
                } else if (down == 0) {
                    up = 1;
                } else {
                    if (up < 0) {
                        up = -up;
                        down = -down;
                    }
                    int k = gcd(Math.abs(up) , Math.abs(down));
                    up /= k;
                    down /= k;
                }

                // Hash(k) == Hash(up , down) == hashKey
                int hashKey = up + down * 20001;

                map.put(hashKey , map.getOrDefault(hashKey , 0) + 1);
                maxK = Math.max(maxK , map.get(hashKey));
            }

            // res 记录全局最优
            // maxK 记录对 point[i] 来说的最优
            res = Math.max(res , maxK + 1);
        }
        return res;
    }

    /**
     * 辗转相除法求最大公约数 O(log(n))
     * <P> 令 a 和 b 的最大公约数为 k
     * <P> a == x * k
     * <P> b == y * k
     * <P> 则 x 与 y 一定是互质的
     */
    private int gcd(int a , int b) {
        // 若第一次调用时 a < b 即 gcd(小 , 大)
        // 则会进入递归 (b , a) 即 gcd(大 , 小)
        // 然后后续的递归都会是 gcd(大 , 小)
        return b == 0 ? a : gcd(b , a % b);
    }
}

