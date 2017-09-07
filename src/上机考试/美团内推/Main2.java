package 上机考试.美团内推;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/31.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        int n = in.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = in.nextInt();
        }
        Arrays.sort(students);

        int[] sums = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) sums[i] = students[i];
            else sums[i] = students[i] + sums[i + 1];
        }

        if (students[0] > sums[1])
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}
