package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class MoveZeroes283 {
    /**
     * 283.Move Zeroes  0元素全部移动到最后
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * <p>
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     *
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
}
