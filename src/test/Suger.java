package test;

/**
 * Created by ghb on 2017/2/21.
 */
public class Suger {
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);//1
        System.out.println(e==f);//0
        System.out.println(c==(a+b));//true
        System.out.println(c.equals(a+b));//1
        System.out.println(g==(a+b));//true
        System.out.println(g.equals(a+b));//false


        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1==str2);//false
        System.out.println(str1.equals(str2));//true
        Object java;

    }
}
