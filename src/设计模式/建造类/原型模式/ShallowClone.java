package 设计模式.建造类.原型模式;

/**
 * 通用模板,浅克隆
 * 继承 Cloneable，实现clone
 *
 */
public class ShallowClone implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public ShallowClone clone()  {
        ShallowClone prototypeClass=null;
        try {
            prototypeClass= (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
