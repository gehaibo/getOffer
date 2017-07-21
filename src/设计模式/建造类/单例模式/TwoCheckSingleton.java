package 设计模式.建造类.单例模式;

/**
 * 双重检查锁定（double-checked locking）
 * 单例模式的最佳实现。内存占用地，效率高，线程安全，多线程操作原子性。
 */
public class TwoCheckSingleton {

    private TwoCheckSingleton() {}
    //定义一个静态私有变量，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用
    private static volatile TwoCheckSingleton instance;

    public static TwoCheckSingleton getIstance() {
        if (instance == null) {
            //对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建
            synchronized (TwoCheckSingleton.class) {
                //未初始化，则初始instance变量
                if (instance == null) {
                    instance = new TwoCheckSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 在线程执行到第13行代码读取到instance不为null时，instance引用的对象有可能还没有完成初始化
     *
     *前面的双重检查锁定示例代码的第9行（iinstance = new TwoCheckSingleton();）创建一个对象。这一行代码可以分解为如下的三行伪代码：
     * memory = allocate();   //1：分配对象的内存空间
     ctorInstance(memory);  //2：初始化对象
     instance = memory;     //3：设置instance指向刚分配的内存地址
     上面三行伪代码中的2和3之间，可能会被重排序
     */
}
