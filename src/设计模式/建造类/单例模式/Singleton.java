package 设计模式.建造类.单例模式;

/**
 * 饿汉模式，instance在类装载时就实例化，天生线程安全
 */
public class Singleton {
    private Singleton() {}

    //由于是static，JVM加载时就会被创建
    private static final Singleton singleton = new Singleton();

    String string;
    public static Singleton getInstance() {
        return singleton;
    }
}

