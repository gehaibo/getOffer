package 上机考试.华为;

import java.util.Arrays;

/**
 * Created by Jackson on 2017/6/24.
 */
public class Test1 {
    public static void main(String[] args) {
        String s="abc12AB3C";
        char[] a=s.toCharArray();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
