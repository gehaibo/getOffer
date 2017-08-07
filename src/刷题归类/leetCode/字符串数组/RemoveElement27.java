package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class RemoveElement27 {
    /**
     * 27. Remove Element  删除数组中给定值，并返回删除后长度
     * Example:
     Given input array nums = [3,2,2,3], val = 3

     Your function should return length = 2, with the first two elements of nums being 2.


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
}
