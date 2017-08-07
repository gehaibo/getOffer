package 刷题归类.leetCode.DP;

/**
 * Created by Jackson on 2017/8/6.
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n && obstacleGrid[0][j] != 1; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
