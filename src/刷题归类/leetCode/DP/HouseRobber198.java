package 刷题归类.leetCode.DP;

/**
 * Created by Jackson on 2017/5/8.
 */
public class HouseRobber198 {
    public static int[] result;

    public static int rob(int[] nums) {

        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];

        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);//从前往后要付初值
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }
}
