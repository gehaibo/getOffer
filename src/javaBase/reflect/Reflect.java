package javaBase.reflect;

import java.lang.reflect.Constructor;

/**
 * Created by ghb on 2017/2/27.
 */
public class Reflect {


    public Reflect(){

    }

    public Reflect(String s){
        System.out.println("参数是String类型");
    }

    public Reflect(int n, String str){
        System.out.println("参数是int和String类型");
    }
    public static void main(String[] args) throws ClassNotFoundException {

//        Reflect reflect = new Reflect();
//        System.out.println(reflect.getClass().getName());
        Class<?> classes=Class.forName("javaBase.reflect.Reflect");
        Constructor<?>[] con=classes.getConstructors();
        for (Constructor cons: con) {
            System.out.println(cons+"---"+cons.getName());
            Class<?>[] constructor = cons.getParameterTypes();
            for (Class s :
                    constructor) {
                System.out.println(s.getName()+"     ");
            }
        }

        String s = "";
    }
}
