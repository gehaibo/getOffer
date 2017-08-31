package 刷题归类.剑指offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * <p>
 * +2147483647    1a33
 * 2147483647    0
 */
public class 字符串49把字符串转化为整数 {
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++) {
            if (a[i] == '+')
                continue;
            //if (a[i] < 48 || a[i] > 57)
            if (a[i] < '0' || a[i] > '9')
                return 0;
            sum = sum * 10 + (a[i] - '0');

        }
        return fuhao == 0 ? sum : sum * -1;
    }

}
