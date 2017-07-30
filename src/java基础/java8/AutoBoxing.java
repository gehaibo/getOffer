package java基础.java8;

/**
 * Created by ghb on 2016/12/29.
 */
public class AutoBoxing {
    public static void main(String[] args) {

        //1.直接把基本变量赋值给Integer对象
        Integer intObj = 5;
        //2.直接把基本变量赋值给Object对象
        Object boolObject = true;
        if (boolObject instanceof Boolean) {
            boolean b = (Boolean) boolObject;
        }

        //String转为int
        String intStr = "111";
        int int1 = new Integer(intStr);
        int int2 = Integer.parseInt(intStr);

        /**
         * 1.通过String.valueOf(xxx)转换String str1 = String.valueOf(int1);
         * 2.将基本变量和""进行连接运算String str2 = it1 + "";
         */
        Integer a = new Integer(100);
        System.out.println("100的包装类实力是否大于50:" + (a > 50));
        System.out.println(new Integer(100) == new Integer(100));

        int i0 = 127;
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 0;
        Integer i4 = new Integer(127);
        Integer i5 = new Integer(127);
        Integer i6 = new Integer(127);

        System.out.println("1-i0=i4   " + (i0 == i4));
        System.out.println("2-i1=i2   " + (i1 == i2));
        System.out.println("3-i1=i2+i3   " + (i1 == i2 + i3));
        System.out.println("4-i1=i4   " + (i1 == i4));
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("5-i4=i5+i3   " + (i4 == i5 + i3));

        String s1 = "a";
        String s2 = "bc";
        String s3 = "abc";
        //编译时可以确定，可以引用常量池中字符串
        String s4 = "a" + "b" + "c";
        //编译时无法确定，不能引用常量池中字符串
        String s5 = s1 + s2;

        String s6 = new String("abc");
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false

        String str1 = "a";
        String str2 = "b";
        String str33 = new String("ab");

        String str3 = "ab";

        String str4 = str1 + str2;//常量池中已经存在，直接取出
        String str5 = "a" + "b";

        System.out.println(str3 == str33);//false
        System.out.println(str3 == str4); // false
        System.out.println(str3 == str4.intern()); // true
        System.out.println(str3 == str5);// true
    }
}
