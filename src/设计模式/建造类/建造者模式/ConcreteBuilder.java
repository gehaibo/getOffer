package 设计模式.建造类.建造者模式;

/**
 * 多个产品就有多个建造者
 */
public class ConcreteBuilder extends Builder{
    private Product product=new Product();

    @Override
    public void setPart() {
    //产品内部逻辑
    }
    @Override
    public Product buildProduct() {
        return product;
    }
}
