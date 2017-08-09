package 上机考试.网易内推练习;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/8.
 */
public class Main7 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            int len1 = char1.length;
            int len2 = char2.length;
            boolean res = false;
            for (int i = 0; i < len2; i++) {
                for (int j = 0; j < len1; j++) {
                    if (char1[j] == char2[i]) {
                        char1[j] = '#';
                        res = true;
                    }
                }

            }
            System.out.println((res == true) ? "YES" : "NO");

        }

    }*/
    public static final void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            boolean result = isContain(str1, str2);
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scan.close();
    }

    public static boolean isContain(String str1, String str2) {
        for (int i = 0, index = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(index)) {
                index++;
                if (index == str2.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
