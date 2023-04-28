package leetcode.LC_Offer_1;

import java.util.Arrays;

/**
 * 类似 LC.LC_String 179
 * 一个求最大，一个求最小
 */
public class Solution_45 {
    public String minNumber(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res ,
                (a , b) -> (a + b).compareTo(b + a) // compare 总是在返回负数时将 a 放在 b 前面
        );
        StringBuilder ans = new StringBuilder();
        for (String str : res) ans.append(str);
        return ans.toString();
    }
}
