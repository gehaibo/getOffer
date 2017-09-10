package 上机考试.网易lala;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        int n = in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        Arrays.sort(a);
        int[] b=new int[n-1];
        for (int i = 0; i < n-1; i++) {
            b[i]=Math.abs(a[i+1]-a[i]);
        }
        Arrays.sort(b);
        int res=1;
        for (int i = 0; i < n-2; i++) {
            res+=b[i];
        }
        System.out.println(res);
    }
}
