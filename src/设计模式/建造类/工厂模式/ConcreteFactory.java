package 设计模式.建造类.工厂模式;

/**
 * 具体工厂类
 */
public class ConcreteFactory extends Factory{
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product=null;
        try {
            product= (Product) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
