package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class removeDuplicatesII80 {

    /**
     * 80. Remove Duplicates from Sorted Array II
     * 有序数组去重，使原数组每个相等元素最多保留两个
     *
     *
     * Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5
     1 1 2 2 3
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
}
