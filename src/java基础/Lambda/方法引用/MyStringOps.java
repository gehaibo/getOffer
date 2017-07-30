package java基础.Lambda.方法引用;

/**
 * Created by Jackson on 2017/7/7.
 */
public class MyStringOps {
    //静态方法： 反转字符串
    public static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
