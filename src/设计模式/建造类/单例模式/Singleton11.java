package 设计模式.建造类.单例模式;

/**
 * 懒汉式线程安全版，加同步，效率低
 */
public class Singleton11 {
    private Singleton11(){}

    private static Singleton11 singleton11;

    public static synchronized Singleton11 getSingleton11() {
        if (singleton11==null){
            singleton11=new Singleton11();
        }
        return singleton11;
    }
}
