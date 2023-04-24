package leetcode.LC_Hash;

/**
 * {X , cnt} 系列：<p>
 *      594 ：在 nums[] 中找最长和谐子序列的长度
 *      781 ：给出某些兔子的回答 answers[] ，求森林中最少的兔子数量
 *      621 ：两个相同任务之间必须有 n 个单位时间的冷却时间
 *      554 ：自顶向下穿过最少的砖块 == 自顶向下穿过最多的间隙（逆向思维，正难则反）
 *      【字母异位词：字符内容相同、顺序位置不同的两个字符串】
 *          242 ：判断字符串 t 是否为 s 的字母异位词
 *          383 ：判断字符串 ransomNote 能否由 magazine 的字符组成，magazine 中的每个字符只能用一次
 *           49 ：将 strs[] 中的字母异位词分组（用流）
 *         【滑动区间】
 *          438 ：在字符串 s 中找字符串 p 的所有字母异位词
 *           76 ：在字符串 s 中找涵盖字符串 t 的最短连续子串
 *      【排序 cnt 系列】
 *      451 ：对字符串 s 中的字符 ch 按 cnt 降序排序（桶排序）
 *      692 ：对字典 words[] 中的单词 word 按 cnt 降序排序（堆排序）
 *      【Set 的本质 == 一个去重的、可快速搜索的空间，其实 Map 也是，只不过 Map 每次能快速搜索一个元素对】
 *       128 ：求 nums[] 中最长的数值连续序列，不要求下标连续，也不要求保持相对位置，仅要求数值连续
 * <hr>
 * 前缀和系列：<p>
 *      525 ：在二进制 nums[] 中找最长连续子数组，且 0 和 1 的数量相同（{prefixSum , i}）
 *      560 ：求 nums[] 中和为 k 的连续子数组的个数（{prefixSum , cnt}）
 * <hr>
 * 交集双指针系列：<p>
 *      349 ：求 nums1[] 和 nums2[] 的去重交集
 *      350 ：求 nums1[] 和 nums2[] 的非去重交集
 * <hr>
 * 数字和系列：<p>
 *      【感觉应该是 LC_Back】
 *      【一个数组中找】
 *       1 ：两数之和，在 nums[] 中找 a + b == target ，返回其下标，题目保证存在的情况下 {a , b} 唯一
 *      15 ：三数之和，在 nums[] 中找 a + b + c == 0  ，返回所有可能的三元组
 *      16 ：三数之和，在 nums[] 中找 a + b + c == target 或最接近 target ，返回 a + b + c
 *      18 ：四数之和，在 nums[] 中找 a + b + c + d == target ，返回所有可能的四元组
 *      【多个数组中找】
 *      454 ：在 nums1[] 、nums2[] 、nums3[] 、nums4[] 中分别找 a + b + c + d == 0 ，返回所有可能的四元组的数量
 * <hr>
 * 坐标 Hash 系列：
 * （难）149 ：求 points[] 中最多有多少个点在一条直线上
 */

public class Note {

    public static void main(String[] args) {
        strHash("ab");
        strHash("aab");
    }

    /**
     * 字符串的<font style="color:red">进制 Hash </font>算法
     */
    private static void strHash(String str) {
        // 将 [a-z] 视为 [0-25] 即 26 进制容易出问题
        // 当出现前导 0 的 a 时，有 "ab" == 01 == 1 == 001 == "aab"
        int res1 = 0;
        for (char c : str.toCharArray()) {
            res1 = res1 * 26 + (c - 'a');
        }

        // 最好将 [a-z] 视为 [1-26] 即 27 进制
        int res2 = 0;
        for (char c : str.toCharArray()) {
            res2 = res2 * 27 + (c - 'a' + 1);
        }

        System.out.printf("%d , %d\n" , res1 , res2);
    }
}
