package 上机考试.实习.华为上机2;

import java.util.Scanner;

/**
 * Created by 葛海波 on 2017/6/28.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        while (input.hasNext()){
            String s=input.nextLine();
            coutNums(s);
        }

    }

    static boolean numbers(char ch){
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    static void coutNums(String s){

    }
}
