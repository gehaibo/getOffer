package leetCode.树;

/**
 * Created by Jackson on 2017/5/17.
 */
public class Populating_next_Right_PointersII_117 {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}
