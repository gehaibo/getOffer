package java基础.clone;

/**
 * Created by ghb on 2016/12/30.
 */
public class User implements Cloneable{
    int age;
    String name;
    Address address;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
        address = new Address("华中科技大学");
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}
