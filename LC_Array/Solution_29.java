package leetcode.LC_Array;


import leetcode.LC_String.Solution_166;

public class Solution_29 {

    /**
     * <strong>避免溢出的细节太多了</strong>
     * @see Solution_166
     * @see leetcode.LC_Bit.Solution_7
     */
    public int divide(int dividend , int divisor) {

        // 特判，唯一溢出情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 保存商的正负符号
        // 二进制最高位符号位不同则异或为 1 ，即表明两个数一正一负，即 Math.addExact() 源码技巧
        int sign = 1;
        if ((dividend ^ divisor) < 0) {
            sign = -1;
        }

        // 统一处理 dividend 和 divisor 为负数
        // 因为负数范围比正数范围大 1
        // 测试案例中有个 Integer.MIN_VALUE / 1 == -2147483648 / 1
        // 若都统一为正数，则 -Integer.MIN_VALUE 会溢出
        if (dividend > 0) {
            dividend = - dividend;
        }
        if (divisor > 0) {
            divisor = - divisor;
        }

        int res = 0;

        // 若 dividend 中还有 divisor
        while (dividend <= divisor) {

            // multi 为 divisor 的倍增值    2b  4b  8b  ...
            // times 为 divisor 的倍增个数   2   4   8
            int multi = divisor;
            int times = 1;

            // 若 dividend 中还有 2 倍的 multi
            // 不要写成 dividend <= multi + multi 避免溢出
            // 减法比加法更健壮，要警惕加法
            while (dividend - multi <= multi) {
                multi += multi;
                times += times;
                System.out.printf("%3d , %3d\n" , multi , times);
            }

            dividend -= multi;
            res += times;
        }

        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_29().divide(30 , 8));
    }
}
