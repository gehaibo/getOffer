package 刷题归类.剑指offer;

import 刷题归类.ListNode;

/**
 * Created by Jackson on 2017/8/23.
 */
public class 链表37两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode pCurrent1 = pHead1, pCurrent2 = pHead2;
        int length1 = 0, length2 = 0;
        while (pCurrent1 != null) {
            length1++;
            pCurrent1 = pCurrent1.next;
        }
        while (pCurrent2 != null) {
            length2++;
            pCurrent2 = pCurrent2.next;
        }

        pCurrent1 = pHead1;
        pCurrent2 = pHead2;
        while (length1 > length2) {
            pCurrent1 = pCurrent1.next;
            length1--;
        }
        while (length2 > length1) {
            pCurrent2 = pCurrent2.next;
            length2--;
        }
        while (pCurrent1 != null) {
            if (pCurrent1.val == pCurrent2.val) {
                return pCurrent1;
            }
            pCurrent1 = pCurrent1.next;
            pCurrent2 = pCurrent2.next;
        }
        return null;
    }
}
