package 上机考试.搜狗;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by Jackson on 2017/9/8.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        int n = Integer.parseInt(input);
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.readLine();
        }
        in.close();
        BigDecimal res = new BigDecimal(0.0);
        BigDecimal temp = new BigDecimal(180.0);
        if (n == 1) {
            System.out.println(a[0]);
            return;
        }
        int l = 0, r = n-1;
        while (r < n && l < r) {
            BigDecimal b1 = new BigDecimal(a[l]);
            BigDecimal b2 = new BigDecimal(a[r]);
            BigDecimal t = b2.subtract(b1);

            if (l < r && (t.compareTo(temp) == -1)) {
                if (t.compareTo(res) == 1) {
                    res = t;
                }
                r++;
            } else {
                r--;
            }
        }
        System.out.println(res);
    }
}
