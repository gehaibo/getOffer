package javaBase.clone;

import java.util.Collection;

/**
 * Created by ghb on 2017/1/1.
 */
public class Outer {

    int out1 = 1;
    private int out2 = 2;
    int inner = 1111;

    class inner{
        int inner = 2222;
        int inner1 = 11;
        private int inner2 = 22;
    }

    public void accessInnerProp(){
        System.out.println(new inner().inner);
        System.out.println(inner);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.accessInnerProp();
        Collection collection;
        //Outer.inner inner = new inner();
    }
}
