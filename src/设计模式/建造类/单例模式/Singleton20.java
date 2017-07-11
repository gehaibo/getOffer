package 设计模式.建造类.单例模式;

/**
 * 饿汉模式，instance在类装载时就实例化，天生线程安全
 */
public class Singleton20 {
    private Singleton20() {}

    private static final Singleton20 singleton = new Singleton20();

    public static Singleton20 getInstance() {
        return singleton;
    }
}

