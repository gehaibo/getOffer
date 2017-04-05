package offer;

/**
 * Created by ghb on 2017/2/17.
 */
public class Item28 {

    /**
     * 第一个字符和剩下的字符
     */
    public static void permutation(char[] str){
        if(str == null){
            return;
        }

        permutation(str, 0);
    }

    private static void permutation(char[] str, int begin) {

        if(begin == str.length){
            System.out.println(str);
        }

        else{
            for(int i = begin; i < str.length; i++){
                //找出所有可以出现在首位的字符
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;

                //递归的求出后半部分的全排列
                permutation(str, begin + 1);

                //恢复数组
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;

            }
        }

    }

    public static void main(String[] args) {

        char[] str = {'a', 'b', 'c'};
        permutation(str);
    }


}
