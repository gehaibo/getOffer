package atest;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/5/19.
 */
public class Main {
    public static boolean increase(int[] a){

        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] a=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=in.nextInt();
            }
            System.out.println(a[n-1]);
        }

    }
}