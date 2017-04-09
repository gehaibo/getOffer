package jingdong;

import java.util.Scanner;

/**
 * Created by ghb on 2017/4/7.
 * 分堆A
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 小明得到了n个石头，他想把这些石头分成若干堆，每堆至少有一个石头。他把这些石堆排在一条直线上，他希望任意相邻两堆的石头数都不一样。小明最后的得分为石头数大于等于k的石堆数，问他最多能得多少分。
 严格地，小明把n个石头分成了m堆，每堆个数依次为a1，a2，.....，am。要求满足：
 1、ai≥1（1≤i≤m）
 2、ai≠ai+1（1≤i＜m）
 3、a1+a2+...+am＝n
 小明想知道a1，a2.....，am中大于等于k的数最多能有多少个？
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextInt()) {
            int m = reader.nextInt();
            int n = reader.nextInt();


            if (m == 1 && n == 1) System.out.print(1);
            if (m == 2 && n == 1) System.out.print(1);
            //
            if (m > 2 && n == 1) System.out.print(m - 2);

            if (m > 2 && n > 1) System.out.print(m / n - 1);
        }
    }
}
