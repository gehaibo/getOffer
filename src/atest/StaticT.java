package atest;

/**
 * Created by Jackson on 2017/9/9.
 */
public class StaticT {
    public static int a;
    public static void change(int b){
        a=b;
    }

    public static void main(String[] args) {
        int c=010;
        StaticT.change(3);
        System.out.println(StaticT.a);
        System.out.println(c);
    }
}
