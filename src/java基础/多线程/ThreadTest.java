package java基础.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ghb on 2017/4/6.
 */
public class ThreadTest extends Thread{
    //每个都是单独的i，无法共享
    private int i;

    //重写run方法
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println(getName()+" "+j);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);

            if (i==20){
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
        ReentrantLock look= new ReentrantLock();
    }


}
