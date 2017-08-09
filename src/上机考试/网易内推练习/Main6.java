package 上机考试.网易内推练习;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/8.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String num = sc.next();
            long input = Long.parseLong(num);
            long n = 0;
            while (n * (n + 1) <= input) {
                n++;
            }
            System.out.println(n - 1);
        }

    }
}
