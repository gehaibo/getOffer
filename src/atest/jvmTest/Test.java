package atest.jvmTest;

/**
 * Created by Jackson on 2017/9/13.
 */
public class Test {
   private String name="son";

    public static void main(String[] args) {
        Test test=new Test();
       // System.out.println(test.getName());
    }
}
class Father{
    private String name = "father";
    public String getName(){
        return name;
    }
}