package atest;

/**
 * Created by ghb on 2017/4/4.
 */
public class Sixteen {
    public static void main(String[] args) {
        System.out.println("10的二进制="+Integer.toBinaryString(10));
        System.out.println("10的八进制="+Integer.toOctalString(10));
        System.out.println("10的十六进制="+Integer.toHexString(10));

        byte a=0x00000003;
        System.out.printf("%x\n",a);
    }
}
