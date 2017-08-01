package 算法分类.图;

import java.util.ArrayList;

/**
 * Created by Jackson on 2017/6/24.
 */
public class Main {
    public class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }


}
