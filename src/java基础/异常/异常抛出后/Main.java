package java基础.异常.异常抛出后;

/**
 * Created by Jackson on 2017/7/13.
 */
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try { // try监控区域
            if (b == 0) throw new ArithmeticException(); // 通过throw语句抛出异常
            System.out.println("a/b的值是：" + a / b);
            System.out.println("this will not be printed!");
        } catch (ArithmeticException e) { // catch捕捉异常
            System.out.println("程序出现异常，变量b不能为0！");
        }
        System.out.println("程序正常结束。");
    }
}
