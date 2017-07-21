package 算法分类.剑指offer.栈和队列22.栈的压入弹出序列;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 借用一个辅助的栈存储遍历压栈顺序，
 * 如果栈顶元素和pop相同，栈顶元素出栈，pop后移
 * 如果栈顶元素和pop不相同，继续入栈和pop判断
 *
 * 最后pushA遍历完，栈不为空，说明没有匹配完，返回false
 */
public class Main {
    /**
     * 将输入数组依次压入辅助栈中
     */

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
