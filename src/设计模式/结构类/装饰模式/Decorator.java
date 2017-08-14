package 设计模式.结构类.装饰模式;

/**
 * Created by Jackson on 2017/8/14.
 */
public class Decorator implements Beverage{
    private String description = "我只是装饰器，不知道具体的描述";
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public double getPrice() {
        return 0;		//价格由子类来决定
    }

}
