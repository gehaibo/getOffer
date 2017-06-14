package 算法分类.剑指offer.面试题09.斐波那契数列系列问题.斐波那契数列;

import java.math.BigInteger;

/**
 * 题目：现在要求输入一个整数n，请你输出斐波那契数列的第n项。（n<=39）
 *
 * 思路一：递归，大量重复计算，会StackOverFlow
 * 思路二：迭代（使用fn1和fn2保存计算过程中的结果，并重复使用）
 * 思路三：算法分类.动态规划（使用数组记录每一步计算结果）
 *
 * PS：兔子问题中兔子每个月的出生数同为斐波那契数列问题。
 */
public class Main {

    //递归
    public int Fibonacci(int n) {
        if(n <= 2)
            return 1;
        else
            return Fibonacci(n-1) + Fibonacci(n-2);
    }

    //迭代实现,当为大数时
    public int Fibonacci2(int n) {
        int[] result={0,1};
        if (n<2) return result[n];

        BigInteger f1=new BigInteger("1");
        BigInteger f2=new BigInteger("0");
        BigInteger f=new BigInteger("0");
        BigInteger t=new BigInteger("1000000007");
        for (int i = 2; i <= n; ++i) {
            f=f1.add(f2);
            f2=f1;
            f1=f;
        }
        return f.mod(t).intValue();
    }
    //
    public int Fibonacci22(int n) {
        int[] result={0,1};
        if (n<2) return result[n];

        int f1 = 0;
        int f2 = 1;
        int f=0;
        for (int i = 2; i <= n; ++i) {
            f=f1+f2;
            f1=f2;//从前往后依次替换
            f2=f;
        }
        return f;
    }

    //算法分类.动态规划
    public int Fibonacci3(int n) {
        if(n <= 0)
            return 0;
        if(n <= 2)
            return 1;
        int [] array = new int [n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2;i <= n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }
}
