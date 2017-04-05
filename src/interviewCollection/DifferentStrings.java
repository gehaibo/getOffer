package interviewCollection;

/**
 * Created by ghb on 2017/3/29.
 */
public class DifferentStrings {
    //1.1字符串字符是否完全相等
    public static boolean isUnique(String str){
        if (str.length()>256) return false;

        boolean[] charSet=new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]){//字符已经出现并赋值为true
                return false;
            }

            charSet[val]=true;
        }
        return true;
    }



    public static void main(String[] args) {
        String str = "abcdaAB";
        System.out.println(isUnique(str));

    }
}
