package leetcode.LC_Bit;

/**
 * 模拟加法系列：<p>
 *      371 ：求 a 和 b 的和，不能用 + 、- 符号
 * <hr>
 * 快速幂系列：<p>
 *       50 ：x^n
 *      231 ：判断 n == 2^x
 *      342 ：判断 n == 4^x
 *      326 ：判断 n == 3^x
 * <hr>
 * Integer 源码系列：<p>
 *      190 ：翻转二进制
 *      191 ：汉明重量，二进制 1 的个数
 *      461 ：汉明距离，两个整数的二进制中不同的位的个数
 *      338 ：求 [0 ~ n] 每个数的二进制中 1 的个数
 * <hr>
 * 十进制系列：<p>
 *       7 ：翻转十进制
 *       9 ：判断 x 是否为回文数
 * <hr>
 * 字符串 --> 二进制系列：<p>
 *      318 ：求 words[] 中 len(word1) * len(word2) 的最大值，要求 word1 和 word2 不能含有相同的字母
 * <hr>
 * 镜像倍增系列：
 *      89 ：格雷编码
 */

public class Note {

    public static void main(String[] args) {
//        bitQuotient(8 , 2);
//        bitQuotient(-8 , 2);
//        bitQuotient(10 , 2);
//        bitQuotient(-10 , 2);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(-Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE == -Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(-Integer.MIN_VALUE);
//        System.out.println(Integer.MIN_VALUE == -Integer.MIN_VALUE);

//        lowBit(0b101100);
//        lowBit(Integer.MIN_VALUE);
//        System.out.println(0b101100 & (-0b101100));
//        System.out.println();
//        System.out.println(Integer.MAX_VALUE & (-Integer.MAX_VALUE));

//        int i = Integer.MAX_VALUE;
//        int j = Integer.MIN_VALUE;
//        System.out.println(i & (-i));
//        System.out.println(j & (-j));
//        System.out.println(i & ( i ^ (i - 1)));
//        System.out.println(j & ( j ^ (j - 1)));
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(Integer.toBinaryString(j));
//        System.out.println(i & (i - 1));
//        System.out.println(j & (j - 1));
    }

    /**
     * 取二进制中最低位的 1
     */
    public static void lowBit(int num) {
        //int num = 0b101100;
        while (num != 0) {
            int low = num & (-num);
            System.out.printf("该 1 为二进制从最低位 0 开始的第 %d 位：%s\n"
                    , Integer.bitCount(low - 1)
                    , Integer.toBinaryString(low));
            num &= (num - 1);
        }
    }

    /**
     * / 与 >>
     */
    private static void bitQuotient(int i , int bit) {
        System.out.printf("%4d  / %4d = %4d \n" , i , (1 << bit) , i / (1 << bit));
        System.out.printf("%4d >> %4d = %4d \n" , i , bit , i >> bit);
        System.out.println("-----");
    }
}
