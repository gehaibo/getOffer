package 设计模式.结构类.装饰模式;

/**
 * 具体被装饰的对象类,表示是咖啡
 */
public class CoffeeBean1 implements Beverage{
    private String description = "选了第一种咖啡豆";
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public double getPrice() {
        return 50;
    }
}
