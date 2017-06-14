package 算法分类.剑指offer.面试题57.删除链表中重复的节点不保留;


/**
 * Created by ghb on 2017/4/10.
 */
public class Main {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 重复节点不保留
     */
    ListNode deleteDuplication2(ListNode head)
    {
        if (head == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;//保存前一个
        ListNode cur = head;//当前
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {//指向最后一个重复
                cur = cur.next;
            }
            if (pre.next == cur) {//无重复的，pre后移
                pre = pre.next;
            } else {//pre直接指向新的不重复的
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
