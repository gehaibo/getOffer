package javaBase.集合;

import java.util.*;

/**
 * Created by Jackson on 2017/7/19.
 */
public class lll {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("zaijain");
        list.add("lala");
        list.add("vvv");
        list.add(null);
        Vector vector;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            it.remove();
        }
        System.out.println(list.size() + ":" + list.get(2));
        Integer in;
        LinkedList linkedList;
        Queue q;
    }
}
