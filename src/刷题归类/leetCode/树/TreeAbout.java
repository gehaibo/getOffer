package 刷题归类.leetCode.树;

import java.util.ArrayList;

/**
 * Created by ghb on 2017/4/5.
 */


public class TreeAbout {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //指向父节点的二叉树
    public class TreeNodeR{
        int val = 0;
        TreeNodeR left = null;
        TreeNodeR right = null;
        TreeNodeR parent=null;

        public TreeNodeR(int val) {
            this.val = val;
        }
    }
    //求二叉树两个节点的最小公共节点
    /**
     *1.树为二叉搜索树
     * 因为二叉搜索树都是排序过的，位于左子树的节点都比父节点小，而位于右子树上面的节点都比父节点大。
     * 这样从上到下，找到的第一个在两个输入结点的值之间的节点，就是最低的公共祖先。
     */
    public static TreeNode getLowestCommonAncestor(TreeNode root,TreeNode node1,TreeNode node2){
        if(root == null || node1 == null || node2 == null){
            return null;
        }
        if(root.val>node1.val&&root.val>node2.val){
            root=root.left;
        }else if(root.val<node1.val&&root.val<node2.val){
            root=root.right;
        }else{
            return root;
        }
        return null;
    }

    /**
     *2.带父节点指针的树
     * 直接从两个节点向上遍历，直到遍历到公共节点为止
     */
    public static TreeNodeR getLowestCommonAncestor2(TreeNodeR root,TreeNodeR node1,TreeNodeR node2){

        return null;

    }

    //递归求二叉树的深度
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;

        int left =TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return left>right?(left+1):(right+1);

    }

    //判断二叉树是否为平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        if (Math.abs(left - right)>1)
            return false;

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    public  int getTreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;

    }

    //输入两棵二叉树A，B，判断B是不是A的子结构。
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
         boolean flag=false;

         //第一步需要查找根节点是否相同
         if (root1!=null&&root2!=null){
             //下面相当于中序遍历一次比较节点
             if (root1.val==root2.val) flag=isSubTree(root1,root2);

             if (!flag) flag=isSubTree(root1.left,root2);
             if (!flag) flag=isSubTree(root1.right,root2);
         }

         return flag;
    }

    //找到根节点后依次向下比较左子树和右子树
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null) return false;

        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }

    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    // 全局变量，用于存储得到的每一个路径
    ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();

    /**
     * 建立额外一个函数，用来实现递归求解
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        if (root == null) {
            return resultsList;
        }

        int curSum = 0;
        int index = 0;
        int []path = new int[1000];
        this.isTargetPath(root, target, curSum, path, index);

        return this.resultsList;
    }

    /*
     * 递归求解函数
     * 思路很明白，把根节点到叶节点的路径上的值都加起来，
     * 所以在递归的过程中，需要逐个累加，并且累加的同时，还要将沿途经过的节点值记录下来，
     * 如何在递归函数中实现这一切功能呢？参数！！可用传参的方式解决
     *
     * @param eleNode   当前节点
     * @param target    目标和
     * @param curSum    当前已经累积到的和
     * @param path  记录到当前的节点位置，经过的路径
     * @param index 从根节点到当前节点为止，存的节点的数目
     */
    public void isTargetPath(TreeNode eleNode, int target, int curSum, int []path, int index) {
        if (eleNode == null) {
            return;
        }

        curSum += eleNode.val;
        // 把该节点包含进去
        path[index] = eleNode.val;
        index ++;

        // 当前已经是处于叶子节点，并且累计的和与target相等
        if (curSum == target && eleNode.left == null && eleNode.right == null) {
            // 将得到的结果放在外层结构中
            ArrayList<Integer> pathList = new ArrayList<Integer>();
            for (int i = 0; i < index; i++) {
                pathList.add(path[i]);
            }
            resultsList.add(pathList);
            return;
        }

        // 该节点有左子节点，前提还是要curSum 小于 target，否则递归就没有意义了
        if (curSum < target && eleNode.left != null) {
            this.isTargetPath(eleNode.left, target, curSum, path, index);
        }

        // 右子节点
        if (curSum < target && eleNode.right != null) {
            this.isTargetPath(eleNode.right, target, curSum, path, index);
        }
    }
}
