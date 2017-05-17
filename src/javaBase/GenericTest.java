package javaBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghb on 2017/1/5.
 */
class Box<T> {
    private T data;
    public Box() {
    }
    public Box(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
public class GenericTest {

        public static void main(String[] args) {
            List list = new ArrayList();
            list.add("qqyumidi");
            list.add("corn");
            list.add(100);

            for (int i = 0; i < list.size(); i++) {
                String name = (String) list.get(i); // 1
                System.out.println("name:" + name);
            }
            Box<Number> number = new Box<Number>();
        }

}
