package java基础.Lambda;

/**
 * Created by Jackson on 2017/7/7.
 */
public class Test {
    public static void main(String[] args) {
        //一般
        //Converter converter1=from -> Integer.valueOf(from);
        Converter converter1=Integer::valueOf;

        Integer val=converter1.converter("99");
        System.out.println(val);
    }
}
