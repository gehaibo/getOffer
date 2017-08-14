package 设计模式.行为类.观察者模式;

/**
 * Created by Jackson on 2017/8/14.
 */
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}
