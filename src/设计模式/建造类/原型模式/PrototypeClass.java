package 设计模式.建造类.原型模式;

/**
 * 通用模板
 */
public class PrototypeClass implements Cloneable{
    @Override
    public PrototypeClass clone()  {
        PrototypeClass prototypeClass=null;
        try {
            prototypeClass= (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
