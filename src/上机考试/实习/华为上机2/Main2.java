package 上机考试.实习.华为上机2;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        while (input.hasNext()){
            String s=input.nextLine();
            ReverseWords(s);
        }

    }

    static void ReverseWords(String s){
        String[] strings=s.split("\\s+");
        Stack<String> stacks=new Stack<>();
        for (int i = 0; i <strings.length ; i++) {
            stacks.push(strings[i]);
        }
        String result="";
        while (stacks.size()>1){
            result=result+stacks.pop()+" ";
        }
        while (stacks.size()==1){
            result =result+stacks.pop();
        }
        System.out.println(result);
    }
}
