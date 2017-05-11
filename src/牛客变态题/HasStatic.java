package 牛客变态题;

/**
 * Created by Jackson on 2017/4/25.
 */
public class HasStatic {
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        HasStatic hsl = new HasStatic();// 4
        hsl.x++;// 5
        HasStatic hs2 = new HasStatic();// 6
        hs2.x++;// 7
        hsl = new HasStatic();// 8
        hsl.x++;// 9
        HasStatic.x--;// 10
        System.out.println(" x=" + x);// 输出102
    }
}
