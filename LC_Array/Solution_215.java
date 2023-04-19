package leetcode.LC_Array;

import leetcode.LC_Hash.Solution_692;

import java.util.Random;

public class Solution_215 {

    /**
     * 快排法 <P>
     * 第 k 大的元素一定在排序后的 nums[n - k] 处
     */
    public int findKthLargest1(int[] nums , int k) {

        int n = nums.length;

        int kthIdx = n - k;

        int l = 0;
        int r = n - 1;

        while (true) {
            // idx 为置于最终位的枢轴划分点 pivot 的下标
            int idx = partition(nums , l , r);

            if (idx < kthIdx) {
                l = idx + 1;
            } else if (idx > kthIdx) {
                r = idx - 1;
            } else {
                return nums[idx];
            }
        }
    }

    /**
     * 直接复制 912 代码
     * @see Solution_912#partition(int[], int, int)
     */
    private static final Random RAND = new Random();
    private int partition(int[] nums , int l , int r) {
        int rondomIdx = l + RAND.nextInt(r - l + 1);
        swap(nums , l , rondomIdx);
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot < nums[r]) {
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
     * 堆排法 <P>
     * 建大小为 k 的小根堆，堆顶元素即为第 k 大的
     * @see Solution_692
     */
    public int findKthLargest2(int[] nums , int k) {

        int n = nums.length;

        // 仅需建立大小为 k 的小根堆 nums[0 , k-1]
        buildMinHeap(nums , k);

        // 将 nums[k , n-1] 的元素依次尝试入堆
        for(int i = k ; i < n ; i++){
            if(nums[i] > nums[0]) {
                swap(nums , i ,0);
                heapify(nums , 0 , k);
            }
        }

        // 堆顶为第 k 大元素
        return nums[0];
    }

    /**
     * 在 912 代码基础上修改为建立小根堆 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 且只对长度为 len 的 nums[0 ~ len-1] 部分建立小根堆 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 就是改成了 minPos 标记 min(root , root.left , root.right) 的下标
     * @see Solution_912#buildMaxHeap(int[])
     */
    private void buildMinHeap(int[] nums , int len){
        for(int i = len/2 - 1 ; i >= 0 ; i--){
            heapify(nums , i , len);
        }
    }
    private void heapify(int[] nums , int root , int len) {
        int minPos = root;
        while (true) {
            if (2 * root + 1 < len && nums[2 * root + 1] < nums[root]) {
                minPos = 2 * root + 1;
            }
            if (2 * root + 2 < len && nums[2 * root + 2] < nums[minPos]) {
                minPos = 2 * root + 2;
            }
            if (minPos == root) {
                break;
            }
            swap(nums , root , minPos);
            root = minPos;
        }
    }
}