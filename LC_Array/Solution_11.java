package leetcode.LC_Array;

public class Solution_11 {

    /**
     * [l ~ r] 的容水量 == min(height[l] , height[r]) * (r - l)<p>
     * 用双指针 l 和 r 欲遍历所有可能的容水量 [l ~ r] ：<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 但其实每次只需向内移动 l 和 r 中较短的木板即可<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 因为移动较长的木板必然会导致容水量减小，那些比当前容水量还小的容水量必然不会是最终 res<p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 只有向内移动较短的木板才有可能导致容水量增大，res 在这个过程中比较、记录最大容水量即可
     */
    public int maxArea(int[] height) {

        int res = 0;
        int l = 0;
        int r = height.length - 1;

        while (l != r) {
            // 不要把 height[l++] 和 height[r--] 提到 * 之前
            // 会导致 * 后面的 (r - l) 使用 ++ 后的 l 、r 新值
            res = height[l] < height[r] ?
                    Math.max(res , (r - l) * height[l++]) :
                    Math.max(res , (r - l) * height[r--]) ;
        }
        return res;
    }
}
