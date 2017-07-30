package java基础.reflect.反射获取私有属性等;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Jackson on 2017/7/12.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        /**
         *  修改私有属性
         */

        Point p1=new Point(3,5);
        Class<?> clazz=p1.getClass();
        Field fieldY=clazz.getDeclaredField("y");
        //设置属性可编辑,否则报错
        fieldY.setAccessible(true);
        System.out.println(fieldY.get(p1));
        fieldY.set(p1,2);
        System.out.println(fieldY.get(p1));


        /**
         * 调用私有方法
         */
        Method method=clazz.getDeclaredMethod("draw", String.class);
        method.setAccessible(true);
        /**
         * method.invoke(owner, args)：执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组args，
         * 可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值。
         */
        method.invoke(clazz.newInstance(),"HelloWord!");

        /**
         * 调用构造方法
         */

        Class<?> clazz2=Class.forName("java基础.reflect.反射获取私有属性等.Point");


        Constructor<?>[] cons=clazz2.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            System.out.println("构造函数："+cons[i]);
        }

        //利用构造函数实例化类
        Point pt0= (Point) cons[2].newInstance();
        Point pt1= (Point) cons[1].newInstance(2);
        Point pt2= (Point) cons[0].newInstance(2,3);

        System.out.println(pt0);
        System.out.println(pt1);
        System.out.println(pt2);

    }
}
