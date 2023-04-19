package leetcode.LC_50;

import java.util.Random;

/**
 * 384
 * 随机打乱数组
 * 又能随时恢复
 * nums 所有元素都是唯一的，假设共 n 个数，则共有 n! 中排列方式，需要保证每次都能等概率地返回这个 n! 中可能性之一
 */
public class Solution {
    int n;
    int nums[];
    Random random = new Random();
    public Solution(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
    }
    public int[] reset() { // 重置的秘诀在于，从不真正打乱原数组
        return nums;
    }
    public int[] shuffle() { // 洗牌算法，核心在于能等概率的产生所有可能的排列情况
        int[] res = nums.clone();
        for (int i = 0 ; i < n ; i++) { // i 用于每次确定一位，每次从剩余的数中确定一位，共 n! 中可能
            swap(res , i , i + random.nextInt(n - i)); // 随机产生 [0 , n - i) ，前面的 nums[0 ~ i-1] 都是确定好的
        }
        return res;
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
