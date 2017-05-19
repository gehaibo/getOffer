package 设计模式.建造类.工厂方法模式.简单工厂模式;

import 设计模式.建造类.工厂方法模式.Product;

/**
 * Created by Jackson on 2017/5/17.
 */
public class SimpleFactory {
    public static <T extends Product> T create(Class<T> c){
        Product product=null;
        try {
            product= (Product) Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return (T) product;
    }

}
