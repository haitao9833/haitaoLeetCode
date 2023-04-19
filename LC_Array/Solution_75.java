package leetcode.LC_Array;


public class Solution_75 {

    /**
     * l 之前全为 0 ，但不包括 l 所指 <P>
     * r 之后全为 2 ，但不包括 r 所指 <P>
     * index 为移动的工作指针: <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 遍历方向为 [l --> r] <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 且遍历到 0 交换给 l ，遍历到 2 交换给 r ，遍历到 1 则不处理直接 ++ 后移 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 由遍历方向和操作可知，l 与 index 的第一次分离，一定是 l 指向了 1 开始的 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 遇到 0 ==> l & index 同时移动 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 遇到 1 ==> index 独自移动，l 不移动 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * <strong>本质即 [l , index - 1] 之间只会有 1</strong>
     */
    public void sortColors(int[] nums) {

        int n = nums.length;

        int l = 0;
        int r = n - 1;
        int index = 0;

        // l 和 r 指向的都是未处理的，所以 index 遍历到 r 还需处理一次
        while (index <= r) {
            if (nums[index] == 0) {
                // 细节：index 遍历到 0 后抛给 l ，此时 l 抛回来的一定是 1 不可能是 2 ，所以 index 可以直接 ++ 无需处理该 1
                swap(nums , l , index);
                l++;
                index++;
            } else if (nums[index] == 2) {
                // 细节：index 遍历到 2 后抛给 r ，此时 r 抛回来的有可能是 1 也有可能是 2
                // 所以 index 还得继续处理这个抛回来的可能为 2 的元素，不能立马 index++
                swap(nums , r , index);
                r--;
            } else {
                index++;
            }
        }
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
