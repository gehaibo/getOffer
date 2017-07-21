package 设计模式.建造类.单例模式;

/**
 * 懒汉式线程安全版，加同步，效率低
 */
public class LazySingleton {
    private LazySingleton() {
    }

    //初始被赋予为null，确保启动时没有额外负担
    private static LazySingleton lazySingleton = null;

    //加同步
    public static synchronized LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
