package java基础.多线程.生产者消费者.wait和notify;

import java.util.concurrent.*;

public class ProducerConsumer3 {
    // 建立一个阻塞队列
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public ProducerConsumer3() {
    }

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer s3 = new ProducerConsumer();
        s3.start();
    }

    class Producer extends Thread {
        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    // 取出一个对象
                    queue.put(o);
                    System.out.println("Producer: " + o);
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
                // }
            }
        }
    }

    class Consumer extends Thread {
        public void run() {
            while (true) {
                try {
                    // 取出一个对象
                    Object o = queue.take();
                    System.out.println("Consumer: " + o);
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
                // }
            }
        }
    }

}