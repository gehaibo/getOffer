package 刷题归类.leetCode.DP.背包问题;

/**
 * Created by ghb on 2017/3/20.
 */
public class BackPack {
    /**
     *  0-1背包问题,物品有0到n个不重复
     *  状态转移方程：
     *  f（i，c）---将i个物体放入容积为c的背包最大价值
     *  f（i，c）= max{f(i-1,c), vi+f(i-1,c-w(i))}
     *  第i行元素只依赖于第i-1行元素，理论上只保存两行就行了
     */


    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param v 表示商品价值数组
     */
    public static int BackPack_Solution(int m, int n, int[] w, int[] v) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int dp[][] = new int[n + 1][m + 1];
//        默认就是0
// for (int i = 0; i < n + 1; i++)
//            c[i][0] = 0;
//        for (int j = 0; j < m + 1; j++)
//            c[0][j] = 0;

        for (int i = 1; i <= n ; i++) {//第一个到第n个物品依次尝试放入背包
            for (int j = 1; j <= m ; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
//                if (w[i - 1] <= j) {
//                    if (dp[i - 1][j] < (dp[i - 1][j - w[i - 1]] + v[i - 1]))
//                        dp[i][j] = dp[i - 1][j - w[i - 1]] + v[i - 1];
//                    else
//                        dp[i][j] = dp[i - 1][j];
//                } else
//                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int v[] = {4, 5, 6};
        int c = BackPack_Solution(m, n, w, v);
        System.out.println(c);
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(c[i][j] + "\t");
//                if (j == m) {
//                    System.out.println();
//                }
//            }
//        }
        //printPack(c, w, m, n);

    }


}
