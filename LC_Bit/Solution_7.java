package leetcode.LC_Bit;

public class Solution_7 {

    /**
     * 不能使用 Math.addExact() 源码技巧
     * <P> 判断 int 加法溢出：
     * <P>             (新值 == 旧值 * 10 + digit) && (新值 / 10 !== 旧值)
     * <P>             相当于在旧值的个位数处推入一个 digit 得到了新值
     * <P>             但新值将该个位数去掉后不等于旧值，表明 int 溢出了
     * @see leetcode.LC_Array.Solution_29
     */
    public int reverse1(int x) {
        int res = 0;

        while (x != 0) {

            int digit = x % 10;

            // 记录 res 旧值再更新 res
            int pre = res;
            res = pre * 10 + digit;

            // 判断是否 int 溢出（不能使用 Math.addExact() 源码技巧，万一 res 和 pre 都是负数，则判断不对）
            if (res / 10 != pre) {
                return 0;
            }

            x /= 10;
        }
        return res;
    }
}
