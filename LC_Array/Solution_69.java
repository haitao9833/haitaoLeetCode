package leetcode.LC_Array;

public class Solution_69 {

    /**
     * 导数求斜率（牛顿迭代法）<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f(x) = x^2 - a<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f'(x) = 2x<p>
     * 不断逼近与 X 轴的焦点
     */
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    /**
     * 二分法模板三：找<strong>最后一个</strong> mid * mid <= x 的 mid
     */
    public int mySqrt2(int x) {
        // 预先特判
        if (x == 0 || x == 1) {
            return x;
        }

        // 初始化
        // l 的初始化为 1 因为上面已经预先特判了 x == 0 或 1 的情况了
        // r 的初始化可以优化：求解 x/2 <= sqrt(x) 解得 x <= 4 即除了 [0 , 4] 之外，其他正整数 x 都有 x/2 > sqrt(x)
        int l = 1;
        int r = x / 2;

        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (mid <= x / mid) {
                // 避免 mid * mid 溢出
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 有精度要求的牛顿法
     */
    public static double sqrt(int x) {
        // 0 不能作为分母
        if (x == 0) {
            return 0;
        }

        // 精度 10^{-7} 小数点后第 7 位
        double precision = 1e-7;
        System.out.println(precision);

        // x{i} 和 x{i+1}
        double preX = x;
        double curX = 0;

        while (true) {
            curX = (preX + x / preX) / 2;
            // 判断精度
            if (Math.abs(curX - preX) < 1e-7) {
                break;
            }
            preX = curX;
        }
        return curX;
    }
    public static void main(String...args) {
        System.out.println(sqrt(2));
    }
}