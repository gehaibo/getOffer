package 刷题归类.剑指offer;

/**
 * 字符序列S=”abcde”,要求输出循环左移2位后的结果，即"cdeab"
 * 反转：1. ba edc   2. cdeab
 * <p>
 * public String substring(int beginIndex, int endIndex)
 * 返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，一直到索引 endIndex - 1 处的字符
 */
public class 字符串42对左旋转字符串 {
    public static String LeftRotateString(String str, int n) {
        if (str.length() == 0 || n < 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(str.substring(0, n));
        StringBuffer sb1 = new StringBuffer(str.substring(n, str.length()));
        sb1.append(sb);
        return sb1.toString();
    }


    static void reverse(char[] chars, int l, int r) {
        if (chars == null || chars.length < 2) return;
        while (l <= r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }
    }

    public static String LeftRotateString2(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public static void main(String[] args) {
        String string = "abcde";

        System.out.println(LeftRotateString2(string, 2));
    }

}
