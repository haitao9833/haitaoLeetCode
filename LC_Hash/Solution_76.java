package leetcode.LC_Hash;

public class Solution_76 {

    /**
     * 在 s 中滑动<strong>非固定长度</strong>的窗口 [l , r]<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以使用 cnt 代表 [l , r] 是否匹配 t<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;即不需要一个 windows[] 记录 [l , r] 区间的模式了<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因为条件不像 438 那样苛刻，[l , r] 内可以含有 t 没有的字符<p>
     * 相像一个 x 轴，t 的 pattern 最开始在 x 轴的上方，随着 r 的后移，慢慢消减到 x 轴的下方<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>0 表明 t 中该字符还没匹配完<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=0 表明 t 中该字符恰好匹配完<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<0 表明 t 中该字符匹配多了或不是 t 中字符
     * <hr>
     * <p> 第一次 cnt == lenT 后 cnt 会保持不变，不会再 ++
     * <p> 因为第一次 cnt == lenT 表示 pattern 中所有元素都 <= 0 了，后续不再会有 -- 后还 >=0 了
     * <p> 即之后的每次 r 的后移都会进入 if(cnt == lenT){...} 中判断
     * <p> 且直到 l 指向的 t 字符被后移的 r 多匹配到的时候，才会开始收缩 l
     * @see leetcode.LC_Array.Solution_209
     */
    public String minWindow(String s , String t) {

        int lenS = s.length();
        int lenT = t.length();
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        // t 的模式
        // 直接开 [128] ASCII 码值数组
        int[] pattern = new int[128];
        for (char c : chT) {
            pattern[c]++;
        }

        // cnt 记录 [l , r] 中多少个字符匹配 t
        int l = 0;
        int cnt = 0;
        String res = "";
        for (int r = 0 ; r < lenS ; r++) {
            // 直接操作 t 的模式数组 pattern[]
            // 若 -- 后依然 >= 0
            // 说明匹配到了 t 的字符
            if (--pattern[chS[r]] >= 0) {
                cnt++;
            }

            // 一旦区间 [l , r] 满足涵盖 t
            // 就不断缩小 l 看是否有区间更小但依然涵盖 t 的可能子区间
            if (cnt == lenT) {
                // 移除 l 指向的非 t 字符或者匹配多了的 t 字符
                // 直到 l 指向恰好匹配完的 t 字符
                while (pattern[chS[l]] < 0) {
                    pattern[chS[l]]++;
                    l++;
                }
                if ("".equals(res) || res.length() > r - l + 1) {
                    res = s.substring(l , r + 1);
                }
            }
        }
        return res;
    }
}