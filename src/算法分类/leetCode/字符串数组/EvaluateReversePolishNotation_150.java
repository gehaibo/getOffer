package 算法分类.leetCode.字符串数组;

import java.util.Stack;

/**
 * Created by Jackson on 2017/7/27.
 */
public class EvaluateReversePolishNotation_150 {
    //["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String> s = new Stack<>();
        for (String t : tokens) {
            if (!operators.contains(t)) {//不是操作数入栈
                s.push(t);
            } else {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                switch (t) {
                    case "+":
                        s.push(String.valueOf(a + b));
                        break;
                    case "-":
                        s.push(String.valueOf(b - a));
                        break;
                    case "*":
                        s.push(String.valueOf(a * b));
                        break;
                    case "/":
                        s.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        return Integer.valueOf(s.pop());
    }
}
