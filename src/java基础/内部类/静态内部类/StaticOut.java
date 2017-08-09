package java基础.内部类.静态内部类;

/**
 * 里面声明了一个静态内部类
 */
public class StaticOut {
    int a;
    static int b =1;
    static class StaticIn{
        String c="nihao";
        public StaticIn() {
            System.out.println("静态内部类构造器");
        }
    }
}
