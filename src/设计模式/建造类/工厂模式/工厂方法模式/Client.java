package 设计模式.建造类.工厂模式.工厂方法模式;

import 设计模式.建造类.工厂模式.ConcreteProduct1;
import 设计模式.建造类.工厂模式.Product;

/**
 * Created by Jackson on 2017/5/17.
 */
public class Client {
    public static void main(String[] args) {

        Product product= SimpleFactory.create(ConcreteProduct1.class);
    }
}
