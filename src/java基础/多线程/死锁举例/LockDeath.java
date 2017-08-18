package java基础.多线程.死锁举例;

/**
 * Created by Jackson on 2017/8/18.
 */
public class LockDeath {
    private final Object ob1=new Object();
    private final Object ob2=new Object();

    public void leftRight() throws InterruptedException {
        synchronized (ob1){
            Thread.sleep(200);
            synchronized (ob2){
                System.out.println("leftRight end!");
            }
        }
    }
    public void rightLeft() throws InterruptedException {
        synchronized (ob2){
            Thread.sleep(200);
            synchronized (ob1){
                System.out.println("rightLeft end!");
            }
        }
    }
}
