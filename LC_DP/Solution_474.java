package leetcode.LC_DP;

public class Solution_474 {

    /**
     * strs[] 为物品列表<p>
     * 背包有两个维度，装入 '0' 的容量 m ，装入 '1' 的容量 n<p>
     * value[] 恒等于 1
     * <hr>
     * 含义重新定义：dp[i][j] 表示容量为 i 个 '0' 和 j 个 '1' 的背包最多能装下多少个二进制字符串<p>
     * 状态转移方程：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dp[i][j] = max(dp[i][j] , dp[i-strZeroNum][j-strOneNum] + 1)<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对比只有一个维度的背包的状态转移方程 dp[j] = max(dp[j] , dp[j-weight[i]] + value[i])<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;strZeroNum 和 strOneNum 就是当前 str 的 weight[i] ，长度 1 就是当前 str 的 value[i]<p>
     * 遍历顺序：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外层物品 str 正序遍历 [0 -> N-1]<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内层背包两个维度都要逆序遍历 [m -> numZero] + [n -> numOne]
     */
    public int findMaxForm(String[] strs , int m , int n) {
        // 初始化
        int[][] dp = new int[m + 1][n + 1];

        // 物品 i 正序遍历 [0 -> N-1]
        for(String str : strs){
            //统计 str 的两个维度的 weight
            int numZero = 0;
            int numOne = 0;
            for (char ch : str.toCharArray()){
                if (ch == '0') {
                    numZero++;
                } else {
                    numOne++;
                }
            }

            for (int i = m ; i >= numZero ; i--){
                for (int j = n ; j >= numOne ; j--){
                    dp[i][j] = Math.max(dp[i][j] , dp[i - numZero][j - numOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
