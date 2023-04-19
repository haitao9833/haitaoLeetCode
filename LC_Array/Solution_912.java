package leetcode.LC_Array;

import java.util.Random;

public class Solution_912 {

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        // 快排
        quick(nums , 0 , n - 1);

        // 归并排序
        aux = new int[n];
        sort(nums , 0 , n - 1);

        // 堆排序
        buildMaxHeap(nums);
        sortMaxHeap(nums);

        return nums;
    }

    /**
     * 数组长度 <= 7 ，优先使用插入排序： <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 前半部分 nums[l , l] 为有序部分 <P>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 后半部分 nums[l+1 , r] 依次插入到前面的有序部分 <P>
     * 注意：此处的插入排序为对 nums[l , r] 进行插入排序，而不是对 nums[0 , n-1] 排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;
    private void insetSort(int[] nums , int l , int r) {

        // 遍历 nums[l+1 , ... , r]
        for (int i = l + 1 ; i <= r ; i++) {

            // ele 为待插入前面的元素
            int ele = nums[i];

            // idx 向前寻找待插入的位置，且 nums[idx] 为一个无效空缺位置
            int idx = i;

            // 注意此处是 l < idx 不是 0 < idx ，因为 l 就是 nums[l , r] 区间的第一个元素位置
            while (l < idx && nums[idx - 1] > ele) {
                nums[idx] = nums[idx - 1];
                idx--;
            }

            // 插入
            nums[idx] = ele;
        }
    }

    /**
     * 快排
     * <P> RAND 用于随机选取枢轴划分点 pivot
     */
    private static final Random RAND = new Random();
    private void quick(int[] nums , int l , int r) {
        // 递归边界
        if (r - l <= INSERTION_SORT_THRESHOLD) {
            insetSort(nums , l , r);
            return;
        }

        // 每层递归放置一个元素到最终位 nums[splitIdx]
        int splitIdx = partition(nums , l , r);

        // 递归排序左右两边
        quick(nums , l , splitIdx - 1);
        quick(nums , splitIdx + 1 , r);
    }
    public int partition(int[] nums , int l , int r) {
        // 随机选取 nums[l , r] 之间的一个元素为 pivot
        int randomIdx = l + RAND.nextInt(r - l + 1);

        // 交换使得 nums[l] 为一个无效空缺位置
        swap(nums , l , randomIdx);
        int pivot = nums[l];

        // 左 <= pivot < 右
        // 循环结束 l == r
        while (l < r) {

            // 先用 r 向前搜索
            while (l < r && pivot < nums[r]) {
                r--;
            }
            nums[l] = nums[r];

            // 再用 l 向后搜索
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }

        // 将 pivot 放置到最终位 l == r 处，并返回最终位下标
        nums[l] = pivot;
        return l;
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 归并排序
     * <p> aux 为辅助数组
     */
    private static int[] aux;
    public void sort(int[] nums , int l , int r) {
        // 递归边界
        if (r - l <= INSERTION_SORT_THRESHOLD) {
            insetSort(nums , l , r);
            return;
        }

        // 将 nums[l , r] 等分为 nums[l , mid] 和 nums[mid+1 , r] 并进行递归排序
        // 此处等分，向下取整或向上取整都可以
        int mid = l + ((r - l) >> 1);
        sort(nums , l , mid);
        sort(nums , mid + 1 , r);

        // 递归后 ==> 再合并两个已经有序的子区间
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums , l , mid , r);
    }
    private void merge(int[] nums , int l , int mid , int r) {
        // 先将两个子区间复制到辅助数组 aux 中
        System.arraycopy(nums , l , aux , l , r - l + 1);

        // i 指针遍历子区间 nums[l , mid]
        // j 指针遍历子区间 nums[mid+1 , r]
        int i = l;
        int j = mid + 1;

        // idx 为 nums[l , r] 范围内待插入元素位置
        for (int idx = l ; idx <= r ; idx++) {
            if (i > mid) {
                // 子区间 nums[l , mid] 用完了
                nums[idx] = aux[j++];
            } else if (j > r) {
                // 子区间 nums[mid+1 , r] 用完了
                nums[idx] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                // <= 保证稳定性，相同的元素优先选择前半部分 [i , mid] 中的
                nums[idx] = aux[i++];
            } else {
                nums[idx] = aux[j++];
            }
        }
    }

    /**
     * 堆排序
     */
    public void buildMaxHeap(int[] nums){
        int n = nums.length;
        for(int i = n/2 - 1 ; i >= 0 ; i--){
            heapify(nums , i , n);
        }
    }
    private void heapify(int[] nums , int root , int len) {

        // maxPos 标记 max(root , root.left , root.right) 的下标
        int maxPos = root;

        while (true) {

            // 和左孩子比大小
            if (2 * root + 1 < len && nums[2 * root + 1] > nums[root]) {
                maxPos = 2 * root + 1;
            }

            // 和右孩子比大小
            if (2 * root + 2 < len && nums[2 * root + 2] > nums[maxPos]) {
                maxPos = 2 * root + 2;
            }

            // root 已经是最大的了，无序再向下堆化，循环结束
            if (maxPos == root) {
                break;
            }

            // 更新 root == max(root , root.left , root.right)
            swap(nums , root , maxPos);

            // 继续向下堆化
            root = maxPos;
        }
    }
    private void sortMaxHeap(int[] nums) {
        int n = nums.length;

        for (int i = n - 1 ; i >= 1 ; i--) {
            // 依次把堆顶元素 nums[0] 交换到逆序 i ∈ [n-1 -> 1]
            swap(nums , 0 , i);
            // 然后自顶向下调整堆顶元素 nums[0] ，注意堆大小已经变为 i 了
            heapify(nums , 0 , i);
        }
    }
}

