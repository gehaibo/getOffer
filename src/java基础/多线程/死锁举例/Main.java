package java基础.多线程.死锁举例;

/**
 * Created by Jackson on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        LockDeath dl = new LockDeath();
        Thread0 t0 = new Thread0(dl);
        Thread2 t2 = new Thread2(dl);
        t0.start();
        t2.start();
    }
}
