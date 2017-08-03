package 刷题归类.剑指offer.面试题28.字符串的排列和组合;

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
//        ArrayList<String> result=Permutation("abc");
//        System.out.println(result.toString());
        Combination();
        Combination();
    }
    public static  void Combination( ) {
        /*基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是：
         * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
         * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
         * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
         * 000,001,010,011,100,101,110,111 。对应输出组合结果为：
        空,a, b ,ab,c,ac,bc,abc.
        这个输出顺序刚好跟数字0~2^n结果递增顺序一样
        取法的二进制数其实就是从0到2^n-1的十进制数
         * ******************************************************************
         * *
         * */
        String[] str = {"a" , "b" ,"c"};
        int n = str.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1<<n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        System.out.println("全组合结果个数为："+nbit);

        for(int i=0 ;i<nbit ; i++) {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("组合数值  "+i + " 对应编码为： ");
            for(int j=0; j<n ; j++) {                        //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1<<j ;
                if((tmp & i)!=0) {                            //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
