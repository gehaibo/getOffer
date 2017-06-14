package 算法分类.程序员面试金典.递归和动态规划;

/**
 * Created by Jackson on 2017/6/7.
 */
public class 机器人a9_2 {
    public static int countWays(int x, int y) {
        // write code here
        int[][] dp=new int[13][13];

        for (int i = 1; i < y; i++) {
             dp[0][i] = 1;
        }
        for (int i = 1; i < x; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
//        int[][] dp = new int[13][13];
//        for (int i = 1; i < y; i++)
//            dp[0][i] = 1;
//         
//        for (int i = 1; i < x; i++)
//            dp[i][0] = 1;
//         
//        for (int i = 1; i < x; i++)
//            for (int j = 1; j < y; j++)
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//         
//        return dp[x-1][y-1];
    }

    public static void main(String[] args) {
        System.out.println(countWays(2,2));
    }
}

