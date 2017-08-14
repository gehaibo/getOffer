package 刷题归类.剑指offer;

/**
 * 1.新链表插在原链表后面
 * 2.新链表随机指在原链表随机的后面
 * 3.奇数位为原节点，偶数位为新复制节点
 */

public class 链表26复杂链表的复制 {
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectNode(pHead);
        return reconnectNode(pHead);
    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode fHead = pHead;
        while (fHead != null) {
            RandomListNode neHead = new RandomListNode(pHead.label);
            neHead.next = fHead.next;
            fHead.next = neHead;
            fHead = neHead.next;
        }
    }

    private void connectNode(RandomListNode pHead) {
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode neHead = p.next;
            neHead.random = p.random.next;
            p = neHead.next;
        }
    }

    private RandomListNode reconnectNode(RandomListNode pHead) {

        RandomListNode re = pHead.next, pCur = pHead, cur = pHead;//cur当前复制的链表
        while (pCur != null) {
            pCur.next = pCur.next.next;
            if (cur.next != null)
                cur.next = cur.next.next;
            pCur = pCur.next;
            cur = cur.next;
        }
        return re.next;
    }
}

