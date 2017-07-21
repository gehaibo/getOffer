package 设计模式.建造类.单例模式;

/**
 * Created by Jackson on 2017/7/21.
 */
public class UnsafeLazySingleton {
    private UnsafeLazySingleton() {
    }

    private static UnsafeLazySingleton singleton = null;

    public static UnsafeLazySingleton getLazySingleton() {
        if (singleton == null) {
            singleton = new UnsafeLazySingleton();
        }
        return singleton;
    }
}
