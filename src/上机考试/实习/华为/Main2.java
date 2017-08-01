package 上机考试.实习.华为;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ghb on 2017/3/23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            printString(str);
        }//endwhile
        scan.close();
    }

    public static void printString(String str) {
        char[] chars=str.toCharArray();
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <chars.length ; i++) {
            if (set.add(chars[i])){
                stringBuilder.append(chars[i]);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
