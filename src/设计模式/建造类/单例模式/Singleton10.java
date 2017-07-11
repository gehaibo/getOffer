package 设计模式.建造类.单例模式;

/**
 * 懒汉式，线程不安全
 */
public class Singleton10 {
    private Singleton10() {}

    private static Singleton10 singleton = null;

    public static Singleton10 getInstance() {
        if (singleton == null) {
            singleton = new Singleton10();
        }
        return singleton;
    }
}
