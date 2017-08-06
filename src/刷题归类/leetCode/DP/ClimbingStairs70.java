package 刷题归类.leetCode.DP;

import java.util.Arrays;

/**
 * Created by Jackson on 2017/8/4.
 */
public class ClimbingStairs70 {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Note: Given n will be a positive integer.
     */
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 1;
        memo[1] = 1;
        //自底向下
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    //优化
    public static int climbStairs2(int n) {
        int[] dp = new int[2];
        dp[1] = 1;
        dp[0] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }

    public static void main(String[] args) {
        int n = climbStairs(4);
        System.out.println(n);
    }
}
