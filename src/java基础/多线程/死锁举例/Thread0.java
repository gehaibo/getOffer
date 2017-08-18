package java基础.多线程.死锁举例;

/**
 * Created by Jackson on 2017/8/18.
 */
public class Thread0 extends Thread{
    private LockDeath dl;

    public Thread0(LockDeath dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.leftRight();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
