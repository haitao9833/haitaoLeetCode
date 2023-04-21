package leetcode.LC_Bit;


import leetcode.LC_Linked.Solution_2;

public class Solution_371 {

    /**
     * 计算机的二进制加法：逢二进一 + <strong>最高位的进位直接舍去</strong><P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * &nbsp;5 == 0000_0101<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * -3 == 1111_1101<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * &nbsp;+    ----------------<P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * &nbsp;2 == 0000_0010
     * @see Solution_2
     */
    public int getSum1(int a , int b) {

        int res = 0;
        int up = 0;

        for (int i = 0 ; i < 32 ; i++) {
            // 从低到高依次取每一位 bit
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            if (bitA == 1 && bitB == 1) {
                // up 旧值：上一位运算的进位结果
                res |= (up << i);
                // up 新值：当前位运算的进位结果
                up = 1;
            } else if (bitA == 0 && bitB == 0) {
                res |= (up << i);
                up = 0;
            } else {
                // up 旧值 == 1 ，则该位结果为 (1+0 / 0+1) + 1 == 0 ，且 up 新值 == 1 不变
                // up 旧值 == 0 ，则该位结果为 (1+0 / 0+1) + 0 == 1 ，且 up 新值 == 0 不变
                // 总结：up 旧值新值不变，且该位位置与 up 恰好相反，所以用异或 ^ 运算
                res |= ((1 ^ up) << i);
            }
        }
        // 不考虑最后的进位 up

        return res;
    }

    /**
     * a + b == 不考虑进位的加法 + 所有的进位
     * 例如十进制：
     *        1201
     *      +  879
     *      ------
     *        1070 + 进位 10 + 进位 1000
     * 例如二进制：
     *       5 == 0000_0101
     *      -3 == 1111_1101
     *       +    ---------
     *            1111_1000 + 进位 0000_0010 + 进位 0000_1000
     * 对于二进制来说：
     *      不考虑进位的加法 == a ^ b
     *      所有的进位 == (a & b) << 1
     *      当进位为 0 时，表明 a + b == 不考虑进位的加法
     */
    public int getSum2(int a , int b) {
        while (b != 0) {
            // 更新计算 a 之前，要先用旧值 a 、b 计算所有进位
            // 并用 up 保存，在 a 用旧值 a 、b 更新计算后，再赋给 b
            int up = (a & b) << 1;

            // a == 不考虑进位的加法
            a = a ^ b;

            // b == 所有进位
            b = up;
        }
        return a;
    }

    /**
     * 方法二的递归写法
     */
    public int getSum(int a , int b) {
        return b == 0 ? a : getSum(a ^ b , (a & b) << 1);
    }
}