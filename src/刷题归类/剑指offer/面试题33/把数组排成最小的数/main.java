package 刷题归类.剑指offer.面试题33.把数组排成最小的数;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最
 * 小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 最直接的方法就是求出数组的全排列，然后把每个排列拼起来，比较大小。但是这样太过复杂，
 * 更简单的方法是现将数组转换成String数组，然后用自定义规则将String数组排序，最后将
 * 排序好的字符串数组拼接出来。
 * 自定义排序规则：
 * ab > ba 则 a > b
 * ab < ba 则 a < b
 * ab = ba 则 a = b
 **/
public class main {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++)
            list.add(String.valueOf(numbers[i]));//不能用numbers[i].toString()

        Collections.sort(list, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < numbers.length; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
