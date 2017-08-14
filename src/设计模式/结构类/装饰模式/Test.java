package 设计模式.结构类.装饰模式;

/**
 * Created by Jackson on 2017/8/14.
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new CoffeeBean1();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + "\n加了摩卡和牛奶的咖啡价格：" + beverage.getPrice());

    }
}
