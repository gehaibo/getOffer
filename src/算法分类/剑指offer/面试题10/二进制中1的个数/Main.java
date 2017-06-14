package 算法分类.剑指offer.面试题10.二进制中1的个数;

/**
 * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 错误思路：因为本题考虑了负数的情况，所以用移位操作符时，右移会在高位补1，会使程序陷入死循环，因此不考虑移位运算。
 * 思路一：对n的二进制数的每一位都与1进行&运算(1依次左移1位)，来计算1的个数（但需要移动n次）
 * <p>
 * 思路二：一个整数不为0，那么这个整数至少有一位是1。
 * 把这个整数减1，再和原整数与，会把该整数最右边一个1变为0，
 * 一个二进制有多少个1，就进行多少次这样操作
 */
public class Main {
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }


    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
