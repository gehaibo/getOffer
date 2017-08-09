package 上机考试.网易内推练习;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/8.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<String,Integer> set = new Hashtable<>();
        while(sc.hasNext()){
            String str = sc.next();
            set.put(str, 0);
        }
        System.out.println(set.size());
    }
}
