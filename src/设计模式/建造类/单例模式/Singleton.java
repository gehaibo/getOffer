package 设计模式.建造类.单例模式;

/**
 * 懒汉模式
 */
public class Singleton {
    private Singleton() {
    }

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}

