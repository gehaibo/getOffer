package 算法分类.经典.进制之间转换;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/6/23.
 */
public class Main33 {

    static char[] characters = new char[62];

    static int getValue(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch - '0';
        else if (ch >= 'a' && ch <= 'z')
            return ch - 'a' + 10;
        else
            return ch - 'A' + 36;
    }

    //radix进制转十进制
    public static int radixConvert(int radix, String num) {
        char[] nums = num.toCharArray();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += getValue(nums[i]) * Math.pow(radix, nums.length - i - 1);
        }
        return result;
    }

    //十进制转radix进制
    public static String radixConvert2(int num, int radix) {
        //递归结束条件
        StringBuilder result = new StringBuilder();
        int q = num;
        int r;
        while (q != 0) {
            r = q % radix;
            q = q / radix;
            result.append(characters[r]);
        }
        return result.reverse().toString();
    }

    //顺序为0-9 a-z A-Z
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i)
            characters[i] = (char) (i + '0');
        for (int i = 10; i < 10 + 26; ++i)
            characters[i] = (char) ('a' + i - 10);
        for (int i = 36; i < 10 + 26 + 26; ++i)
            characters[i] = (char) ('A' + i - 36);
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        String num = sc.next();
        System.out.println("way1" + radixConvert2(radixConvert(from, num), to));

    }


    //此方法同下面
    public static void hexTo(String str, int hexM, int hexN) {
        System.out.println(Integer.toString(Integer.parseInt(str, hexM), hexN));
    }


    //只能再2到36之间
    public static void change() {
        /**
         * 直接使用了BigInteger类型，因为BigInteger有这样的数据结构：
         * BigInteger(String val,  int radix)
         * 将指定基数的 BigInteger 的字符串表示形式转换为 BigInteger。
         * 还有这样的toString方法：
         * toString(int radix)  返回此 BigInteger 的给定基数的字符串表示形式。
         * 再根据题目要求，把string变成小写就好了。
         */

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int M = in.nextInt();
            int N = in.nextInt();
            String val = in.next();
            BigInteger big = new BigInteger(val, M);
            String ss = big.toString(N).toLowerCase();
            System.out.println(ss);
        }
    }
}
