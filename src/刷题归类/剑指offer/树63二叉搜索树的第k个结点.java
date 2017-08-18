package 刷题归类.剑指offer;

import 刷题归类.TreeNode;

/**
 * 二叉搜索树，k大的节点
 * 中序遍历的顺序就是从小到大的顺序
 * 中序遍历二叉树打印的时候我们在递归完左子树之后打印根结点，本题目要求的当然不是打印，
 * <p>
 * 检查的顺序就是左中右
 * 如果左子结点不是要找的结点，才会访问根结点，所以访问到根结点的时候要做的操作是将k减去1，因为左子结点已经证实不是要找的结点了，排除左子结点。
 * 这个过程可以看成目标移位的过程，每移过一个结点，K减1，直到K等于1时，当前结点就是要求的结点。
 */
public class 树63二叉搜索树的第k个结点 {
    int num = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        num = k;
        return KthNode(pRoot);
    }

    TreeNode KthNode(TreeNode root) {
        TreeNode t = null;
        if (t == null && root.left != null)//递归走到底
            t = KthNode(root.left);
        if (t == null && num == 1)
            t = root;
        else
            num--;
        if (t == null && root.right != null)
            t = KthNode(root.right);
        return t;
    }
}
