package 刷题归类.剑指offer;

/**
 * 题目：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy
 * 则经过替换之后的字符串为We%20Are%20Happy
 * <p>
 * 思路： 1.如果使用replaceAll方法，则只需要一行代码str.toString.replaceAll(" ", "%20");
 * <p>
 * 2.从前往后遍历一次，得到空格总数，并计算新字符串的长度=old+2*空格，然后从后往前替换，从而防止同一个字符多次移动。
 */
public class 字符串04替换空格 {

    public static String replaceSpace(StringBuffer str) {
        int space = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') space++;
        }
        //扩容
        int oldLength = str.length();
        int newLength = oldLength + 2 * space;

        str.setLength(newLength);

        int oldIndex=oldLength-1;//索引都是从零开始
        int newIndex=newLength-1;

        while (oldIndex >= 0 && oldIndex < newIndex) {
            if (str.charAt(oldIndex) != ' ') {
                str.setCharAt(newIndex--, str.charAt(oldIndex));//不为空格，直接赋值
            } else {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }
            oldIndex--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String string = "We are happy.";
        //System.out.println(string.replaceAll(" ", "%20"));
        System.out.println(replaceSpace(new StringBuffer(string)));
    }
}
