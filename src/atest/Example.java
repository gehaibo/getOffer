package atest;

/**
 * Created by Jackson on 2017/9/4.
 */
public class Example {
    String str="good";
    char[] ch={'a','b','c'};

    public static void main(String[] args) {
        Example ex=new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+"and ");
        System.out.println(ex.ch);
    }

    public void change(String str,char[] a){
        str="test ok";
        ch[0]='g';
    }
}
