package 刷题归类.剑指offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * <p>
 * 用逻辑与&&与短路特性实现递归终止
 * boolean ans = (n>0)&&。。。
 * 当n>0时，会一直递归执行Sum_Solution(n-1)
 * 直到n==0，开始return sum；
 */
public class 数组46求1到n的和 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
