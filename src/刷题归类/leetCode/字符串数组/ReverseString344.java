package 刷题归类.leetCode.字符串数组;

/**
 * Created by Jackson on 2017/8/7.
 */
public class ReverseString344 {
    /**
     * 344. Reverse String
     * 前后交换，直到相遇
     */
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
