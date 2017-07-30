package java基础.多线程.生产者消费者.wait和notify;

import java.util.LinkedList;

public class Storage {

    private static final int MAX = 100;

    private LinkedList<Object> list = new LinkedList<>();

    public void produce(int num) {
        synchronized (list) {
            while (list.size() + num > MAX) {
                System.out.println("超出容量限制，暂时不能生产");
                try {
                    //生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("已经生产数量为：" + num + "总数量为：" + list.size());
        }
    }
}
