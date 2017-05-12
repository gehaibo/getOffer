package 上机考试.京东;


import java.util.Scanner;

/**
 * 异或
 时间限制：C/C++语言 2000MS；其他语言 4000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 异或运算是常见的二进制运算，给出两个n位二进制数a，b。a异或b的运算依次考虑二进制的每一位，若这一位相同，那么这一位的异或结果就是0，不同就是1。
 例如a=1100, b=0100。执行a异或b的运算，a的最高位是1，b的最高位是0，两个数字不同所以最高位异或结果是1；a和b次高位都是1，所以次高位异或为0；最后两位它们都是0，所以异或结果也都是0。那么a异或b的答案就是1000。
 现在输入两个n位二进制数，输出它们异或结果的十进制答案。上述样例中异或的二进制结果为1000，转化成十进制就是8。
 输入
 输入有三行，第一行一个数n(1<=n<=20)，接下来两行有两个n位二进制数。输入的二进制数可能有前导零。
 输出
 输出一个数，异或结果的十进制数值，不要输出前导零。
 */

public class Main {

    public static int stringToInt(String string) {
        int len = string.length();
        int result = 0;
        int temp;
        int max = len - 1;
        for (int i = 0; i < len; ++i) {
            temp = string.charAt(i) - '0';
            result += temp * Math.pow(2, max--);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextInt()) {
            int n=reader.nextInt();
            String number1 = reader.next();
            String number2 = reader.next();
            char[] num1=number1.toCharArray();
            char[] num2=number2.toCharArray();


            int[] result=new int[n];

            for (int i = 0; i < n; i++) {
                if (num1[i]==num2[i])
                    result[i]=0;
                else
                    result[i]=1;
            }

            String out="";
            for (int i = 0; i <result.length ; i++) {
                out+=result[i];
            }
            //System.out.println("计算结果"+out);
            System.out.print(stringToInt(out));
        }

    }

}
