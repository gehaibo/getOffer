package 上机考试.实习.华为;


import java.util.Scanner;

/**
 * Created by ghb on 2017/3/23.
 */
public class Main {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        int b=sc.nextInt();
//        System.out.println(a+b);
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个ca
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }


    }
}
