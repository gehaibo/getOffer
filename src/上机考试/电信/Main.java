package 上机考试.电信;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int res = 0;
        for (int i = 1; i <= num; i++) {
            boolean cal = isH(i);
            if (cal == true) {
                res += i;
            }
        }
        System.out.println(res);

    }

    public static boolean isH(int n) {
        if (n < 5) {
            if (1 == n)
                return true;
            else
                return false;
        }

        int sum = 0;

        while (n >= 10) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        sum += n * n;
        return isH(sum);
    }
}
