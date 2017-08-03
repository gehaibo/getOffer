package 算法分类.经典.字符串按顺序输出;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/6/28.
 */
public class Main {
    //正常调用sort是数大小
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String strings=sc.nextLine();
        char[] words=strings.toCharArray();
        Arrays.sort(words);

        StringBuilder low=new StringBuilder();
        StringBuilder high=new StringBuilder();
        StringBuilder num=new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i] >= '0' && words[i] <= '9'){
                num.append(words[i]);
            }else if (words[i] >= 'a' && words[i] <= 'z'){
                low.append(words[i]);
            }else if (words[i] >= 'A' && words[i] <= 'Z'){
                high.append(words[i]);
            }
        }
        StringBuilder result=new StringBuilder();
        result.append(low).append(high).append(num);
        System.out.println(result.toString());
    }
}
