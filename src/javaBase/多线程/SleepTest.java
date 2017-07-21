package javaBase.多线程;

/**
 * Created by Jackson on 2017/7/15.
 */
public class SleepTest extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName = " + this.getName() + " begin:" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName = " + this.getName() + " end  :" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepTest mt = new SleepTest();
        System.out.println("begin = " + System.currentTimeMillis());
        mt.start();
        System.out.println("end   = " + System.currentTimeMillis());
    }
}
