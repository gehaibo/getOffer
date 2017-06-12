package 设计模式.建造类.单例模式;

/**
 * Created by Jackson on 2017/5/20.
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static  Singleton2 singleton = null;

    public static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
