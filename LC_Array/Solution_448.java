package leetcode.LC_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_448 {

    /**
     * 把值 [1 , n] 放到下标 [0 , n-1] 处
     * @see Solution_41
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {

        int n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            // 因为有重复元素，所以元素 nums[i] 只需有一个放到下标 nums[i]-1 处即可
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 检查下标与元素值不对应，并收集结果
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 本质同上，不过不实际交换移动，即找到一个元素 x 后则在下标 x-1 处标记一下表示存在 <P>
     * 但标记不能影响该位置原来的元素 nums[x-1] 假设 nums[x-1] == y <P>
     * 设计标记函数（类似 289 生命游戏）：<P>
     *               1 <=         y         <= n                                    <P>
     *          1 + kn <=       y + kn      <= n + kn               （在该位置累加 n） <P>
     *   0==(1+kn-1)%n <=  (y+kn-1)%n==y-1  <= (n+kn-1)%n==n-1      （总能取出该位置原始的值 y）
     * @see leetcode.LC_DBFS.Solution_289
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {

        int n = nums.length;

        // 标记 == 累加 n
        for (int num : nums) {
            nums[(num - 1) % n] += n;
        }

        // 原始元素值都在在区间 [1 , n] 范围内
        // 第二次遍历若 <= n 就是没有被标记过的，即为没有出现的元素
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
