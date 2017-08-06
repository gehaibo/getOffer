package 刷题归类.leetCode.字符串数组;

import static 算法分类.常见排序.高级排序.快速排序.partion;

/**
 * Created by Jackson on 2017/8/2.
 */
public class 字符串 {

    /**
     * 283.Move Zeroes
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * <p>
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;
        //一个指针用来记录插入非零位置
        int index = 0;
        for (int num : nums) {
            if (num != 0) nums[index++] = num;
        }

        //后面赋值为0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    /**
     * 27. Remove Element
     */

    //思想同上,index记录位置，不相等就挨个前移
    public int removeElement(int[] nums, int val) {

        int index = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     * <p>
     * 同上索引覆盖法
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int index = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[index] != nums[i])
                nums[++index] = nums[i];
        }
        return index + 1;
    }

    /**
     * 80. Remove Duplicates from Sorted Array II
     */
    public int removeDuplicates2(int[] nums) {
        int index = 0;
        for (int n : nums)
            //n > nums[index - 2]是核心，如果前面是1，2   当前大于1，可能是2或3，加入
            //如果前面是2，2     当前大于2,可能为3，也要加入
            if (index < 2 || n > nums[index - 2])
                nums[index++] = n;
        return index;
    }

    /**
     * 75. Sort Colors
     * 计数排序
     * 时间复杂度n
     * 空间复杂度n
     */
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }


    /**
     * 88. Merge Sorted Array----从后往前merge
     * 维护三个index，分别对应数组A，数组B，和结果数组。然后A和B同时从后往前扫，每次迭代中A和B指向的元素大的便加入结果数组中，然后index-1，另一个不动
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {//若index剩余不用管，直接在原来位置
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }

        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }

    /**
     * 上面改良版，用index2为循环条件
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int indexMerged = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            if (index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[indexMerged--] = nums1[index1--];
            } else {
                nums1[indexMerged--] = nums2[index2--];
            }
        }
    }

    /**
     * 215. Kth Largest Element in an Array
     */
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partion(nums, l, h);
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


    public static void swap(int[] items, int a, int b) {
        int t;
        t = items[a];
        items[a] = items[b];
        items[b] = t;
    }

    /**
     * 167. Two Sum II - Input array is sorted
     * 两个指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                break;
            }
        }

        return new int[]{numbers[l], numbers[r]};
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(findKthLargest(a, 3));
    }

}
