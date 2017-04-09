package Others;

/**
 * Created by ghb on 2017/3/9.
 */
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode p = head;
        ListNode f = head.next;
        while ( f.next !=null && f.next.next !=null ){//locate p at half of the Others.ListNode
            p = p.next;
            f = f.next.next;
        }

        ListNode h2 = sortList(p.next);
        p.next = null;

        return merge( sortList (head) , h2 );

    }

    public ListNode merge(ListNode h1,ListNode h2){

        ListNode hn = new ListNode(-1);
        ListNode c = hn;

        while (h1 != null && h2 != null ){
            if (h1.val <= h2.val){
                c.next = h1;
                h1 = h1.next;
            }else {
                c.next = h2;
                h2 = h2.next;
            }
            c = c.next;
        }

        if(h1 == null){
            c.next = h2;
        }else{
            c.next = h1;
        }

        return hn.next;

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(0);//问题2
        ListNode p = head;
        while(l1!=null&&l2!=null){//问题3和4
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2= l2.next;
            }
            p=p.next;
        }
        if(l1!=null){//问题1和5
            p.next=l1;
        }
        if(l2!=null){
            p.next=l2;
        }
        return head.next;
    }
}
