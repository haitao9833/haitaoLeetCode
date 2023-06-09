package leetcode.LC_DBFS;

/**
 * 记忆化深搜最优系列：<p>
 *      【记忆化 memo 避免重复计算，每层要能确定一个 memo 记录】
 *      【递归中要 +1 ，记 2023.3.18 美团在线笔试麻了】
 *      329 ：在 matrix[][] 中找最长递增路径的长度
 *      638 ：用 price[] 和 special[] 满足 needs[] 的最低花费，且不能超出 needs[] ，且 special[] 无限
 *      576 ：可以将球移出边界的路径数量
 *       79 ：在 board[][] 中找 word（是一种深搜回溯，应该放在 LC_Back 里的，懒得移动了，搜索的顶级优化）
 * <hr>
 * 最短距离、广搜、层思想系列：<p>
 *      【通常定义目标层为第 0 层】
 *      1345 ：求从下标 0 跳到下标 n-1 的最少跳跃次数，每次能向左跳一步 & 向右跳一步 & 跳到值相同处
 *      1306 ：从下标 i 向左跳到下标 i-arr[i] 或向右跳到下标 i+arr[i] 处，判断是否能跳到 0 元素处
 *       542 ：计算 01 矩阵 mat[][] 中的每个 1 到最近的 0 的距离，上下左右距离为 1
 *       127 ：双向 bfs ，妙啊（难题）（遗留问题）
 *      【逆向思维妙啊妙啊妙】
 *      130 ：在 board[][] 中找到被 'X' 包围的 'O' ，边界上的 'O' 不算被包围，与边界上的 'O' 上下左右相邻的 'O' 也不算被包围
 *      289 ：在 board[][] 中活细胞为 1 ，死细胞为 0 ，依据规则更新为下一状态的 board[][]
 * <hr>
 * 岛屿系列：<p>
 *      【 0 == 海洋 ，1 == 未访问陆地，2 == 已访问陆地，上下左右相连的 '1' 算一块岛屿】
 *      【深搜真是简洁啊，就是稍微修改一下递归边界条件和递归返回值即可】
 *      200 ：求有多少块岛屿
 *      463 ：求岛屿的周长，题目确保仅有一块岛屿，即与海洋相连或与 grid[][] 边界相连的边数
 *      695 ：求面积最大的岛屿
 * <hr>
 * 拓扑排序系列：<p>
 *      【邻接表 + 入度表】
 *      207 ：能否拓扑排序（深搜写法的 vis[] 有点上述 memo 的意思）
 *      210 ：返回拓扑排序序列
 * <hr>
 * 判断方案是否存在系列：
 *      【递归返回值为 boolean ，只要找到一种方案就不找了，立马返回】
 *       212 ：在 board[][] 中找 words[]（难题）（遗留问题）
 *       698 ：将 nums[] 等分为 k 个子集，每个子集的和相同（难题）（遗留问题）
 *       756 ：用三元组 allowed[] 和基底 bottom 搭建金字塔（难题）（遗留问题）
 *
 * 括号系列：
 *      【有效括号表达式：从左到右，始终保持 l >= r ，且在表达式最后一个字符处，必有 l == r】
 *       22 ：生成包含 n 对括号的有效括号表达式，返回所有可能的生成结果
 * （难）301 ：删除字符串 s 最少数量的无效括号，使之成为有效括号表达式，返回所有可能的结果
 *
 * 其他：
 *      529 ：扫雷游戏，返回点击一次 click[]{x,y} 之后的 board[][] 的状态
 */

public class Note {

    /**
     * 递归返回值为 int ：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、累加求方案数<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、求周长、面积
     */
    public static void main(String[] args) {
    }
}
