package 算法分类.leetCode.链表;

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


    /**
     * reorder list-143
     * <p>
     * <p>
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to:                L0→Ln→L1→Ln-1→L2→Ln-2→…
     * You must do this in-place without altering the nodes' values.
     * For example,
     * Given{1,2,3,4,5,6}, reorder it to{1,6,2,5,3,4}.
     * <p>
     * <p>
     * 思路：1.找到中间节点，2.后半部分逆序，3.依次将后半部分插入前面
     */
    public static ListNode reverseNode1(ListNode head) {
        ListNode temp=null;
        if (head.next == null || head.next == null) return head;

        temp = reverseNode1(head.next);

        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static ListNode reverseNode2(ListNode head) {
        if (head == null || head.next == null) return head;
        //需要两个节点记录当前节点前和后，before和head，需要后移
        ListNode before = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = before;
            before = head;
            head = next;
        }
        return before;
    }
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) return ;
        ListNode mid=findMid(head);
        ListNode right=reverseNode2(mid);
        ListNode left=head;
        while (right.next!=null){
            ListNode temp=right;
            right=right.next;
            //先指向后面，left再指向temp
            temp.next=left.next;
            left.next=temp;
            left=temp.next;
        }
    }

    public static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) fast = fast.next;

            slow = slow.next;
        }
        return slow;
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

    /**
     * 判断链表环的起点
     * 思路：
     * 1、一快一慢两个指针，相遇位置即在环内
     * 2、一个回到原点，继续都走一步，直到相遇，相遇的位置即为环入口
     */
    public ListNode detectCycle(ListNode head) {

        if (head==null||head.next==null) return null;

        ListNode p=head;
        ListNode q=head;
        while (q!=null&&q.next!=null){
            p=p.next;
            q=q.next;
            if (q.next==null) return null;
            q=q.next;
            if (p==q){
                p=head;
                while (p!=q){
                    p=p.next;
                    q=q.next;
                }
                if (p==q) return p;
            }
        }
        return null;
    }

}
