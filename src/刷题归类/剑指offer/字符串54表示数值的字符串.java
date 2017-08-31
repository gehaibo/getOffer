package 刷题归类.剑指offer;

/**
 * ？前面0或1
 * * 前面0或多
 * + 前面1或多
 * <p>
 * [abc]任意一个
 */
public class 字符串54表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    public boolean isNumeric2(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
