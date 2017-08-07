package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class TwoSumII167 {
    /**
     * 167. Two Sum II - Input array is sorted
     * 已经排序数组，和是目标值
     *
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
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
}
