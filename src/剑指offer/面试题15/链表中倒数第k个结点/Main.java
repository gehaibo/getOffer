package 剑指offer.面试题15.链表中倒数第k个结点;

/**
 * Created by ghb on 2017/4/13.
 */
public class Main {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode EntryNodeOfLoop(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return null;

        ListNode result = head;
        while (head.next != null) {
            if (k-- >= 0) {
                head = head.next;
            } else {
                head = head.next;
                result = result.next;
            }
        }
        if (k > 1) return null;//k超出了范围
        return result;
    }
}
