package 刷题归类.剑指offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jackson on 2017/5/10.
 */
public class 树50树两个结点的最低公共祖先 {
    private static class TreeNode {
        int val;
        List<TreeNode> children = new LinkedList<>();//申请空间。链表

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

//    /**
//     * 核心思路：如果root的左子树存在p，右子树存在q，那么root肯定就是最近祖先
//     * 当root非空时，对root->left和root->right分别进行搜索。
//     * 若搜索结果均非空，说明两个节点分别位于左右子树之中，LCA则为root；
//     * 若只有一个结果为空，则LCA是另一个非空的节点；若结果均空，则返回NULL
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        if (root == p || root == q)
//            return root;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        if (left != null && right != null) {
//            return root;
//        } else {
//            return left == null ? right : left;
//        }
//
//    }
    /**
     * 找树中两个结点的最低公共祖先
     *
     * @param root 树的根结点
     * @param p1   结点1
     * @param p2   结点2
     * @return 公共结点，没有返回null
     */
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null || p1 == null || p2 == null) {
            return null;
        }
        List<TreeNode> path1 = new LinkedList<>();
        getNodePath(root, p1, path1);//找到含有目标结点的从头到尾的路径
        List<TreeNode> path2 = new LinkedList<>();
        getNodePath(root, p2, path2);
        return getLastCommonNode(path1, path2);//找出两条路径的公共结点
    }

    /**
     * 找结点的路径
     *
     * @param root   根结点
     * @param target 目标结点
     * @param path   从根结点到目标结点的路径
     */
    public static void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        List<TreeNode> chrildren = root.children;
        //处理子节点
        for (TreeNode node : chrildren) {
            if (node == target) {
                path.add(node);
                return;
            } else {
                getNodePath(node, target, path);//递归寻找路径
            }
        }
        //现场还原
        path.remove(path.size() - 1);
    }

    /**
     * 找两个路径中的最后一个共同的结点
     *
     * @param p1 路径1
     * @param p2 路径2
     * @return 共同的结点，没有返回null
     */
    public static TreeNode getLastCommonNode(List<TreeNode> p1, List<TreeNode> p2) {
        Iterator<TreeNode> ite1 = p1.iterator();
        Iterator<TreeNode> ite2 = p2.iterator();//遍历两条路径
        TreeNode last = null;
        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNode tmp = ite1.next();//循环比较
            if (tmp == ite2.next()) {
                last = tmp;//从上往下找到最后的一个公共结点即就是最低公共祖先
            }
        }
        return last;
    }

    public static void main(String[] args) {
        test01();

    }

    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n4.children.add(n6);
        n4.children.add(n7);
        n3.children.add(n5);
        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);//生成一棵树
        System.out.println(getLastCommonParent(n1, n6, n8));
    }

}
