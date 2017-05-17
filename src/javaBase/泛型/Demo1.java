package javaBase.泛型;

/**
 * 泛型接口
 */

public class Demo1 {
    public static void main(String arsg[]) {
        Info<String> obj = new InfoImp<String>("www.weixueyuan.net");
        System.out.println("Length Of String: " + obj.getVar().length());
    }
}

interface Info<T> {
    public T getVar();
}

class InfoImp<T> implements Info<T> {
    private T var;

    // 定义泛型构造方法
    public InfoImp(T var) {
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
}