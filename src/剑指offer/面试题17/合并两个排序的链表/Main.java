package 剑指offer.面试题17.合并两个排序的链表;

/**
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
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

    //递归求解
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = null;
        if (list1.val < list2.val) {
            result = list1;
            result.next = Merge(list1.next, list2);
        } else {
            result = list2;
            result.next = Merge(list1, list2.next);
        }
        return result;
    }

    //非递归求解
    public ListNode Merge2(ListNode list1, ListNode list2) {

        ListNode result=new ListNode(-1);//记录表头
        ListNode cur=result;//
        while (list1!=null&&list2!=null){//有一个结束就退出
            if (list1.val<list2.val){
                cur.next=list1;//cur指向他
                cur=list1;//cur后移
                list1=list1.next;
            }else {
                cur.next=list2;//cur指向他
                cur=list2;//cur后移
                list2=list2.next;
            }
        }

        if (list1==null)
            cur.next=list2;
        if (list2==null)
            cur.next=list1;

        return result.next;

    }
}
