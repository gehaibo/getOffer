package test;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ghb on 2017/4/5.
 */
public class Test {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead.next == null) return null;
        ListNode cur = pHead;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return pHead;
    }

    public static void main(String[] args) {
//        int a= 0xEF;
//        System.out.println(Math.ceil(2.3));
//        System.out.println(Math.floor(2.3));
//        System.out.println(Math.round(2.3));
//        System.out.println(a);
//
//        String string="hello word";
//        string+="a";
//        int a1=string.length();
//        System.out.println(func());
//
//
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(1);
//        Iterator it= arrayList.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        Test t = new Test();
//        int y = t.aaa();
//        System.out.println("测试输出"+y);

//        String a = "123";
//        String aa = "123";
//        System.out.println(a.equals(aa));

        //run.run();

//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        System.out.println(queue.size());
//        Integer out;
//        while ((out = queue.poll()) != null) {
//            System.out.print(out);
//        }
//            Scanner sc = new Scanner(System.in);
//            System.out.println("请输入一个数字");
//            double number = sc.nextDouble();
//            System.out.println("该数字用Locale 类的以下常量作为格式化对象的构造参数，将获得不同的货币格式：");
//            // 创建格式化对象
//            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
//            // 输出格式化货币格式
//            System.out.println("Locale.CHINA：" + format.format(number));
//            format = NumberFormat.getCurrencyInstance(Locale.US);
//            System.out.println("Locale.US：" + format.format(number));
//            format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
//            System.out.println("Locale.ENGLISH：" + format.format(number));

            Stack stack=new Stack();
            stack.push(2);
            stack.push(3);
            stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.firstElement());

        Queue queue=new ArrayDeque();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());


        }



}
