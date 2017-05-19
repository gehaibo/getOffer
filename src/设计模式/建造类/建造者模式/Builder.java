package 设计模式.建造类.建造者模式;

/**
 * 抽象建造者
 */
public abstract class Builder {
    //设置不同的部分，以后的不同产品
    public abstract void setPart();
    //建造产品
    public abstract Product buildProduct();
}
