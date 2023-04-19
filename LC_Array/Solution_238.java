package leetcode.LC_Array;

public class Solution_238 {

    /**
     * <P> 从左到右：累乘前缀乘积
     * <P> 从右到左：累乘后缀乘积
     */
    public int[] productExceptSelf(int[] nums) {
        // preliminary
        int n = nums.length;

        // 初始化
        int[] res = new int[n];

        int prefixProd = 1;
        for (int i = 0 ; i < n ; i++) {
            res[i] = prefixProd;
            prefixProd *= nums[i];
        }

        int suffixProd = 1;
        for (int i = n - 1 ; i >= 0 ; i--) {
            res[i] *= suffixProd;
            suffixProd *= nums[i];
        }
        return res;
    }
}
