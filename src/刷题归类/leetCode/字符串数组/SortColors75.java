package 刷题归类.leetCode.字符串数组;


/**
 * 75. Sort Colors
 * 计数排序
 * 时间复杂度n
 * 空间复杂度n
 */
public class SortColors75 {
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
}
