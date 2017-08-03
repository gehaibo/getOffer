package 刷题归类.剑指offer;

import java.util.Stack;

/**
 * Created by Jackson on 2017/6/17.
 */
public class 栈和队列21包含min函数的栈 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();//记录最小

    public void push(int node) {
        s1.push(node);
        if (s2.empty() || s2.peek() >= node) {
            s2.push(node);
        } else {
            s2.push(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
