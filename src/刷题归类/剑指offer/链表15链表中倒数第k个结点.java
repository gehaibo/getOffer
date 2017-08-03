package 刷题归类.剑指offer;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 思路：一个计数值i，ListNode head顺序遍历链表，同时i计数；当i=k时，ListNode result开始开始顺序遍历链表并与head同步；
 * 当i走到链表末尾时，result对应的值就是链表倒数第k个结点。
 */

public class 链表15链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k <= 0) return null;

        ListNode ANode = head;
        ListNode Bnode = null;
        for (int i = 0; i < k - 1; i++) {
            if (ANode.next != null) {
                ANode = ANode.next;
            } else {//k比链表还长
                return null;
            }
        }
        Bnode = head;//b从前往后走，一直走到A到末尾
        while (ANode.next != null) {
            ANode = ANode.next;
            Bnode = Bnode.next;
        }

        return Bnode;
    }
}
