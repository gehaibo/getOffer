package 刷题归类.剑指offer;

import java.util.Stack;

/**
 * 问题：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 思路：
 * 两个栈实现，stack2做缓冲
 * 1.入栈: 元素从stack1入栈，
 * 2.出栈：从stack2出栈，
 * 当stack2不为空则直接出栈，
 * 当stack2为空时，检查stack1是否为空，若不为空，则将stack1中元素全部顺序出栈入栈到stack2中，若为空，则抛异常。
 */

public class 栈和队列07用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("The Queue is Empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {//1不为空，依次弹出push到2
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
