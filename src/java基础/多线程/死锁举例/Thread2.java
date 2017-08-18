package java基础.多线程.死锁举例;

/**
 * Created by Jackson on 2017/8/18.
 */
public class Thread2 extends Thread{
    private LockDeath dl;

    public Thread2(LockDeath dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.rightLeft();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
