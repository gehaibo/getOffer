package 上机考试.实习.头条;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ghb on 2017/4/18.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set=new HashSet<>();
        while (sc.hasNext()){
            String temp=sc.nextLine();
            //System.out.print(temp+":"+temp=="111");
            if (!temp.equals("0")) {
                set.add(temp);
            }else {
                break;
            }
        }
        System.out.print(set.size());
    }
}
