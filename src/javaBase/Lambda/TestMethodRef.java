package javaBase.Lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用:若Lambda体中的内容有方法已经实现了，那么我们可以使用"方法引用"
 *  (可以理解为方法引用时Lambda表达式的另外一种表现形式
 *
 * 主要有三种语法格式:
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意:
 *  1. Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保存一致
 *  2.若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 *  二、构造器引用
 *  格式:
 *      ClassName::new
 *  注意:需要调用的构造器方法与函数式接口中抽象方法的参数列表保持一致
 *
 *  三、数组引用
 *  Type::new;
 */
public class TestMethodRef {

    //数组引用:
    @Test
    public void test7(){
        Function<Integer, String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> fun1 = String[]::new;
        strs = fun1.apply(20);
        System.out.println(strs.length);
    }


    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = ()-> new Employee();
        Employee emp = sup.get();

        //构造器引用
        //根据参数列表自动匹配构造器
        Supplier<Employee> sup2 = Employee::new;
        emp = sup2.get();
        System.out.println(emp);
    }

    @Test
    public void test6(){
        Function<Integer,Employee> func = x -> new Employee(x);
        Employee emp = func.apply(10);
        System.out.println(emp);

        Function<Integer,Employee> func1 = Employee :: new;
        emp = func1.apply(10);
        System.out.println(emp);

        // BiFunction<Integer, Integer, Employee> bf = Employee::new;编译错误，没有两个Integer构造器
    }



    //对象::实例方法名
    @Test
    public void test1(){
        Consumer<String> con = x -> System.out.println(x);
        PrintStream ps =  System.out; //打印流
        //前提条件: Consumer中的方法体参数与返回值要与ps.println方法中的参数和返回值类型相同
        //Consumer： void accept(T t);在这里T为String
        //PrintStream:  public void println(String x)
        //两者传入的参数都为String,返回值都为void所以满足，可以使用方法引用
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;//这三种方式结果相同

        con.accept("huang");
        con1.accept("huang");
        con2.accept("huang");
    }


    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        Supplier<String> sup2 = emp::getName;

    }

    //---------------------------------------

    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) ->Integer.compare(x, y);
        //前提条件:和上面相同
        Comparator<Integer> com1 = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        boolean bool = bp.test(new String("huang"),"huang");
        System.out.println(bool);

        //前提:第一个参数是实例方法的调用者，第二个参数是实例方法的参数
        //例如 x 是equal方法的调用者，y是实例方法的参数
        BiPredicate<String,String> bp2 = String::equals;
        bool = bp2.test("huang","huang");
        System.out.println(bool);
    }

}