package 刷题归类.剑指offer.面试题09.斐波那契数列系列问题.青蛙跳台阶;

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 思路：跳上n阶台阶有f(n)种跳法，若第一步跳上1阶，剩下n-1阶有f(n-1)种，若第一步跳上2阶，剩下n-2阶有f(n-2)种.
 * 则f(n)=f(n-1)+f(n-2),即为斐波那契数列
 * n=1时只能跳一阶，n=2时，可以跳1，可以直接跳二;
 */
public class Main {
    public int JumpFloor1(int target) {
        if (target <= 2) return target;
        return JumpFloor1(target - 1) + JumpFloor1(target - 2);
    }

    public int JumpFloor2(int target){
        if (target <= 2) return target;

        int f1 = 1;
        int f2 = 2;
        int f=0;
        for (int i = 3; i <= target; ++i) {
            f=f1+f2;
            f1=f2;
            f2=f;
        }
        return f;
    }
}
