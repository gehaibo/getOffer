package 剑指offer.面试题28.字符串的排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 *      题目：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *		则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *		(长度不超过9(可能有字符重复),字符只包括大小写字母。)
 *
 *          固定第一个字符，递归取得首位后面的各种字符串组合；
 * 			再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 *			递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二
 *			个字符开始依次与第一个字符交换，然后继续处理子串。

 */
public class Main {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length()== 0)
            return result;
        HashSet<String> set = new HashSet<String>();//使用HashSet不需要考虑去重
        fun(set, str.toCharArray(), 0);
        result.addAll(set);
        Collections.sort(result);
        return result;
    }

    public static void fun(HashSet<String> set, char[] str, int index) {
        if (index == str.length) {
            set.add(new String(str));
            return;
        }
        //index为当前固定位
        for (int i = index; i < str.length; i++ ) {
            swap(str, i, index);
            fun(set, str, index + 1);
            swap(str, i, index);//复位
        }
    }
    public static void swap(char[] str, int i, int j) {
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> result=Permutation("abc");
        System.out.println(result.toString());
    }
}
