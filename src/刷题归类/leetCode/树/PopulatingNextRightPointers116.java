package 刷题归类.leetCode.树;

/**
 * Created by Jackson on 2017/5/16.
 */


import 刷题归类.TreeLinkNode;

/**
 * 思路：初始化next都为空，所以最右边的不用处理，next默认为null
 * 要利用上层初始化的next，cur.next即是cur的兄弟节点
 */
public class PopulatingNextRightPointers116 {

    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;//控制每层的开始加点
        while (start != null) {
            TreeLinkNode cur = start;//
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;//处理左子树
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;//处理右子树，但不是最右边的
                }
                cur = cur.next;//处理兄弟的左右节点
            }
            start = start.left;
        }
    }
}
