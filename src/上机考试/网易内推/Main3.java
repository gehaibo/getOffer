package 上机考试.网易内推;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/12.
 */
public class Main3 {
    public static BigInteger bigInteger(int n) {
        BigInteger result = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
                BigInteger num = new BigInteger(String.valueOf(i));
                result = result.multiply(num);
            }
            return result;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();//长度
            int k = in.nextInt();//范围

            long cout=0;//计数
            boolean b=false;
            int[] f=new int[k+1];
            for (int i = 1; i <= k; i++) {
                for (int j = 2; j <=n; j++) {
                   // if (j)
                }
            }
            System.out.println(  );
            }


       }
    }