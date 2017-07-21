package javaBase.多线程;

/**
 * Created by ghb on 2017/2/15.
 */
public class DeadThread {
    public static void main(String[] args) {
        final Object resource1="resource1";
        final Object resource2="resource2";

        Runnable t1 = ()->{
            synchronized(resource1){
                System.out.println("Thread1:locked resource1");
                try{
                    Thread.sleep(50);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(resource2){
                    System.out.println("Thread1:locked resource2");
                }
            }
        };

        Runnable t2 = ()->{
          synchronized (resource2){
              System.out.printf("Thread2:locked resource2");
              try {
                  Thread.sleep(50);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              synchronized (resource1){
                  System.out.println("Thread2:locked resource1");
              }
          }
        };

        new Thread(t1,"新线程1").start();
        new Thread(t2,"新线程2").start();
    }
}
