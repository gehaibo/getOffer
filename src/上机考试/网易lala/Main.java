package 上机考试.网易lala;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        String str = in.next();
//        char[] a = str.trim().toCharArray();
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == '(')
//                list.add('(');
//        }
// System.out.println(list.size());

        System.out.println(longestValidParentheses(str));
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max/2;
    }
}
