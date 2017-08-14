package 设计模式.建造类.工厂模式;

/**
 * 抽象工厂类，就是抽象工厂
 */
public abstract class Factory {
    /**
     *
     * @param c 创建的产品对象输入参数类型可以自行设置，通常为String，Enum，Class
     * @return
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
