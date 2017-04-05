package basic;

/**
 * Created by ghb on 2017/2/20.
 */
public class Reverse {
    public static String reverse(String s){
        if (s == null || s.length()<=1)
            return s;
        return reverse(s.substring(1))+s.charAt(0);
    }

    public static void main(String[] args) {
        String s = "a";

        System.out.println(reverse(s));
    }

}
