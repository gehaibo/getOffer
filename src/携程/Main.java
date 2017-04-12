package 携程;

import java.util.Scanner;

/**
 * Created by ghb on 2017/4/11.
 */
public class Main {

    public static int coutMax(int input) {
        int[] count = new int[50];
        int i = 0, number = 2, output = 1;

        //先从2分解成连续的数
        while (input >= number) {
            count[i++] = number;
            input -= number;
            number++;
        }

        if (input == 0) {
            if (input == count[i - i]) {
                count[i - 1]++;
                input--;
            }
        }

        for (int j = 0; j < input; j++) {
            count[i - 1 - j]++;
        }

        for (int k = 0; k <= i - 1;k++) {
            output *= count[k];
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int inputNumber = sc.nextInt();

            if (inputNumber <= 50) {
                System.out.println(coutMax(inputNumber));
            }
        }
    }
}