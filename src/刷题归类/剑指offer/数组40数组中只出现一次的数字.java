package 刷题归类.剑指offer;

/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0
 * <p>
 * 1.任何一个数字异或它自己都等于0，也就是说，如果我们从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是哪个出现一次的数字
 * 2.想办法分成两组
 */
public class 数组40数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;
        int myxor = 0;//记录第一遍所有异或的结果
        int flag = 1;
        for (int i = 0; i < array.length; ++i)
            myxor ^= array[i];

        //flag标记异或结果从右往左第一个为1的位置
        while ((myxor & flag) == 0) flag <<= 1;

        for (int i = 0; i < array.length; ++i) {
            if ((flag & array[i]) == 0) //不是1，最后异或一定会得到一个单独的
                num2[0] ^= array[i];
            else
                num1[0] ^= array[i];  //是1，异或也会留下来
        }
    }
}
