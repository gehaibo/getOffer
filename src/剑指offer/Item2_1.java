package 剑指offer;

/**
 * Java单例模式(推荐一)
 * 饿汉式:在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
 * Created by ghb on 2016/12/23.
 */
public class Item2_1 {

    private Item2_1() {}
    private static final Item2_1 single = new Item2_1();

    //静态工厂方法
    public Item2_1 getInstance(){
        return single;
    }
}
