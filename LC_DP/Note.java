package leetcode.LC_DP;
import java.util.Arrays;

/**
 * 01 背包系列：<p>
 *      【求总价值最大】
 *       416 ：尽量把   nums[] 分成两个元素和相等的子数组
 *      1049 ：尽量把 stones[] 分成重量相同或相接近的两堆石头，这样相互抵消后剩下的最后一块石头重量最小
 *      【求总价值最大，weight[] ==> 变成两个维度】
 *       474 ：从 strs[] 尽量多选取若干个字符串，但最多有 m 个 '0' 字符和 n 个 '1' 字符
 *      【恰好装满的组合方案数】
 *       494 ：在 nums[] 的每个元素前面添加 "+" 或 "-" 构造一个表达式使之运算结果等于给定值 target ，求可构造多少种这样的表达式
 * <hr>
 * 完全背包系列：<p>
 *      【求恰好装满的情况下总价值最小】
 *      322 ：用最少个数的硬币 coins[] 凑满 amount（不一定能装满：设为无效状态 +∞ == 上限 + 1）
 *      279 ：用最少个数的完全平方数凑满整数 n（必能装满：初始化为最坏情况）
 *      【恰好装满的组合方案数】
 *      518 ：用硬币 coins[] 凑满 amount 有几种组合方案
 *      【恰好装满的排列方案数】
 *       70 ：每次爬 1 或 2 阶，爬到第 n 阶共几种排列方案
 *      377 ：用数字 nums[] 凑出值 target 有几种排列方案
 * <hr>
 * 回文系列：<p>
 *        5 ：最长回文子串，要求连续
 *      516 ：最长回文子序列，不要求连续
 *      647 ：统计回文子串（连续）的个数，内容相同但位置不同的回文子串，视为不同的回文子串
 *      132 ：将 s 分割为回文子串的最少分割次数
 * <hr>
 * 路径条数系列：<p>
 *      62 ：只能向下或者向右移动一步
 *      63 ：只能向下或者向右移动一步 + 障碍物
 *      64 ：只能向下或者向右移动一步 + 路径上数字总和最小
 *      746 ：给定楼梯台阶 cost[] ，从下标 0 或下标 1 开始爬，每次爬 1 阶或 2 阶，求爬到第 n 阶的最小代价
 * <hr>
 * 打家劫舍系列：<p>
 *      198 ：给定 nums[] 代表每家每户的金额数，在不能偷连续两家的情况下，求能偷到的最大金额总数
 *      213 ：在 198 的基础上多加了一个条件 nums[] 代表的房间首尾相连、围成一圈，即 nums[0] 和 nums[n-1] 为相邻房间
 *      337 ：树形递归 dp ，房间布局为一颗二叉树，不能偷连续的两个节点
 * <hr>
 * 连续子数组系列：<p>
 *       32 ：找出连续的、最长的、有效的 '(...)' 括号表达式
 *       53 ：连续子数组最大和（子数组最少要包含 1 个元素）
 *      152 ：连续子数组最大乘积（子数组最少要包含 1 个元素）
 *      674 ：最长连续递增子数组
 *      718 ：求 nums1[] 和 nums2[] 中公共的、最长的、连续子数组的长度
 *      413 ：求 nums[] 中所有连续等差数列的个数，等差数列至少要有 3 个元素
 * <hr>
 * 完全分割系列：<p>
 *       91 ：编码 [A~Z] == [1~26] ，求给定数字字符串 s 的解码方案总数
 *      139 ：判断是否可以用字典 wordDict[] 中的单词拼接出字符串 s ，字典中的每个单词都可以重复使用
 *      140 ：回溯收集 139 所有可能的划分方案
 * <hr>
 * 不连续子序列系列：
 *        115 ：判断字符串 s 中为字符串 t 的子序列有多少个
 *        392 ：判断字符串 s 是否为字符串 t 的子序列，不要求连续，但要求保持相对位置
 *        300 ：最长递增子序列 （可类比于上述 674）
 *       1143 ：求 text1 和 text2 的公共的、最长的、子序列的长度（可类比上述 718）
 *       1035 ：求 nums1[] 和 nums2[] 的公共的、最长的、子序列的长度（可类比上述 718）
 *      【编辑距离】
 *        72 ：将单词 word1 通过 --> 增、删、改 --> 转换成单词 word2 所需的最少操作次数
 *       583 ：单词 word1 和 word2 通过 --> 删 --> 转换成相同字符串所需的最少操作次数
 *
 * 正则表达式匹配系列：
 *      10 ： '.' 匹配任意单个字符，'*' 匹配 0~n 个前面那个字符，".*"  匹配 0~n 个任意单个字符
 *      44 ： '?' 匹配任意单个字符，'*' 匹配 0~n 个任意字符
 *
 * 买卖股票系列：
 *      121 ：只能买卖 1 次
 *      122 ：可以买卖 n 次
 *      123 ：最多买卖 2 次
 *      188 ：最多买卖 K 次
 *      309 ：可以买卖 n 次 + 冷冻期（卖出后的第二天不能买入股票）
 *      714 ：可以买卖 n 次 + 手续费（每笔买入卖出都要支付手续费）
 *
 * 数学：
 *       96 ：求由 n 个节点 [1 , 2 , ... , n] 能组成的互不相同的二叉搜索树有多少种
 *      343 ：将正整数 n 拆分为 2 <= 个正整数，求这若干个正整数的最大乘积
 *      509 ：斐波那契数列 F(0) = 0 ，F(1) = 1 ，F(n) = F(n - 1) + F(n - 2) 求 F(n)
 *
 * 正方形系列：
 *      221 ：在由字符 '0' 和 '1' 组成的矩阵 matrix[][] 中找到只包含字符 '1' 的最大正方形的面积
 *     1277 ：在由数字  0  和  1  组成的矩阵 matrix[][] 中计算只包含数字  1  的正方形的个数
 *
 * 跳跃游戏系列：
 *     1340 ：可以从任意下标开始跳跃，每次向左或向右跳 [1 ~ d] 步，且只能跳至、跳过比自己更低的柱子，求最多可以访问的柱子数
 *     1696 ：从下标 0 开始向前跳 [1 ~ k] 步，求跳到最后一个下标 n-1 的最大的分
 *     1871 ：从下标 0 开始向前跳 [minJump , maxJump] 步，且每次只能从 '0' 跳到 '0' ，判断是否能跳到最后一个下标 n-1 的 '0' 处
 *
 * 其他：
 *      312 ：戳气球，求收益最大
 */

public class Note {

    /**
     * 不考虑 value < 0 的物品
     */
    public static void main(String[] args) {
        int[] weights = new int[]{1 , 3 , 4};
        int[]  values = new int[]{15 , 20 , 30};
        int W = 4;

//        biDimensionalBag(weights, values, W);
//        System.out.println();
//        unDimensionalBag(weights , values , W);
//        System.out.println();

//        biDimensionalTBag(weights , values , W);
//        System.out.println();
//        unDimensionalTBag(weights , values , W);
//        System.out.println();

//        int[] weight = new int[]{1 , 2 , 5};
//        W = 5;
//        similarTo494TBag(weight , W);
    }

    /**
     * 01 背包二维算法
     */
    private static void biDimensionalBag(int[] weights , int[] values , int W) {
        // 物品个数
        int n = weights.length;

        // 策略一：内层 j 正序
        int[][] dp1 = new int[n][W + 1];
        for (int j = weights[0] ; j <= W ; j++) {
            dp1[0][j] = values[0];
        }
        for (int i = 1 ; i < n ; i++) {
            for (int j = 0 ; j <= W ; j++) {
                if (j < weights[i]) {
                    dp1[i][j] = dp1[i - 1][j];
                } else {
                    dp1[i][j] = Math.max(dp1[i - 1][j] , dp1[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        // 策略一：内层 j 逆序
        int[][] dp2 = new int[n][W + 1];
        for (int j = weights[0] ; j <= W ; j++) {
            dp2[0][j] = values[0];
        }
        for (int i = 1 ; i < n ; i++) {
            for (int j = W ; j >= 0 ; j--) {
                if (j < weights[i]) {
                    dp2[i][j] = dp2[i - 1][j];
                } else {
                    dp2[i][j] = Math.max(dp2[i - 1][j] , dp2[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        // 策略二
        int[][] dp3 = new int[n][W + 1];
        for (int j = weights[0] ; j <= W ; j++) {
            dp3[0][j] = values[0];
        }
        for (int j = 0 ; j <= W ; j++) {
            for (int i = 1 ; i < n ; i++) {
                if (j < weights[i]) {
                    dp3[i][j] = dp3[i - 1][j];
                } else {
                    dp3[i][j] = Math.max(dp3[i - 1][j] , dp3[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        for (int i = 0 ; i < dp3.length ; i++) {
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp3[i]));
        }

        boolean flag = true;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <= W ; j++) {
                if (dp1[i][j] != dp2[i][j]) {
                    flag = false;
                } else if (dp2[i][j] != dp3[i][j]){
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("True : dp1 == dp2 == dp3");
        } else {
            System.out.println("False : Wrong algorithm !!!");
        }
    }

    /**
     * 01 背包一维算法 & 恰好装满
     */
    private static void unDimensionalBag(int[] weights , int[] values , int W) {
        // 物品个数
        int n = weights.length;

        System.out.println("同上述 dp1、dp2、dp3 求背包装得下的最大物品总价值：");
        int[] dp = new int[W + 1];
        for (int i = 0 ; i < n ; i++) {
            for (int j = W ; j >= weights[i] ; j--) {
                dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }

        System.out.println("\n求使得背包必须装满的情况下，总价值最大，四种情况全都考虑：");
        dp = new int[W + 1];
        int min = Integer.MIN_VALUE;
        Arrays.fill(dp , min);
        dp[0] = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = W ; j >= weights[i] ; j--) {
                if (dp[j] == min && dp[j - weights[i]] == min) {
                    dp[j] = min;
                } else if (dp[j] == min && dp[j - weights[i]] != min) {
                    // 存在有效状态，一定要取有效状态
                    dp[j] = dp[j - weights[i]] + values[i];
                } else if (dp[j] != min && dp[j - weights[i]] == min) {
                    // 存在有效状态，一定要取有效状态
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
                }
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }

        System.out.println("求使得背包必须装满的情况下，总价值最大，简化实现：");
        dp = new int[W + 1];
        Arrays.fill(dp , Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = W ; j >= weights[i] ; j--) {
                dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
                if (dp[j] < 0) {
                    dp[j] = Integer.MIN_VALUE;
                }
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }

        System.out.println("\n求使得背包必须装满的情况下，总价值最小，四种情况全都考虑：");
        dp = new int[W + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp , max);
        dp[0] = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = W ; j >= weights[i] ; j--) {
                if (dp[j] == max && dp[j - weights[i]] == max) {
                    dp[j] = max;
                } else if (dp[j] == max && dp[j - weights[i]] != max) {
                    // 存在有效状态，一定要取有效状态
                    dp[j] = dp[j - weights[i]] + values[i];
                } else if (dp[j] != max && dp[j - weights[i]] == max) {
                    // 存在有效状态，一定要取有效状态
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j] , dp[j - weights[i]] + values[i]);
                }
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }

        System.out.println("求使得背包必须装满的情况下，总价值最小，实现策略二（简洁版）：");
        dp = new int[W + 1];
        // 取 +∞ == 0x3f3f3f3f
        Arrays.fill(dp , 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = W ; j >= weights[i] ; j--) {
                dp[j] = Math.min(dp[j] , dp[j - weights[i]] + values[i]);
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }
    }

    /**
     * 完全背包二维算法
     */
    private static void biDimensionalTBag(int[] weights , int[] values , int W) {
        // 物品个数
        int n = weights.length;

        // 策略一：外层 i 正序，内层 j 正序
        int[][] dp1 = new int[n][W + 1];
        for (int j = weights[0] ; j <= W ; j++) {
            dp1[0][j] = dp1[0][j - weights[0]] + values[0];
        }
        for (int i = 1 ; i < n ; i++) {
            for (int j = 0 ; j <= W ; j++) {
                if (j < weights[i]) {
                    dp1[i][j] = dp1[i - 1][j];
                } else {
                    dp1[i][j] = Math.max(dp1[i - 1][j] , dp1[i][j - weights[i]] + values[i]);
                }
            }
        }

        // 策略二：外层 j 正序，内层 i 正序
        int[][] dp2 = new int[n][W + 1];
        for (int j = weights[0] ; j <= W ; j++) {
            dp2[0][j] = dp1[0][j - weights[0]] + values[0];
        }
        for (int j = 0 ; j <= W ; j++) {
            for (int i = 1 ; i < n ; i++) {
                if (j < weights[i]) {
                    dp2[i][j] = dp2[i - 1][j];
                } else {
                    dp2[i][j] = Math.max(dp2[i - 1][j] , dp2[i][j - weights[i]] + values[i]);
                }
            }
        }
        for (int i = 0 ; i < dp2.length ; i++) {
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp2[i]));
        }

        boolean flag = true;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <= W ; j++) {
                if (dp1[i][j] != dp2[i][j]) {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("True : dp1 == dp2");
        } else {
            System.out.println("False : Wrong algorithm !!!");
        }
    }

    /**
     * 完全背包一维算法
     */
    private static void unDimensionalTBag(int[] weights , int[] values , int W) {
        // 物品个数
        int n = weights.length;

        // 初始化
        int[] dp = new int[W + 1];

        // 先遍历物品 i 再遍历背包 j
        for (int i = 0 ; i < n ; i++) {
            for (int j = weights[i] ; j <= W ; j++) {
                dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
            }
            System.out.printf("weight[i] = %d  且 values[i] = %d   " , weights[i] , values[i]);
            System.out.println(Arrays.toString(dp));
        }
        System.out.println();

        Arrays.fill(dp , 0);
        // 先遍历背包 j 再遍历物品 i
        for (int j = 0 ; j <= W ; j++) {
            for (int i = 0 ; i < n ; i++) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
                }
            }
            // 中间行没意义
            System.out.println(Arrays.toString(dp));
        }
        // 只有最后一行才有意义
        System.out.println(Arrays.toString(dp));
    }

    /**
     * 完全背包恰好装满的方案数的组合 & 排列
     */
    private static void similarTo494TBag(int[] weights , int W) {
        // 物品个数
        int n = weights.length;

        System.out.println("求装满背包的组合方案数：");
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int i = 0 ; i < n ; i++) {
            for (int j = weights[i] ; j <= W ; j++) {
                dp[j] += dp[j - weights[i]];
            }
            System.out.println(Arrays.toString(dp));
        }


        System.out.println("求装满背包的排列方案数：");
        dp = new int[W + 1];
        dp[0] = 1;
        for (int j = 0 ; j <= W ; j++) {
            for (int i = 0 ; i < n ; i++) {
                if (weights[i] <= j) {
                    dp[j] += dp[j - weights[i]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
