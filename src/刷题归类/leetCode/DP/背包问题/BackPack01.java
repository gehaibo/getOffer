package 刷题归类.leetCode.DP.背包问题;

/**
 * Created by ghb on 2017/3/20.
 */
public class BackPack01 {
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
    public static int backPackSolution(int n, int m, int[] w, int[] v) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int dp[][] = new int[n + 1][m + 1];
//        默认就是0
// for (int i = 0; i < n + 1; i++)
//            c[i][0] = 0;
//        for (int j = 0; j < m + 1; j++)
//            c[0][j] = 0;

        for (int i = 1; i <= n; i++) {//第一个到第n个物品依次尝试放入背包
            for (int j = 1; j <= m; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (dp[i - 1][j] < (dp[i - 1][j - w[i - 1]] + v[i - 1]))
                        dp[i][j] = dp[i - 1][j - w[i - 1]] + v[i - 1];
                    else
                        dp[i][j] = dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    public static int backPack01(int n, int c, int[] w, int[] v) {

        int[][] meno = new int[n + 1][c + 1];//c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值

        for (int i = 1; i <= n; i++) {//从第二个开始
            for (int j = 1; j <= c; j++) {
                meno[i][j] = meno[i - 1][j];//放不下
                if (j >= w[i - 1])//第i个物品，数组下标是i-1
                    meno[i][j] = Math.max(meno[i][j], v[i - 1] + meno[i - 1][j - w[i - 1]]);
            }
        }
        return meno[n][c];
    }

    //优化 只需要两个二维数组就行了,奇数放1，偶数放0
    public static int backPack02(int n, int c, int[] w, int[] v) {

        int[][] meno = new int[2][c + 1];//c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值

        for (int i = 1; i <= n; i++) {//从第二个开始
            for (int j = 1; j <= c; j++) {
                meno[i % 2][j] = meno[(i - 1) % 2][j];//放不下
                if (j >= w[i - 1])//第i个物品，数组下标是i-1
                    meno[i % 2][j] = Math.max(meno[i % 2][j], v[i - 1] + meno[(i - 1) % 2][j - w[i - 1]]);
            }
        }
        return meno[n % 2][c];
    }

    //优化为一维数组，
    // 当进行第i次循环时，f[v]中保存的是上次循环产生的结果，即第i-1次循环的结果(i>=1)。
    // 所以f[v]=max{f[v],f[v-c[i]]+w[i]}这个式子中，等号右边的f[v]和f[v-c[i]]+w[i]都是前一次循环产生的值。
    public static int backPack03(int n, int c, int[] w, int[] v) {
        int[] memo = new int[c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= w[i - 1]; j--) {//从后往前，每次找到可以放进去的就更新，找出最大值，i-1表示第个索引
                memo[j] = Math.max(memo[j], v[i - 1] + memo[j - w[i - 1]]);
            }
        }
        return memo[c];
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int v[] = {4, 5, 6};
        int c = backPackSolution(n, m, w, v);
        System.out.println(c);
        System.out.println(backPack02(n, m, w, v));
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
