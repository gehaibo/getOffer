package 设计模式.建造类.工厂方法模式;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        Factory factory=new ConcreteFactory();
        Product product=factory.createProduct(ConcreteProduct1.class);
    }
}
