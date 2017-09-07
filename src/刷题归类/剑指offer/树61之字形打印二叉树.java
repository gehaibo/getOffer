package 刷题归类.剑指offer;

import 刷题归类.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 所谓“之字形”打印，第一行是从左到右打印，第二行是从右到左打印，第三行又是从左到右打印.
 * <p>
 * ①定义两个栈一个名为 stack,另一个为nextStack，stack只保存奇数行的结点，nextStack只保存偶数行的结点。并定义一个整形变量lineNumber 来标记行号，以判断当前打印的行是奇数行结点还是偶数行结点。
 * ②当打印stack中的结点时，将该结点的孩子按照先 左孩子、后 右孩子的顺序 保存到nextStack栈中。
 * ③当打印nextStack中的结点时，将该结点的孩子按照先 右孩子，后 左孩子的顺序 保存到 stack栈中。
 * <p>
 * ----- 奇数层左右，偶数层右左
 * 下一层存左右， 下一层寸→左
 * <p>
 * 复杂度分析：
 * 由于每个结点都会入栈一次，然后出栈打印。故时间复杂度为O(N)
 * <p>
 * 代码中使用了两个辅助栈，分别用来保存奇数行的结点和偶数行的结点。故空间复杂度也是O(N)
 */
public class 树61之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;

        Stack<TreeNode> s1 = new Stack<>();//奇数
        s1.add(pRoot);
        Stack<TreeNode> s2 = new Stack<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {

            if (!s1.isEmpty()) {
                ArrayList<Integer> ls = new ArrayList<>();
                //一边存入节点，一边下一层入栈
                while (!s1.isEmpty()) {
                    TreeNode p = s1.pop();
                    ls.add(p.val);
                    if (p.left != null) s2.add(p.left);
                    if (p.right != null) s2.add(p.right);
                }
                res.add(ls);
            } else {
                ArrayList<Integer> ls = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode p = s2.pop();
                    ls.add(p.val);
                    if (p.right != null) s1.add(p.right);
                    if (p.left != null) s1.add(p.left);
                }
                res.add(ls);
            }
        }
        return res;
    }
}
