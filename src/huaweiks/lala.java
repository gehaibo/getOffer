package huaweiks;

/**
 * Created by ghb on 2017/3/24.
 */
public class lala {

    public static int reverseAdd(String str) {
//        if (str.length()==1)
//            return Integer.parseInt(str);

        String str2 = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(str2);
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 4;
        int c = a / b;
        int d = c++ * a * b++;
        System.out.println(d);
        System.out.println(b);
        System.out.println(c);
        //String str2=

//        String str2=str.substring(1,str.length())+str.substring(0,1);
//        System.out.println(str2);
        //System.out.println(str2);


        //System.out.println(103%100);
    }
}
