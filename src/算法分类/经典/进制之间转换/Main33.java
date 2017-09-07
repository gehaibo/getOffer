package 算法分类.经典.进制之间转换;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 将一个处于Integer类型取值范围内的整数从指定源进制转换为指定目标进制；
 可指定的进制值范围为[2,62]； 每个数字位的可取值范围为[0-9a-zA-Z]；
 输出字符串的每一个都须为有效值；反例："012"的百位字符即为无效值。 实现时无需考虑非法输入。
 输入描述:
 输入为：
 源进制 目标进制 待转换的整数值

 例子：8 16 12345670
 输出描述:
 整数转换为目标进制后得到的值
 示例1
 输入
 8 16 12345670
 输出
 29cbb8
 */
public class Main33 {

    static char[] characters = new char[62];

    static int getValue(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch - '0';
        else if (ch >= 'a' && ch <= 'z')
            return ch - 'a' + 10;//a-97
        else
            return ch - 'A' + 36;//A-65
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
        System.out.println(radixConvert2(radixConvert(from, num), to));

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
