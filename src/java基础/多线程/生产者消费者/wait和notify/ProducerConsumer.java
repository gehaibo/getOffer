package java基础.多线程.生产者消费者.wait和notify;


import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList<Object> storeHouse = new LinkedList<>();
    private int MAX = 10;

    public ProducerConsumer() {
    }

//    public void start() {
//        new Producer().start();
//        new Comsumer().start();
//    }
//
//    class Producer extends Thread {
//        public void run() {
//            while (true) {
//                synchronized (storeHouse) {
//                    try {
//                        while (storeHouse.size() == MAX) {
//                            System.out.println("storeHouse is full , please wait");
//                            storeHouse.wait();
//                        }
//                        Object newOb = new Object();
//                        if (storeHouse.add(newOb)) {
//                            System.out.println("Producer put a Object to storeHouse");
//                            Thread.sleep((long) (Math.random() * 3000));
//                            storeHouse.notify();
//                        }
//                    } catch (InterruptedException ie) {
//                        System.out.println("producer is interrupted!");
//                    }
//
//                }
//            }
//        }
//    }
//
//    class Comsumer extends Thread {
//        public void run() {
//            while (true) {
//                synchronized (storeHouse) {
//                    try {
//                        while (storeHouse.size() == 0) {
//                            System.out.println("storeHouse is empty , please wait");
//                            storeHouse.wait();
//                        }
//                        storeHouse.removeLast();
//                        System.out.println("Comsumer get  a Object from storeHouse");
//                        Thread.sleep((long) (Math.random() * 3000));
//                        storeHouse.notify();
//                    } catch (InterruptedException ie) {
//                        System.out.println("Consumer is interrupted");
//                    }
//
//                }
//            }
//
//        }
//    }

    Runnable producer = () -> {
        while (true) {
            synchronized (storeHouse) {
                try {
                    while (storeHouse.size() == MAX) {
                        System.out.println("storeHouse is full , please wait");
                        storeHouse.wait();
                    }
                    Object newOb = new Object();
                    if (storeHouse.add(newOb)) {
                        System.out.println("Producer put a Object to storeHouse");
                        Thread.sleep((long) (Math.random() * 3000));
                        storeHouse.notify();
                    }
                } catch (InterruptedException ie) {
                    System.out.println("producer is interrupted!");
                }

            }

        }

    };
    Runnable consumer = () -> {
        while (true) {
            synchronized (storeHouse) {
                try {
                    while (storeHouse.size() == 0) {
                        System.out.println("storeHouse is empty , please wait");
                        storeHouse.wait();
                    }
                    storeHouse.removeLast();
                    System.out.println("Comsumer get  a Object from storeHouse");
                    Thread.sleep((long) (Math.random() * 3000));
                    storeHouse.notify();
                } catch (InterruptedException ie) {
                    System.out.println("Consumer is interrupted");
                }

            }
        }
    };

    public void start() {
        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        p.start();
        c.start();

    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer pc = new ProducerConsumer();
        pc.start();
        //pc.start();
    }
}