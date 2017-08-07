package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/7/27.
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        if (k > length)
            k = k % length;

        int[] result = new int[length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[length - k + i];
        }

        int j = 0;
        for (int i = k; i < length; i++) {
            result[i] = nums[j];
            j++;
        }

        System.arraycopy(result, 0, nums, 0, length);
    }
}
