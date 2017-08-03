package 刷题归类.程序员面试金典;

import java.util.Stack;

/**
 * 两个栈实现队
 */
public class StacksToQueue {
    /**
     * 原理：
     * 1.进队，直接插入stack1中
     * 2.出队，判断stack2是否为空，不为空直接弹出栈首，若为空，stack1全部出栈，弹入stack2，stack2再弹出。
     */
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    //进队
    public void addToTail(int x){
        stack1.push(x);
    }

    //出队
    public int deleteHead(){
        if( pSize()!=0)//队列不为空
        {
            if(stack2.isEmpty())//若stack2为空，则把stack1全部加入stack2
                stack1ToStack2();
            return  stack2.pop();

        }
        else
        {
            System.out.println("队列已经为空，不能执行从队头出队");
            return -1;
        }
    }

    //返回队列size
    public int pSize(){
        return stack1.size()+stack2.size();
    }
    //stack1全部出栈，弹入stack2
    public void stack1ToStack2(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        StacksToQueue  q=new StacksToQueue ();
        q.addToTail(1);
        q.addToTail(2);
        q.addToTail(3);
        q.addToTail(4);
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        q.addToTail(5);
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
    }

}
