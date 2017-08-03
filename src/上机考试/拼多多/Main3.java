package 上机考试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/1.
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }

        int num = perform(h, w);
        System.out.println(num);

    }

    private static int perform(int[] h, int[] w) {
        if (h.length == 0 || h == null || w.length == 0 || w == null) {
            return 0;
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int num = 0;
        // int hl=h.length-1;
        int wl = w.length - 1;
        for (int i = h.length - 1; i >= 0 && wl >= 0; i--) {
            if (w[wl] >= h[i]) {
                num++;
                wl--;
            }
        }
        return num;
    }


}
