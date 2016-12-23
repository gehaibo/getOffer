package offer;

/**
 * 单例模式（推荐二）
 * 静态内部类:既实现了线程安全，又避免了同步带来的性能影响
 * Created by ghb on 2016/12/23.
 */
public class Item2_2 {

    //静态内部类初始化
    private static class innerClass{
        private static final Item2_2 single = new Item2_2();
    }
    private Item2_2() {}

    public Item2_2 getInstance(){
        return innerClass.single;
    }
}
