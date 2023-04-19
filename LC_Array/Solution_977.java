package leetcode.LC_Array;

public class Solution_977 {

    /**
     * 逆向思维： <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最大平方项的一定在 nums[] 的左右两端 <p>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以逆序、从大到小填充 res[]
     */
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        // idx 为待填充的下标处
        // l > r 排序结束
        for (int l = 0 , r = n - 1 , idx = n - 1 ; l <= r ; ) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[idx--] = nums[l] * nums[l];
                l++;
            } else {
                res[idx--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
