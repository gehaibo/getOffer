package javaBase.多线程;

import java.util.concurrent.*;

/**
 * Created by ghb on 2017/4/6.
 */
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.Runnable创建
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        //2.Callable创建带有返回值的
        Future<Integer> task=new FutureTask<>(()->{
            int j = 0;
            for (; j < 100; j++) {
                System.out.println(Thread.currentThread().getName()+"循环变量i的值："+j);

            }
            return j;
        });
        new Thread((Runnable) task,"有返回值得线程").start();
        try {
            System.out.println("返回的参数为"+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //3.使用Executors
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        ExecutorService executor2 =Executors.newSingleThreadExecutor();
        ExecutorService executor3 =Executors.newCachedThreadPool();
        ExecutorService executor4 =Executors.newScheduledThreadPool(2);

        executor1.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        Future<Integer> futures=executor1.submit(()->{
            System.out.println("我有返回值");
            return 2;
        });
        System.out.println(futures.get());
        //线程中断

    }


}
