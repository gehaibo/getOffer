package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class RemoveDuplicates26 {
    /**
     * 26. Remove Duplicates from Sorted Array
     * 有序数组去重，使原数组每个元素只有一个
     * <p>
     * 同上索引覆盖法，
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
}
