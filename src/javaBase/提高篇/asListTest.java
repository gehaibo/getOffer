package javaBase.提高篇;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jackson on 2017/7/9.
 */
public class asListTest {
    public static void main(String[] args) {
        //使用 8 个基本类型数组转换为列表时会存在一个比较有味的缺陷
        /**
         * asList 接受的参数是一个泛型的变长参数，我们知道基本数据类型是无法发型化的，
         * 也就是说 8 个基本类型是无法作为 asList 的参数的， 要想作为泛型参数就必须使用其所对应的包装类型。
         * 但是这个这个实例中为什么没有出错呢？因为该实例是将 int 类型的数组当做其参数，而在 Java 中数组是一个对象，它是可以泛型化的。
         * 所以该例子是不会产生错误的。既然例子是将整个 int 类型的数组当做泛型参数，那么经过 asList 转换就只有一个 int 的列表了
         */
        int[] ints={1,2,3,4,5};
        List list= Arrays.asList(ints);
        System.out.println("list的类型  "+list.get(0).getClass());
        System.out.println("list的size=="+list.size());


        Integer[] ints2={1,2,3,4,5};
        List list2= Arrays.asList(ints2);
        System.out.println("list2的类型  "+list2.get(0).getClass());
        System.out.println("list2的size=="+list2.size());

    }
}
