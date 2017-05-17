package javaBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ghb on 2017/2/22.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception{

        ExecutorService pool = Executors.newFixedThreadPool(6);

        Runnable target1 = ()->{
           for (int i = 0; i<100;i++){
               System.out.println(Thread.currentThread().getName()+"的值i为"+i);
           }
        };

        pool.submit(target1);
        pool.submit(target1);

        pool.shutdown();
    }
}
