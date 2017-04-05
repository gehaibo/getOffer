package interviewCollection;

import java.util.Scanner;

/**
 * Created by ghb on 2017/3/25.
 */
public class wangyi {

    public static int change(int num[], int m) {

        int temp = 0;
        if (m != num.length - 1) {
            temp = num[m] + num[m + 1];
        } else {
            temp = num[m] + num[0];
        }
        if (temp >= 100) {
            temp = temp % 100;
        }
        return temp;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();//几次交换
        int[] num = new int[a];
        for (int i = 0; i < a; i++) {
            num[i] = in.nextInt();
        }

        int[] num2 = new int[a];

        for (int x = 0; x < a; x++) {
            num2[x] = num[x];
        }
        for (int i = 0; i < b; i++) {


            for (int j = 0; j < a; j++) {
                int temp;
                temp = change(num2, j);
                num[j] = temp;
            }
        }

        for (int i = 0; i < a - 1; i++) {

            System.out.print(num[i]);
            System.out.print(" ");

        }
        System.out.println(num[a - 1]);
    }
}
