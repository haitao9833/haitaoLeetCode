package leetcode.LC_Array;

import java.util.stream.IntStream;

public class Solution_217 {

    /**
     * 也可以用 Set 依次装入元素，若装入到重复元素就返回 true
     * @see Solution_287
     */
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}
