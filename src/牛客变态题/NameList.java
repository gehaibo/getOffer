package 牛客变态题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackson on 2017/4/25.
 *
 */
public class NameList {
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll()     {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) +" ");
        }
    }

    public static void main(String[]args)
    {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++)
        {
            new Thread(() -> {
                sl.add("A");
                sl.add("B");
                sl.add("C");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sl.printAll();
            }).start();
        }
    }
}
