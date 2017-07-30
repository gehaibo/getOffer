package 设计模式.建造类.原型模式;

import java.util.ArrayList;

/**
 * 深度克隆
 */
public class DeepClone implements Cloneable{
    //定义一个共享的私有变量
    private ArrayList<String> arrayList=new ArrayList<>();
    @Override
    public DeepClone clone()  {
        DeepClone thing=null;
        try {
            thing= (DeepClone) super.clone();
            //私有变量也要拷贝
            thing.arrayList= (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}
