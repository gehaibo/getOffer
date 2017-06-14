package 算法分类.leetCode.链表;

import java.util.HashMap;

/**
 * Created by Jackson on 2017/5/10.
 */
public class 两链表第一个公共节点_160 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先分别
     * 思路一：分别放入栈中，然后依次出站比较时间和空间复杂度都是O（m+n）
     * 思路二：分别遍历计算长度，然后，长的多走几步，再依次比较，第一个相等的就是
     */
    public ListNode getIntersectionNode1(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;

            current2 = current2.next;
        }
        return null;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int dif = lengthA - lengthB;

        //标记长和短
        ListNode headL = headA;
        ListNode headS = headB;

        //不确定哪个长
        if (lengthA < lengthB) {
            headL = headB;
            headS = headA;
            dif = -dif;
        }

        //长的先走dif步
        for (int i = 0; i < dif; i++) {
            headL = headL.next;
        }
        //比较
        while (headL != null && headS != null && headL.val != headS.val) {
            headL = headL.next;
            headS = headS.next;
        }
        return headL;
    }

}