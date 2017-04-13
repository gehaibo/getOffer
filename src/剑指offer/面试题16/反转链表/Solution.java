package 剑指offer.面试题16.反转链表;

/**
 * Created by ghb on 2017/4/13.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //单链表逆序

    /**
     * 1 非递归 无额外空间
     * 每次需要保留后一个节点
     */

    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;

        //需要两个指针一个记录前一个节点，一个保存下一个断开的，当前节点为head
        ListNode before = null;
        ListNode next = null;//前面指针
        while (head != null) {

            //1.保存当前的下一个节点下一步断开
            next = head.next;
            //2.当前指向前一个节点
            head.next = before;
            //3.before后移
            before = head;
            //4.当前指针后移
            head = next;
        }
        return before;
    }

    /**
     * 单链表逆序递归
     * 2 递归的思想
     * 先将当前的表头节点从链表中拆出来，然后对剩余的节点进行逆序
     */
    public static ListNode reverse2(ListNode head) {
        ListNode newNode = null;

        if (head == null || head.next == null) return head;

        //将链表分为两部分，对第二部分节点逆序
        newNode = reverse2(head.next);

        //将第一部分插入到第二部分后面
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    /**
     * 单链表从m到n逆序
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) return null;
        //新建一个节点指向head，一定要new一个！！！！！！
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        //两个指针，一个指向逆序前前面，一个指向开始逆序位置
        ListNode before = newHead;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            //节点后移，cur指向第m个
            before = cur;
            cur = cur.next;
        }

        int count = n - m;
        for (int i = 0; i < count; i++) {
            //采用头插法
            //1.记录下一个
            ListNode temp = cur.next;
            //2.当指向下下（换后的连接上）
            cur.next = temp.next;
            //3.先放到排序后位置
            temp.next = before.next;
            //4.前指向下
            before.next = temp;
        }
        return newHead.next;
    }
}
