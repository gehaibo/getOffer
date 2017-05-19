package 设计模式.建造类.建造者模式;

/**
 * 导演类
 */
public class Direct {
    private Builder builder=new ConcreteBuilder();
    //构建不同产品
    public Product getAPruduct(){
        builder.setPart();
        /**
         * 设置不同的零件
         */
        return builder.buildProduct();
    }
}