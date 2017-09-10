package 上机考试.网易lala;

import java.util.ArrayList;
import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = in.nextInt();
                }
                res.add(cal(a));
            }
            for (String s : res) {
                System.out.println(s);
            }
        }
    }

    static String cal(int[] arr) {
        int len = arr.length;
        // int temp=len%2;
        int a = 0;
        int b=0;
        int c=0;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 4 == 0){
                c++;
            }else {
                if (arr[i]% 2!=0){
                    a++;
                }else {
                    b++;
                }
            }
        }
        if(b==0)
            return (a <= c + 1)?"Yes":"No";
        else
            return (a <= c)?"Yes":"No";


    }
    /**
     * 数列总数为n, 不能被2整除的有a，只能被2整除的有b，能被4整除的有c
     if(b==0)
     return a <= c + 1;
     else
     return a <= c;
     */
}
//        for (int i = 0; i < len; i++) {
//            if (a[i] % 4 == 0) count++;
//        }
//        if (count >= len / 2) {
//            return "Yes";
//        } else {
//            int temp = len / 2;
//            int re = count + 2 * (count - temp);
//            int count2 = 0;
//
//            for (int i = 0; i < len; i++) {
//                if (a[i] % 2 == 0) count2++;
//            }
//            if (count2>=re) return "Yes";
//            else return "No";
//        }