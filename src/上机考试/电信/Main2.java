package 上机考试.电信;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/9/10.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = in.nextInt();
        }
        int i, j;
        int len = a.length;
        int n = len / 2, sum = 0;
        for (i = 0; i < len; i++) sum += a[i];
        boolean dp[][] = new boolean[len + 1][sum / 2 + 1];

        for (i = 0; i < len; i++)
            for (j = 0; j < sum / 2 + 1; j++)
                dp[i][j] = false;

        dp[0][0] = true;
        for (int k = 0; k < len; k++) {
            for (i = k > n ? n : k; i >= 1; i--) {
                for (j = 0; j <= sum / 2; j++) {
                    if (j >= a[k] && dp[i - 1][j - a[k]])
                        dp[i][j] = true;
                }
            }
        }
        for (i = sum / 2; i >= 0; i--) {
            if (dp[n][i]) {
                System.out.println(Math.abs(2 * i - sum));
                break;
            }
        }

    }


}
