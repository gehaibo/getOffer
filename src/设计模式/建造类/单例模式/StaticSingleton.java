package 设计模式.建造类.单例模式;

/**
 * 静态内部类延迟加载
 * StaticSingleton加载时，内部类不会被初始化，当调用时，才会加载内部类，初始化instance
 *
 * 但是通过反射机制，强行调用单例模式的私有函数，可以生成多个单例
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
