package 刷题归类.leetCode.链表;

import 刷题归类.leetCode.ListNode;

/**
 * Created by Jackson on 2017/8/10.
 */
public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
