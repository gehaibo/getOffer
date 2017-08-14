package 刷题归类.剑指offer;

/**
 * 链表中环的入口节点
 * 思路：
 * 1、一快一慢两个指针，相遇位置即在环内
 * 2、一个回到原点，继续都走一步，直到相遇，相遇的位置即为环入口
 */
public class 链表56链表中环的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2) return p1;
            }
        }
        return null;
    }
}
