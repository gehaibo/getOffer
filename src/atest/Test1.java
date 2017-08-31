package atest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/6/24.
 */
public class Test1 {
    public static void change(int[] a) {
        a[0] = 50;
    }

    public static void change(String s){
        s="zhangsan";
    }
    public static void main(String[] args) {
//        String s="abc789ABC";
//        char[] a=s.toCharArray();
//        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]+"lala");
//
//        }
//
//        int result=a[0];
//        System.out.println(a[0]-'0');
        //String s="asc   df g";
        //String[] a=s.split("  ");
        Scanner in = new Scanner(System.in);
        String string=in.nextLine();
        String[] a=string.split(" ");
        int[] arr=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i]=Integer.parseInt(a[i]);
        }
//        for ()
//        char numChar = '-9';
//        int  intNum = (int)numChar;
        System.out.println(Arrays.toString(arr));
    }

}
