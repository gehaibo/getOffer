package 刷题归类.leetCode.字符串数组;

import static 算法分类.常见排序.高级排序.快速排序.partition;

/**
 * Created by Jackson on 2017/8/7.
 */
public class KthLargestElement215 {

    /**
     * 215. Kth Largest Element in an Array
     */
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j > k) {
                h = j - 1;
            } else if (j < k) {
                l = j + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
}
