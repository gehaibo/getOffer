package java基础.clone;

import java.util.Objects;

/**
 * Created by ghb on 2016/12/30.
 */
public class CloneTest implements Cloneable{

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1=new User(1,"lala");
        User user2= user1.clone();

        System.out.println(user1==user2);
        System.out.println(user2.age);
        Objects.hashCode(user1);

    }


}
