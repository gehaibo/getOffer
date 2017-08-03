package 上机考试.拼多多;

import java.util.Scanner;

/**
 * 1、转换并反转，字序反转；
 2、逐位相乘，结果存放在res[i+j]中；
 3、处理进位；
 4、转换并反转，将计算结果转换为字符串并反转。
 5、消除多余的0；
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextInt()) {//注意while处理多个case
            String input = reader.nextLine();
            String[] num = input.split(" ");
            //把字符串转换成char数组
            char ch1[] = num[0].toCharArray();
            char ch2[] = num[1].toCharArray();

            int length1 = ch1.length;
            int length2 = ch2.length;
            //存储结果集
            int result[] = new int[length1 + length2];
            int n1[] = new int[length1];
            int n2[] = new int[length2];


            for (int i = 0; i < length1; i++)
                n1[i] = ch1[i] - '0';
            for (int i = 0; i < ch2.length; i++)
                n2[i] = ch2[i] - '0';

            //两个数相乘对应位置
            for (int i = 0; i < length1; i++) {
                for (int j = 0; j < length2; j++) {
                    result[i + j] += n1[i] * n2[j];
                }
            }

            for (int i = result.length - 1; i > 0; i--) {
                result[i - 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }

            StringBuilder out = new StringBuilder();
            for (int i = 0; i < result.length - 1; i++) {
                out.append(result[i]);
            }
            System.out.println(out.toString());
        }

    }

}
