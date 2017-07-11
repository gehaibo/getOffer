package javaBase.thread;

import java.util.concurrent.*;

/**
 * Created by ghb on 2017/4/6.
 */
public class CreateThread {
    public static void main(String[] args) {
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
        FutureTask<Integer> task=new FutureTask<>(()->{
            int j = 0;
            for (; j < 100; j++) {
                System.out.println(Thread.currentThread().getName()+"循环变量i的值："+j);

            }
            return j;
        });
        new Thread(task,"有返回值得线程").start();
        try {
            System.out.println("返回的参数为"+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //3.使用Executors
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        //线程中断

    }


}
