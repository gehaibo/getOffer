package atest;

/**
 * Created by Jackson on 2017/9/13.
 */
public class San {
    private int count;

    public San(int bb) {
        count = bb;
    }

    public static void main(String[] args) {
        San s=new San(99);
        System.out.println(s.count);
    }
}
