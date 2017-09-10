package 上机考试.京东d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/9/8.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] a=string.trim().toCharArray();
        long res=1;
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < a.length ; i++) {

            if (a[i]=='('){
                list.add('(');
            }else {
                res*=list.size();
                list.remove(list.size() - 1);
            }
        }
        System.out.println(res);
    }
}
