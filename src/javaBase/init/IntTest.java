package javaBase.init;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ghb on 2016/12/29.
 */
public class IntTest {
    public static void main(String[] args) {
        int i0 = 127;
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 0;
        Integer i4 = new Integer(127);
        Integer i5 = new Integer(127);
        Integer i6 = new Integer(0);

        System.out.println("i0=i1   "  +(i0==i1));//true
        System.out.println("i0=i4   "  +(i0==i4));//true

        System.out.println("i1=i2   " + (i1 == i2));//true
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));//true
        System.out.println("i1=i4   " + (i1 == i4));//false

        System.out.println("i4=i5   " + (i4 == i5));//false
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));//true
        System.out.println("127=i5+i6   " + (127 == i5 + i6));//true
        System.out.println("---------------------------");

        int i20 = 128;
        Integer i21 = 128;
        Integer i22 = 128;
        Integer i23 = 0;
        Integer i24 = new Integer(128);
        Integer i25 = new Integer(128);
        Integer i26 = new Integer(0);

        System.out.println("i20=i21   "  +(i20==i21));//true
        System.out.println("i20=i24   "  +(i20==i24));//true

        System.out.println("i21=i22   " + (i21 == i22));//!!!!!!false
        System.out.println("i21=i22+i23   " + (i21 == i22 + i23));//true
        System.out.println("i21=i24   " + (i21 == i24));//false

        System.out.println("i24=i25   " + (i24 == i25));//false
        System.out.println("i24=i25+i26   " + (i24 == i25 + i26));//true
        System.out.println("128=i25+i26   " + (128 == i25 + i26));//true

        Math.round(11.5);

        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        HashSet set;
        TreeSet set1;
        String a = "+-*/";
        System.out.println("lala"+a.contains("+"));
        Stack stack = new Stack();
        stack.push(1);
        int aa= (int) stack.pop();
       // System.out.println(a11=="a");
        FutureTask futureTask;
        Future future;
        Lock lc = new ReentrantLock();

    }
}
