package 上机考试.阿里;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/4/26.
 */
public class Main2 {

    public static boolean matchChar(String str1, int q, String str2, int p) {

        if (q != str1.length() && p >= str2.length()) return false;

        if (q >= str1.length() && p >= str2.length()) return true;

        if (p + 1 < str2.length() && str2.charAt(p + 1) == '*') {

            if (q >= str1.length()) {
                return matchChar(str1, q, str2, p + 2);
            } else {              
                if (str2.charAt(p) == str1.charAt(q) || str2.charAt(p) == '?') {
                    return matchChar(str1, q + 1, str2, p + 2)
                                    || matchChar(str1, q + 1, str2, p)
                                    || matchChar(str1, q, str2, p + 2);
                } else {
                    return matchChar(str1, q, str2, p + 2);
                }
            }
        }

        if (q >= str1.length()) {
            return false;
        } else {
            if (str1.charAt(q) == str2.charAt(p) || str2.charAt(p) == '.') {
                return matchChar(str1, q + 1, str2, p + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                       //扫描键盘输入
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        if (str1 == null || str2 == null) return;

        System.out.println((matchChar(str1, 0, str2, 0) == true) ? 1 : 0);
    }
}
