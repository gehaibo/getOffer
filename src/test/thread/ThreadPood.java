package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ghb on 2017/3/20.
 */
public class ThreadPood {
    public static void main(String[] args) {
        ExecutorService la = Executors.newFixedThreadPool(4);
    }
}
