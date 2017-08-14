package 设计模式.建造类.工厂模式.多个工场类;

import 设计模式.建造类.工厂模式.Product;

/**
 * 多个工厂模式的抽象工厂类
 */
public abstract class AbstractFactory {
    public abstract Product createProduct();
}
