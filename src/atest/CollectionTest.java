package atest;

import java.util.*;

/**
 * Created by Jackson on 2017/7/23.
 */
public class CollectionTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap();
        System.out.println(map.get(0));
        Collection<Integer> cl = new ArrayList();
        LinkedList ls;
        cl.add(1);
        cl.add(2);
        cl.add(3);
        System.out.println(cl.toString());
        Deque<Integer> stack = new LinkedList<>();
        stack.add(1);
    }

}
