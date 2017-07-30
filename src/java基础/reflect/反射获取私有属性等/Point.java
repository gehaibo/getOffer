package java基础.reflect.反射获取私有属性等;

/**
 * Created by Jackson on 2017/7/12.
 */
public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x) {
        this.x = x;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void draw(String msg) {
        System.out.println("msg=" + msg);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
