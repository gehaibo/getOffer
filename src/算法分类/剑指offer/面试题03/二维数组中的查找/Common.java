package 算法分类.剑指offer.面试题03.二维数组中的查找;

/**
 * Created by Jackson on 2017/5/10.
 */
public class Common {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 核心思路：如果root的左子树存在p，右子树存在q，那么root肯定就是最近祖先
     * 当root非空时，对root->left和root->right分别进行搜索。
     * 若搜索结果均非空，说明两个节点分别位于左右子树之中，LCA则为root；
     * 若只有一个结果为空，则LCA是另一个非空的节点；若结果均空，则返回NULL
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }
}
