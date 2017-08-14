package 设计模式.行为类.观察者模式;

/**
 * Created by Jackson on 2017/8/14.
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为：" + observerState);
    }

}
