package atest;

/**
 * Created by Jackson on 2017/7/23.
 */
public class TestGC {
    private String largeString = new String(new byte[100000]);

    String getString() {
        return this.largeString.substring(0,2);
    }

    public static void main(String[] args) {
        java.util.ArrayList list = new java.util.ArrayList();
        for (int i = 0; i < 1000000; i++) {
            TestGC gc = new TestGC();
            list.add(gc.getString());
        }
    }
}
