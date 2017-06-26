package 上机考试.阿里;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jackson on 2017/4/26.
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        String s = expr.replace(" ", "");
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        //int count = 16;
        //System.out.println(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '^' && chars[i] != '+' && chars[i] != '*') {
                stack.push(chars[i]);
                if (stack.size() > 16) return -2;
            } else {
//                if (chars[i] == '^') {
//                    if (count < 1) return -1;
//                    int temp = Integer.parseInt("" + stack.pop());
//                    stack.push(temp + 1);
//                } else if (chars[i] == '*') {
//                    if (count < 2) return -1;
//                    int temp1 = Integer.parseInt("" + stack.pop());
//                    int temp2 = Integer.parseInt("" + stack.pop());
//                    stack.push(temp1 * temp2);
//                    --count;
//                } else if (chars[i] == '+') {
//                    if (count < 2) return -1;
//                    int temp1 = Integer.parseInt("" + stack.pop());
//                    int temp2 = Integer.parseInt("" + stack.pop());
//                    stack.push(temp1 + temp2);
//                    --count;
//                }
            }

        }
        String result = stack.pop() + "";
        return Integer.parseInt(result);
    }
}
