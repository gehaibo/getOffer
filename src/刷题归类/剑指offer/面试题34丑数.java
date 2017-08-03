package 刷题归类.剑指offer;

/**
 * Created by ghb on 2017/4/14.
 */
public class 面试题34丑数 {
    /**
     * 题目：把只包含因子2、3和5的数称作丑数(Ugly Number).例如6、8都是丑数，但14不是，
     *		因为它包含因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *	PS：一个数 m 是另一个数 n 的因子，是指 n 能被 m 整除，也就是 n % m == 0.
     */

/**
 * 基本思路：根据丑数的定义，如果一个数能被 2 整除，则将其连续除以 2；如果能被 3 整除，
 *		   则将其连续除以 3；如果能被 5 整除，则将其连续除以 5。如果最后的得到的值 1，
 *		   则这个数为丑数。
 * 缺点：每次求都需要从新计算，时间复杂度高，重复计算太多。
 **/

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        if (index == 1)
            return 1;
        int indexNnmber = 2;
        while(index > 1) {
            if( isUglyNumber(indexNnmber) )
                index --;
            indexNnmber ++;
        }
        return indexNnmber;
    }
    public boolean isUglyNumber(int number) {
        while(number % 2 == 0)
            number /= 2;
        while(number % 3 == 0)
            number /= 3;
        while(number % 5 == 0)
            number /= 5;
        return (number == 1) ? true : false;
    }
}
