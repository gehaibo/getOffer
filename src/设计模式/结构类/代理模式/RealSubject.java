package 设计模式.结构类.代理模式;

/**
 * 定义了一个类来实现这个接口，这个类就是我们的真实对象，RealSubject类：
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
