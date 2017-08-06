package 刷题归类.leetCode.DP;

import java.util.Arrays;

/**
 * 如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x = a + bｘb，
 * 那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1（因为b*b已经是平方数了或者本身）。
 * nums[a + b*b] = min(nums[a] + 1, nums[a + b*b]);
 *
 * 还可以用数学方法
 */
public class PerfectSquares279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];//能组成这个数x最少的平方数个数
        Arrays.fill(dp, Integer.MAX_VALUE);//// 将所有非平方数的结果置最大，保证之后比较的时候不被选中
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i * i <= n; i++) {// 将所有本身是平方数的结果置1
            dp[i * i] = 1;
        }
        for (int a = 0; a <= n; a++) {// 从小到大找任意数a
            for (int b = 0; a + b * b <= n; b++) {// 从小到大找平方数b*b
                dp[a + b * b] = Math.min(dp[a + b * b], dp[a] + 1);
            }
        }
        return dp[n];
    }
}
