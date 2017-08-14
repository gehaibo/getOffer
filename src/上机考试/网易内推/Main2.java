package 上机考试.网易内推;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/12.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextLine()) {
        int m = in.nextInt();
        int[] row = new int[m];
        int[] line = new int[m];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < m; i++) {
            row[i] = in.nextInt();
            sum1 += row[i];
        }
        for (int i = 0; i < m; i++) {
            line[i] = in.nextInt();
            sum2 += row[i];
        }

        Arrays.sort(row);
        Arrays.sort(line);

        System.out.print(0);
        for (int i = 2; i < m+1; i++) {

            int res1 = 0;
            for (int j = 0; j < i; j++) {
                res1+=row[j];
            }
            int p=res1/i;
            for (int j = 0; j < i; j++) {
                res1+=Math.abs(p-row[j]);
            }
            System.out.print(" " + res1);
        }
    }

    //  }
}