package leetcode.LC_Array;

public class Solution_189 {

    /**
     *         ---->==>
     * 全部翻转：<==<----
     * 局部翻转：==><----
     * 局部翻转：==>---->
     * reverse(nums[] , l , r) == 翻转 nums[l ~ r] 部分
     */
    public void rotate(int[] nums, int k) {
        // preliminary
        int n = nums.length;

        // k 需对 n 取余一下
        k %= n;

        reverse(nums , 0 , n - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , n - 1);
    }
    private void reverse(int[] nums , int l , int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }

    /**
     * 每个 nums[i] 最终要放到 nums[(i + k) % n] 处
     * 例如 nums[0] --> nums[(0 + k)%n] --> nums[(0 + k + k)%n] --> ... --> nums[0]
     * 且一轮下来最后一定会回到 nums[0] == nums[(0 + n * k)%n]
     */
    public void rotate2(int[] nums, int k) {
        // preliminary
        int n = nums.length;
        int times = n;
        if (k % n == 0) {
            return;
        }

        // i 代表每一轮的起点
        // pre 代表要移动的元素
        // p 代表 pre 要移动到的下标
        int i = 0;
        int p = i;
        int pre = nums[i];

        // 移动 times == n  次后结束
        while (times-- != 0) {
            // 计算 p 且还需用 temp 保存 p 位置原来的元素
            p = (p + k) % n;
            int temp = nums[p];
            nums[p] = pre;
            pre = temp;

            // 一轮移完了，开始下一轮
            if (p == i) {
                i++;
                p = i;
                pre = nums[i];
            }
        }
    }
}
