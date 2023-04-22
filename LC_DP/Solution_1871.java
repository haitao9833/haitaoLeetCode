package leetcode.LC_DP;

/**
 * 一维转常量后，常量范围为一个窗口，可以对该窗口进行某些优化，同 1696
 */

public class Solution_1871 {

    /**
     * dp 动态规划
     * 含义：dp[i] 表示下标 i 处可达
     * 状态转移：
     *      【划分一：s[i] 是 '0' 还是 '1'】
     *      【划分二：s[i] 是 '0' 的情况下，前面 dp[i-maxJump ~ i-minJump] 是否可达】
     *      dp[i] = false     s[i] == '1'
     *      dp[i] = true      s[i] == '0' && dp[max(0,i-maxJump) ~ i-minJump] 有一个为 true 即可
     *      【项分析：i 基于 [max(0,i-maxJump) ~ i-minJump] 则 i 必须正序遍历】
     *      【且仅需保证至少 [0 ~ i-minJump] 有效即可，所以 i 正序遍历 [minJump -> n-1]】
     *      【且配合初始化 i = [0 ~ minJump-1] 的情况，内部的 j 正序、逆序无所谓】
     * 遍历顺序：【综上】
     * 初始化：
     *      dp[0] = true
     *      dp[1 ~ minJump] = false    因为从下标 0 处开始至少要跳 minJump 步
     *
     * dp[max(0,i-maxJump) ~ i-minJump] 即为一维化常量空间优化算法的常量窗口
     * 状态转移仅需判断该窗口内是否有一个 true ，则可用 cnt 记录该窗口内 true 的个数
     */
    public boolean canReach1(String s, int minJump, int maxJump) {
        // preliminary
        int n = s.length();
        char[] ch = s.toCharArray();
        if (ch[n - 1] == '1') {
            return false;
        }

        // 初始化，初始窗口 dp[0 ~ minJump-1] 中 true 的个数为 1
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int cnt = 1;

        for (int i = minJump ; i < n ; i++) {
            if (ch[i] == '0' && cnt != 0) {
                dp[i] = true;
            }

            // 下一轮 dp[i+1] 的窗口 == 对当前窗口向右滑动一位
            // 若在最左端把一个 true 滑动出去了，则 cnt--
            if (maxJump <= i && dp[i - maxJump]) {
                cnt--;
            }

            // 若在最右端把一个 true 滑动进来了，则 cnt++
            if (dp[i - minJump + 1]) {
                cnt++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 逆向思考：dp[i] 依赖前面的 dp[max(0,i-maxJump) ~ i-minJump]
     * 正向思考：dp[i] 影响后面的 dp[i+minJump , min(i+maxJump,n-1)]
     *
     * 和 1696 的正向思考略有不同如下：
     *         1、在 1696 的正向思考中 dp[i] 影响完 dp[i+1 , min(i+k,n-1)] 后，
     *            区间 dp[i+1 , min(i+k,n-1)] 中的某些 dp[j] 还要继续受 dp[i+1] 、dp[i+2] 等等的影响，并取其中最大的影响
     *            而此处的 dp[i+minJump , min(i+maxJump,n-1)] 受 dp[i] 影响过后，即表明可达
     *            无需再用 dp[i+1] 、dp[i+2] 等去判断是否可达了，即有一种可达方案即可
     *            所以可以无需再依赖 dp[] 数组记录是否可达，直接对可达的 '0' 标记为 '2' ，表明此处的 '0' 可达
     *            且后续的遍历仅需对 s[i] == '2' 处的 i 考虑其对后续 s[i+minJump , min(i+maxJump,n-1)] 的影响
     *         2、此处的 s[i] 影响完区间 s[i+minJump , min(i+maxJump,n-1)] 后
     *           继续遍历某个 '2' == s[i+x] 对区间 s[i+minJump+x , min(i+maxJump,n-1)+x] 的影响
     *           则两个区间可能有重复区间，可以优化、避免
     */
    public boolean canReach2(String s, int minJump, int maxJump) {
        // preliminary
        int n = s.length();
        char[] ch = s.toCharArray();
        if (ch[n - 1] == '1') {
            return false;
        }

        // limit 记录未被影响过的区间的开始下标
        ch[0] = '2';
        int limit = 1;

        for (int i = 0 ; i < n ; i++) {

            // 此 i 处为 '2' 可达时，才考虑该 i 对后续窗口 [i+minJump , i+maxJump] 的影响
            if (ch[i] == '2') {
                for (limit = Math.max(limit , i + minJump) ; limit <= Math.min(i + maxJump , n - 1) ; limit++) {
                    if (ch[limit] == '0') {
                        ch[limit] = '2';
                    }
                }

                // 如果最后一个 n - 1 的 '0' 已经被影响为 '2' 表示可达了，则返回 true
                if (ch[n - 1] == '2') {
                    return true;
                }
            }
        }
        return false;
    }
}