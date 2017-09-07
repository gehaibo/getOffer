package 刷题归类.leetCode.链表;

import 刷题归类.leetCode.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * 类似头插法，
 *
 * <p>
 * <p>
 * <p>
 * p cur n
 * p->1->2->3->4->NULL
 * p->1->3->4->NULL
 * p->2  1->3->4->NULL
 * p->2->1->3->4->NULL
 *
 */
public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode neHead = new ListNode(0);
        neHead.next = head;
        ListNode pre = neHead, cur, next;
        //找到pre,m前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next=next.next;

            next.next=pre.next;
            pre.next=next;
        }
        return neHead.next;
    }
}
