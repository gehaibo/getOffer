package 剑指offer.面试题56.链表中环的入口节点;

/**
 * Created by ghb on 2017/4/14.
 */
public class Main {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                p1=pHead;
                while(p1!=p2)
                {
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2)return p1;
            }
        }
        return null;
    }
}
