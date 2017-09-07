package 算法分类.经典;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/6/10.
 */
public class hannuota {
    //使用递归法求解含有n个不同大小盘子的汉诺塔移动路径，参数n为盘子数，把A塔上盘子全部移动到C塔上，B为过渡塔
    public static void recursionHanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.print(A + "——>" + C + "\n");      //A是源，c是目的，最后一步只需把最后一个移动到位置就ok了
        } else {
            recursionHanoi(n - 1, A, C, B);         //使用递归先把起始最上面的n-1个盘子移动到目的地B，C过渡
            System.out.print(A + "——>" + C + "\n");     //把A塔中底下最大的圆盘，移动到C塔上
            //相当于要继续把n-1个b上的移到目的地c，a作为过渡
            recursionHanoi(n - 1, B, A, C);         //使用递归把B塔上n-1个盘子移动到C塔上，A为过渡塔
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入盘子总数n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        recursionHanoi(n, 'A', 'B', 'C');
    }
}
