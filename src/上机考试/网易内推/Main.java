package 上机考试.网易内推;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            System.out.println(arr[2][2]);
            System.out.println(arr[0][0]);
        }

    }
}
