package 设计模式.建造类.工厂方法模式.多个工场类;

import 设计模式.建造类.工厂方法模式.ConcreteProduct2;
import 设计模式.建造类.工厂方法模式.Product;

/**
 * Created by Jackson on 2017/5/20.
 */
public class Factory2 extends AbstractFactory{
    @Override
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}
