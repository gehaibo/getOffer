package test;

/**
 * Created by ghb on 2017/4/14.
 */
public class Test3 {
    public static void change(int a) {
        a = 50;
        System.out.println(a);
    }
    public static void change(int []a){
        a[0]=50;
    }

    public static void main(String[] args) {
//        int aa = 10;
//        change(aa);
//        System.out.println(aa);
//
//        int []a={10,20};
//        System.out.println(a[0]);
//        change(a);
//        System.out.println(a[0]);

//        System.out.println(2&1);
//        System.out.println(31&1);
        String a="0";
        System.out.println(a.equals("0"));
    }
}
