package 设计模式.建造类.原型模式;

/**
 * Created by Jackson on 2017/7/24.
 */
public class CloneTest {
    public static void main(String[] args) {
        ShallowClone p1 = new ShallowClone();
        p1.setAge(11);
        p1.setName("浅克隆");
        ShallowClone p2 = p1.clone();

        System.out.println(p1 == p2);//false
    }
}
