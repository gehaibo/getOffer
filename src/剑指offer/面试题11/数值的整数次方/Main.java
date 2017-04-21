package 剑指offer.面试题11.数值的整数次方;

/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路一：需要考虑base为0，exponent为负数这两种情况。传统公式求解时间复杂度O(n)

 * 思路二：递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
 * 时间复杂度O（logn）
 *  n&1=1为奇数，=0为偶数
 */
public class Main {
    public double Power(double base, int exponent){
        //未考虑0的0次方的情况
        double result=1;//不用单独列出exponent=0的情况，只要返回1就行
        for (int i = 0; i < Math.abs(exponent); i++) {
            result*=base;
        }
        if (exponent<0)
            result=1/result;

        return result;
    }

    //递归优化
    public double Power2(double base, int exponent){
        int n=Math.abs(exponent);
        if (n==0) return 1;
        if (n==1) return base;

        //递归计算，右移1位相当于除2
        double result=Power2(base,n>>1);
        result*=result;
        //判断奇偶，如果为奇数，少乘一个base
        if ((n&1)==1) result*=base;

        if (exponent<0) result=1/result;
        return result;
    }
}
