package 刷题归类.leetCode.DP;

/**
 * Created by Jackson on 2017/8/5.
 */
public class IntegerBreak343 {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {//看有多少个三
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {//数i拆开j和i-j,三种情况，无法拆开，本身拆成两个最大，j和之前最大
                dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }
}
