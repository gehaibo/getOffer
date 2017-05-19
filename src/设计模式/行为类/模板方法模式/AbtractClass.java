package 设计模式.行为类.模板方法模式;

/**
 * 模板方法
 */
public abstract class AbtractClass {
    //基本方法：子类实现，被模板方法调用
    protected abstract void operation1();
    protected abstract void operation2();

    //模板方法：相当于一个框架，实现对基本方法的调度
    public void templateMethod()
    {
        operation1();
        operation2();
    }
}
