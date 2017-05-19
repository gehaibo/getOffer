package 设计模式.行为类.模板方法模式;

/**
 * Created by Jackson on 2017/5/18.
 */
public class Client {
    public static void main(String[] args) {
        AbtractClass class1=new ConcreteClassA();
        AbtractClass class2=new ConcreteClassB();

        //调用模板方法
        class1.templateMethod();
        class2.templateMethod();
    }
}
