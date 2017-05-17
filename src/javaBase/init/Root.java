package javaBase.init;


/**
 * 继承初始化顺序
 * 先从原始父类将静态一次初始化，然后从父类开始挨个初始化代码块，构造器。。。依次到子类
 * Created by ghb on 2016/12/28.
 */
class First {

    public First() {
        System.out.println(1.3);
    }
    static {
        System.out.println(1.1);
    }
    {
        System.out.println(1.2);
    }
}

class Second extends First {
    static {
        System.out.println(2.1);
    }
    {
        System.out.println(2.2);
    }
    public Second() {
        System.out.println(2.3);
    }
    public Second(String msg){
        this();
        System.out.println(2.4);
    }
}

class Third extends Second {
    static {
        System.out.println(3.1);
    }
    {
        System.out.println(3.2);
    }
    public Third() {
        super("父类初始化");
        System.out.println(3.3);
    }
}

public class Root {
    public static void main(String[] args) {
        new Third();
        System.out.println("——————————————分界线————————————————");
        new Third();
    }
}
