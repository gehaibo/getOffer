package 上机考试.电信;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/9/10.
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String regex = "\\s+";
        String[] a = str.trim().split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + " ");
        }
        String str2 = sb.toString();
        String[] a2 = str2.trim().split(regex);
        //System.out.println(Arrays.toString(a2));

        int[] res = new int[a2.length];
        for (int i = 0; i < a2.length; i++) {
            res[i] = a2[i].length();
        }
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print((res[res.length - 1] - 1) + "");
    }

}
