package huaweiks;

/**
 * Created by ghb on 2017/3/24.
 */
import java.util.Scanner;
public class Main2 {

    public static int[] lReverse(int[] num) {
        int temp1,temp2;
        temp1=num[0];
        temp2=num[1];

        num[0]=num[4];
        num[1]=num[5];
        num[4]=temp2;
        num[5]=temp1;
        return num;
    }
    public static int[] rReverse(int[] num) {
        int temp1,temp2;
        temp1=num[0];
        temp2=num[1];

        num[0]=num[5];
        num[1]=num[4];
        num[4]=temp1;
        num[5]=temp2;
        return num;
    }

    public static int[] fReverse(int[] num) {
        int temp2,temp3;
        temp2=num[2];
        temp3=num[3];

        num[2]=num[4];
        num[3]=num[5];
        num[4]=temp3;
        num[5]=temp2;
        return num;
    }
    public static int[] bReverse(int[] num) {
        int temp2,temp3;
        temp2=num[2];
        temp3=num[3];

        num[2]=num[5];
        num[3]=num[4];
        num[4]=temp2;
        num[5]=temp3;
        return num;
    }

    public static int[] aReverse(int[] num) {
        int temp0,temp1;
        temp0=num[0];
        temp1=num[1];

        num[0]=num[3];
        num[1]=num[2];
        num[2]=temp0;
        num[3]=temp1;
        return num;
    }
    public static int[] cReverse(int[] num) {
        int temp0,temp1;
        temp0=num[0];
        temp1=num[1];

        num[0]=num[2];
        num[1]=num[3];
        num[2]=temp1;
        num[3]=temp0;
        return num;
    }
    public static void main(String[] args) {

        int[] num={1,2,3,4,5,6};
        Scanner in = new Scanner(System.in);
        String string = in.next();
        char[] chars=string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'L':
                    lReverse(num);
                    break;

                case 'R':
                    rReverse(num);
                    break;

                case 'F':
                    fReverse(num);
                    break;

                case 'B':
                    bReverse(num);
                    break;
                case 'A':
                    aReverse(num);
                    break;

                case 'C':
                    cReverse(num);
                    break;
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.printf(num[i]+"");
        }
    }
}
