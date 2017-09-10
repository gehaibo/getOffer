package 上机考试.京东d;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        int n = in.nextInt();
        long res = 0;
        int[]x[]=new int[1][];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long s = (long) Math.pow(i, j);
                int k = i;
                for (; k <= n; ) {
                    if (s % k == 0) {
                        res++;
                        k++;
                       // break;
                    } else {
                        k++;
                       // break;
                    }
                }
            }
        }
        System.out.println((res+n*n)%1000000007);
        //  }
    }
}
