package 算法分类.剑指offer.树06.重建二叉树;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 思路：前序遍历的第一个数是跟结点，在中序遍历中查找根节点，则根节点左边是其左子树，右边是其右子树；
 * 对应的根节点在中序遍历序列中的下标即为根节点左子树在前序遍历中的结点下标。同理，用递归的方法即可重建。
 */


public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStar, int preEnd, int[] in, int inStar, int inEnd) {
        if (preStar > preEnd || inStar > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStar]);

        //以中序为基准，找到根节点，划分左右节点
        for (int i = inStar; i <= inEnd; i++) {
            if (in[i] == pre[preStar]) {
                root.left = reConstructBinaryTree(pre, preStar + 1, preStar + (i - inStar), in, inStar, i - 1);
                root.right = reConstructBinaryTree(pre, preStar + (i - inStar) + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }
}
