package 刷题归类.剑指offer;

import 刷题归类.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：输入一个链表，从尾到头打印链表每个节点的值。
 * <p>
 * 思路一：利用递归打印。
 * 思路二：利用栈先进后出特性，先顺序入栈，再顺序出栈打印。
 */

public class 链表05从尾到头打印链表 {
    //思路一实现：递归,退出条件，最后一个，即下一个为null
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        if (listNode != null) {
            if (listNode.next != null) {
                list = printListFromTailToHead(listNode.next);//此处要返回，如果用this.printListFromTailToHead()则会出现list中只有listNode的头结点
            }
            list.add(listNode.val);
        }
        return list;
    }

    //思路二实现：栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
