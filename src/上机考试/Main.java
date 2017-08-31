package 上机考试;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/26.
 */
public class Main {
    public static int find(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int sum = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum >= 0)
                sum += array[i];
            else
                sum = array[i];

            if (sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        String string = in.nextLine();
        String[] a = string.trim().split(" ");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        System.out.println(find(arr));
        //  }
    }
}
