package 刷题归类.leetCode.DP.背包问题;

/**
 * 正整数数组分两部分，两部分和相同
 */
public class PartitionEqualSubsetSum416 {
    /**
     * 其中dp[i]表示数字i是否是原数组的任意个子集合之和,我们最后只需要返回dp[target]就行了
     * 初始化dp[0]为true，由于题目中限制了所有数字为正数，那么我们就不用担心会出现和为0或者负数的情况
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;//为奇数
        sum = sum/2;

        int[] memo = new int[sum + 1];
        for (int i = 0; i < len; i++) {
            for (int j = sum; j >= nums[i]; j--) {//从后往前，每次找到可以放进去的就更新，找出最大值，i-1表示第个索引
                memo[j] = Math.max(memo[j], nums[i] + memo[j - nums[i]]);
            }
        }
        return memo[sum]==sum;
    }

    public static void main(String[] args) {
        int[] a={1,5,11,5};
        System.out.println(canPartition(a));
    }
}
