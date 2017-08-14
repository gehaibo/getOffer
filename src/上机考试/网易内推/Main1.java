package 上机考试.网易内推;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/12.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int x = in.nextInt();//房费
            int f = in.nextInt();//现有水果
            int d = in.nextInt();//总价钱
            int p = in.nextInt();//每个水果价钱

            if (d < x) System.out.println(0);//不够一天
            if (d == x){
                if (f<1)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            int num = d / x;
            if (num <= f) System.out.println(num);//住房花完
            int res = ((d - f * x) / (p + x)) + f;
            System.out.println(res);
        }

    }
}