package 设计模式.单例模式;

/**
 * 懒汉模式
 */
public class Singleton {
    private Singleton() {
    }
    private static final Singleton singleton=new Singleton();

     Singleton getInstance(){
        return singleton;
    }
}
