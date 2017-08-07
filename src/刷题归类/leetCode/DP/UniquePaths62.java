package 刷题归类.leetCode.DP;

/**
 * Created by Jackson on 2017/8/5.
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //空间优化：使得空间复杂度从原来的 O(n*m)下降为 O(n)。
    // 对于起点到点(i,j)的路径总数：
    // ways[j]= 起点到点(i-1, j) 的路径总数：ways[j]       +        起点到点(i, j-1)的路径总数 ways[j-1]，
    // 于是我们就得到递推式：ways[j] = ways[j] + ways[j-1]
    public int uniquePaths2(int m, int n) {
        Integer[] dp = new Integer[n + 1];
        dp[0] = 1;
        //for (int i = 0; i < n ;i++) dp[i] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n-1];
    }

}
