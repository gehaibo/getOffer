package 算法分类.上机真题.阿里逆波兰式求值;

import java.util.Scanner;
import java.util.Stack;

/**
 * 逆波兰式，输入相互间有空格，^表示自增，还有*和+
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(evaluate(s));
    }

    private static int evaluate(String s) {
        //数字就入栈
        Stack<Integer> stack = new Stack<>();
        String[] strs = s.split("\\s+");
        for (int i = 0; i < strs.length; i++) {
            //为数字就入栈
            if (!strs[i].equals("+") && !strs[i].equals("^") && !strs[i].equals("*")) {
                stack.push(Integer.parseInt(strs[i]));
                if (stack.size() > 16) return -2;
            } else {
                switch (strs[i]) {
                    //弹出一个+1，再入栈
                    case "^":
                        if (stack.empty()) return -1;
                        int temp = stack.pop();
                        stack.push(temp + 1);
                        break;
                    //取两个数判断，需要每取一个就判断
                    case "+":
                        if (stack.empty()) return -1;
                        int num11 = stack.pop();
                        if (stack.empty()) return -1;
                        int num12 = stack.pop();
                        stack.push(num11 + num12);
                        break;
                    case "*":
                        if (stack.empty()) return -1;
                        int num21 = stack.pop();
                        if (stack.empty()) return -1;
                        int num22 = stack.pop();
                        stack.push(num21 * num22);
                        break;
                }
            }
        }
        if (stack.empty()) return -1;
        return stack.pop();
    }
}
