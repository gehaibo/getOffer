package swordOffer;

/**
 * Created by ghb on 2017/4/5.
 */
public class StringAbout {

    /**
     * 面试题4-替换空格：实现一个函数，把字符串中的每个空格替换成"%20"。
     * 思路：先遍历一遍，找到空格的个数，计算新的字符串的长度=旧的字符串的长度+空格数*2，
     * 然后从尾部向前遍历，遇到非空格，则复制到新的位置，否则直接添加新字符。
     * 在Java中，字符替换主要有两种：replace(char oldChar, char newChar)和replaceAll(StringAbout regex, StringAbout replacement)。
     * Created by ghb on 2016/12/22.
     */
    /**
     * @param chars  带空格的字符数组
     * @param length 第一个字符到最后一个字符的长度，不是字符数组的长度
     * @return
     */
    private static String replaceBlank(char[] chars, int length) {

        int blank = 0;
        for (int i = 1; i < length; i++) {
            if (chars[i] == ' ') {//单引号
                blank++;
            }
        }

        int lengthNew = length + blank * 2;

        //两个指针分别记录当前位置
        int j = length - 1;
        int k = lengthNew - 1;
        while (j >= 0 && k >= 0) {
            if (chars[j] != ' ') {
                chars[k--] = chars[j];
            } else {
                chars[k--] = '0';
                chars[k--] = '2';
                chars[k--] = '%';
            }
            j--;
        }

        return new String(chars);
    }

    /**
     * 14:第一个字符和剩下的字符
     */
    public static void permutation(char[] str){
        if(str == null){
            return;
        }

        permutation(str, 0);
    }

    /**
     * 面试题14：
     */
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

        //offer-4:替换空格
        String s = "We are happy.";
        char oldChar[] = s.toCharArray();
        // 假设新的空间的大小可以存下替换后的字符
        char newChar[] = new char[100];
        for (int i = 0; i < oldChar.length; i++) {
            newChar[i] = oldChar[i];
        }
        // 输出新的数组
        System.out.println(replaceBlank(newChar, oldChar.length));
        //直接调用JAVA自带的
        System.out.println(s.replace(" ","%20"));

        //offer-14:
        char[] str = {'a', 'b', 'c'};
        permutation(str);

    }



}
