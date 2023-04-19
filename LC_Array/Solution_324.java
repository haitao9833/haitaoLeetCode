package leetcode.LC_Array;

import java.util.Random;

/**
 * 理解题意：
 * <P>  较小的数插入在偶数下标处
 * <P>  较大的数插入在奇数下标处
 * <P>  nums[] 长度为偶数 == [小 大 小 大]      最后一个数为大数
 * <P>  nums[] 长度为奇数 == [小 大 小 大 小]   最后一个数为小数
 * <P>
 * 更深入理解题意：
 * <P>  令较小的数合集为 A ，即 nums[] 排序后的前半部分元素
 * <P>  令较大的数合集为 B ，即 nums[] 排序后的后半部分元素
 * <P>  例如对于 nums[] == [1 1 2 2 2 3 3] 则 A == [1 1 2 2] 且 B == [2 3 3]
 * <P>  若在偶数下标处对 A 按随意顺序放置，在奇数下标处对 B 按随意顺序放置
 * <P>  则容易导致 A 中的 2 和 B 中的 2 放置在一块，不符合题意中严格单调性的要求 [小 < 大 > 小 < 大 > 小 < ...]
 * <P>  出现该现象的原因是因为 A 、B 中的重复元素 2 太多了
 * <P>  且注意到该重复元素始终出现在 A 的末尾， B 的首部，即为 nums[] 中 A 、B 的切分位处的元素值
 * <P>  所以，为了避免 A 、B 中的重复元素紧挨在一起
 * <P>  对于偶数下标处的 A 的放置应该逆序 A1 > A2 > ... > An
 * <P>  对于奇数下标处的 B 的放置应该逆序 B1 > B2 > ... > Bm
 * <P>  这样重复元素 A1 、Bm 等等离得最远
 * <P>  对于上述例子中：
 * <P>  A 应该如是放置 [2   2   1   1]
 * <P>  B 应该如是放置 [  3   3   2]
 * <P>
 * 小优化：
 * <P>  对于 A 、B 来说，已知重复元素必然是切分位处的元素，其他元素不可能重复
 * <P>  所以对于 A 、B 来说，其他非重复元素的放置顺序其实也不重要了，即只需保证
 * <P>  A 中的切分位处的元素放置在最前面
 * <P>  B 中的切分位处的元素放置在最后面，即可
 */

public class Solution_324 {

    /**
     * 桶排序，题目保证元素值范围 0 <= nums[i] <= 5000
     */
    public void wiggleSort1(int[] nums) {
        // preliminary
        int n = nums.length;

        // 较小的数和较大的数的在 nums[] 中的最后一个下标
        int smallIdx = (n & 1) == 1 ? n - 1 : n - 2;
        int largeIdx = (n & 1) == 1 ? n - 2 : n - 1;

        // 建桶
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }

        // idx 逆序遍历桶 bucket[]
        // 即从大到小取元素
        int idx = 5000;

        // 较大的数逆序插入奇数下标处
        for (int i = 1 ; i <= largeIdx ; i += 2) {
            while (bucket[idx] == 0) {
                idx--;
            }
            nums[i] = idx;
            bucket[idx]--;
        }

        // 较小的数逆序插入偶数下标处
        for (int i = 0 ; i <= smallIdx ; i += 2) {
            while (bucket[idx] == 0) {
                idx--;
            }
            nums[i] = idx;
            bucket[idx]--;
        }
    }

    public void wiggleSort2(int[] nums) {
        // preliminary
        int n = nums.length;

        // 找切分位处的元素
        int mid = findMid(nums);

        // 荷兰三色旗
        sortColors(nums , mid);

        // 基本数据类型数组的克隆，深克隆
        int[] temp = nums.clone();

        // 将 A == temp[0 , lenA - 1] 逆序填入 nums[] 的偶数位即可
        // 将 B == temp[lenA , n - 1] 逆序填入 nums[] 的奇数位即可
        int lenA = (n + 1) / 2;
        for (int i = 0 ; i < n / 2 ; i++) {
            nums[2 * i] = temp[lenA - 1 - i];
            nums[2 * i + 1] = temp[n - 1 - i];
        }
        if ((n & 1) == 1) {
            nums[n - 1] = temp[0];
        }
    }

    /**
     * 快排 912 代码，无需 quick()
     */
    private static final Random RAND = new Random();
    private int partition(int[] nums , int l , int r) {
        int rondomIdx = l + RAND.nextInt(r - l + 1);
        swap(nums , l , rondomIdx);
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 快排找切分位处的元素 nums[(n+1)/2-1] ，也即 A 的尾元素，至于下标为什么是 (n+1)/2-1 见 704
     * <P>同 215 找第 k 大元素 nums[n - k]
     */
    public int findMid(int[] nums) {
        int n = nums.length;

        // 仅此处与 215 不同
        int midIdx = (n + 1) / 2 - 1;

        int l = 0;
        int r = n - 1;
        while (true) {
            int idx = partition(nums , l , r);
            if (idx < midIdx) {
                l = idx + 1;
            } else if (idx > midIdx) {
                r = idx - 1;
            } else {
                return nums[idx];
            }
        }
    }

    /**
     * 同 75 荷兰三色旗，将切分位处的元素全都置于最中间
     */
    public void sortColors(int[] nums , int mid) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        int index = 0;

        // 代码基本同 75
        // 不过是将 == 0 改成了 < mid 的元素
        // 将 == 2 改成了 > mid 的元素
        while (index <= r) {
            if (nums[index] < mid) {
                swap(nums , l , index);
                l++;
                index++;
            } else if (nums[index] > mid) {
                swap(nums , r , index);
                r--;
            } else {
                index++;
            }
        }
    }

    //    public static void main(String...args) {
//        int[] n1 = new int[]{7,7,7,8,9,10,1,11,2,3,4};
//        int[] n2 = new int[]{7,5,6,5,7,8,9,10,1,11,2,3,4};
//        int mid1 = findMid(n1);
//        int mid2 = findMid(n2);
//        System.out.println(mid1);
//        System.out.println(mid2);
//        for (int i : n1) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//        for (int i : n2) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//        System.out.println();
//        sortColors(n1 , mid1);
//        sortColors(n2 , mid2);
//        for (int i : n1) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//        for (int i : n2) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//        System.out.println();
//
//        int n = n2.length;
//        int[] temp1 = new int[(n + 1) / 2];
//        int[] temp2 = new int[n / 2];
//        int index = 0;
//        for (int i = 0 ; i < (n + 1) / 2 ; i++) {
//            temp1[i] = n2[index++];
//        }
//        for (int i = 0 ; i < n / 2 ; i++) {
//            temp2[i] = n2[index++];
//        }
//        for (int i : temp1) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//        for (int i : temp2) {
//            System.out.print(i);
//            System.out.print(" ");
//        } System.out.println();
//    }
}