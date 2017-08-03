package 刷题归类.剑指offer;

/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 思路：第一步，先在树A中找到和B的根节点的值一样的结点R
 * 第二步，判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 * <p>
 * 实现：1、在树1中查找与树二根节点相同的节点，一直到为null
 * 2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
 * 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 * 再判断右子树和tree2是否相同
 * 3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 * DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
 * tree1为空有两种情况
 * 1）如果tree1为空&&tree2不为空说明不匹配，
 * 2）如果tree1为空，tree2为空，说明匹配。
 */
public class 树18树的子结构 {

    //不相等就递归左子数和右子数查找是否相等，若相同，调用比较是否为子树
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;//一旦找到就置为true，立即停止
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) result = doesHave(root1, root2);

            if (!result) result = HasSubtree(root1.left, root2);
            if (!result) result = HasSubtree(root1.right, root2);

        }
        return result;
    }

    boolean doesHave(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null) return true;
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null) return false;
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) return false;

        return doesHave(root1.left, root2.left) && doesHave(root1.right, root2.right);
    }
}
