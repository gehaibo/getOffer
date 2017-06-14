package 算法分类.leetCode.DP;

import java.util.Arrays;

/**
 * Created by Jackson on 2017/5/8.
 */
public class houseRobber_198 {
    public static int[] result;

    static int search(int indx, int[] nums) {
        if (indx < 0) return 0;

        //计划搜索，优化存储
        if (result[indx] >= 0) return result[indx];


        result[indx] = Math.max(nums[indx] + search(indx - 2, nums), search(indx - 1, nums));
        return result[indx];
    }

    public static int rob(int[] nums) {
        result = new int[nums.length];
        Arrays.fill(result, -1);//全部赋值为-1
        return search(nums.length - 1, nums);
    }

    public static int rob2(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];

        result = new int[nums.length];
        Arrays.fill(result, -1);//全部赋值为-1

        result[0]=nums[0];//从从第一个开始
        result[1]=Math.max(nums[0],nums[1]);

        for (int indx = 2; indx < nums.length; indx++) {
            result[indx] = Math.max(nums[indx] + result[indx-2], result[indx - 1]);
        }
        return result[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(rob2(nums));
    }
}
