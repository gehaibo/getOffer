package java基础.泛型;

/**
 * 泛型擦除
 */
public class Demo3 {
    public static void main(String[] args) {
        Point p = new Point();  // 类型擦除
        p.setX(10);
        p.setY(20.8);
        int x = (Integer) p.getX();  // 向下转型
        double y = (Double) p.getY();
        System.out.println("This point is：" + x + ", " + y);
    }
}
