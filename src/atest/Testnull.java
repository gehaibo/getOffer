package atest;

/**
 * Created by Jackson on 2017/9/9.
 */
public class Testnull {
    public static void main(String[] args) {
        Testnull test=new Testnull();
        test.method(null);
    }


    public static void method(Object o){
        System.out.println(1);
    }

    public void method(String s){
        System.out.println(2);
    }
}
