package huaweiks;

import java.util.Scanner;

/**
 * Created by ghb on 2017/3/24.
 */
public class Main {
    public static int reverseAdd(String str){
        if (str.length()==1)
            return Integer.parseInt(str);

        String str2=new StringBuilder(str).reverse().toString();
        return Integer.parseInt(str2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.next();
            String[] strings = str.split(",");
            String str1 = strings[0];
            String str2 = strings[1];
            if(str1.charAt(0)=='-'||str1.charAt(0)=='0'||str2.charAt(0)=='-'||str2.charAt(0)=='0'){
                System.out.println(-1);
                return;
            }
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            if ((num1 < 1 || num1 > 70000) || (num2 < 1 || num2 > 70000)) {
                System.out.println(-1);
                return;
            }

            int n1 = reverseAdd(str1);
            int n2 = reverseAdd(str2);
            System.out.println(n1 + n2);
        }
    }
}
