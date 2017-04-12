package leetCode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by ghb on 2017/4/2.
 */
public class ListAbout {

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


    /**
     * 删除未排序链表中重复节点
     */
    //可以新建缓存的
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;

        Hashtable hashtable = new Hashtable();

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode previous = null;//前一个
        // ListNode cur=head.next;

        while (head != null) {
            if (hashtable.containsKey(head.val)) {
                previous.next = head.next;
            } else {
                hashtable.put(head.val, true);
                previous = head;
            }
            head = head.next;
        }
        return result.next;
    }

    /**
     * 删除已经排好序的，重复节点保留
     */

    public ListNode deleteDuplicates(ListNode head) {


        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
    /**
     * 重复节点不保留
     */
//    ListNode deleteDuplication2(ListNode head)
//    {
//        if (head == null)
//            return head;
//        ListNode newHead = new ListNode(0);
//        newHead.next = head;
//        ListNode pre = newHead;//保存前一个
//        ListNode cur = head;//当前
//        while (cur != null) {
//            while (cur.next != null && cur.val == cur.next.val) {//指向最后一个重复
//                cur = cur.next;
//            }
//            if (pre.next == cur) {//无重复的，pre后移
//                pre = pre.next;
//            } else {//pre直接指向新的不重复的
//                pre.next = cur.next;
//            }
//            cur = cur.next;
//        }
//        return newHead.next;
//    }

    /**
     * 给定列表，将列表向右旋转k个位置，其中k是非负数。
     * Given 1->2->3->4->5->NULL and k =2,
     * return 4->5->1->2->3->NULL.
     */

    public ListNode rotateRight(ListNode head, int n) {
        if (n <= 0 || head == null || head.next == null)
            return head;

        // 遍历链表长度
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            len++;
            p = p.next;
        }

        // 连接成循环链表
        p.next = head;

        //定位到倒数第n个位置的前一个位置
        for (int i = 1; i < len - n % len; i++) {
            head = head.next;
        }

        p = head.next;
        head.next = null;

        return p;
    }

    //两个链表的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;

            current2 = current2.next;
        }
        return null;

    }


}
