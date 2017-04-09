package leetCode;

/**
 * Created by ghb on 2017/4/5.
 */
public class StringAbout {
    //1.1字符串字符是否完全相等
    public static boolean isUnique(java.lang.String str) {
        if (str.length() > 256) return false;

        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {//字符已经出现并赋值为true
                return false;
            }

            charSet[val] = true;
        }
        return true;
    }

    //返回首个出现的字符

    public char findFirstRepeat(String A, int n) {
        int[] ch = new int[256];
        for (int i = 0; i < n; i++) {
            ch[A.charAt(i)]++;
            if (ch[A.charAt(i)] > 1) {
                return A.charAt(i);
            }
        }
        return '\0';
    }


    public static void main(java.lang.String[] args) {
        java.lang.String str = "abcdaAB";
        System.out.println(isUnique(str));

    }
}
