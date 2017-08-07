package 刷题归类.leetCode.字符串数组;

/**
 * 88. Merge Sorted Array----从后往前merge
 * 维护三个index，分别对应数组A，数组B，和结果数组。然后A和B同时从后往前扫，每次迭代中A和B指向的元素大的便加入结果数组中，然后index-1，另一个不动
 */
public class MergeSortedArray88 {
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
}
